package com.fhery021.spring.service;

import com.fhery021.spring.model.Joke;

import java.util.List;
import java.util.Optional;

/**
 * Created by Ferenc on 1/2/2019.
 */
public interface JokeService {
    Joke getRandomJoke();

    List<Joke> getJokesByIdRange(Long begin, Long end);

    void saveAll(List<Joke> jokes);

    void save(Joke joke);

    List<Joke> getAllJokes();

    void deleteAll();

    Long count();

    Optional<Joke> getById(Long id);
}
