package com.fhery021.spring.service;

import com.fhery021.spring.model.Joke;

import java.util.List;

/**
 * Created by Ferenc on 1/2/2019.
 */
public interface JokeService {
    Joke getRandomJoke();

    List<Joke> getJokesByIdRange(Long begin, Long end);

    void saveJokes(List<Joke> jokes);

    void save(Joke joke);

    List<Joke> getAllJokes();
}
