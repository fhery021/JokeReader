package com.fhery021.spring.service;

import com.fhery021.spring.model.Joke;
import com.fhery021.spring.repository.JokeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Ferenc on 1/2/2019.
 */
@Service
public class JokeServiceImpl implements JokeService{


    @Autowired
    private JokeRepository jokeRepository;

    @Override
    public Optional<Joke> getById(Long id){
        return jokeRepository.findById(id);
    }

    @Override
    public Joke getRandomJoke() {
        long size  = jokeRepository.count();

        return jokeRepository.findById(ThreadLocalRandom.current().nextLong(1, size)).get();
    }

    @Override
    public List<Joke> getJokesByIdRange(Long begin, Long end) {
        List<Joke> jokeList = new ArrayList<>();
        for (long id=begin; id<=end; id++){
           jokeRepository.findById(id).ifPresent(jokeList::add);
        }
        return jokeList;
    }

    @Override
    public void saveAll(List<Joke> jokes) {
        jokeRepository.saveAll(jokes);
    }

    @Override
    public void save(Joke joke) {
        jokeRepository.save(joke);
    }

    @Override
    public List<Joke> getAllJokes() {
        List<Joke> jokeList = new ArrayList<>();
        jokeRepository.findAll().forEach(jokeList::add);
        return jokeList;
    }

    @Override
    public void deleteAll() {
        jokeRepository.deleteAll();
    }

    @Override
    public Long count() {
        return jokeRepository.count();
    }
}
