package com.fhery021.spring.service;

import com.fhery021.spring.model.Joke;
import com.fhery021.spring.repository.JokeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Ferenc on 1/2/2019.
 */
@Service
public class JokeServiceImpl implements JokeService{


    @Autowired
    private JokeRepository jokeRepository;

    @Override
    public Joke getRandomJoke() {
        long size  = jokeRepository.count();

        return jokeRepository.findById(ThreadLocalRandom.current().nextLong(1, size)).get();
    }

    // TODO
    @Override
    public List<Joke> getJokesByIdRange(Long begin, Long end) {
        return null;
    }

    @Override
    public void saveJokes(List<Joke> jokes) {
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


}
