package com.fhery021.spring.model;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class JokeTest {

    private static final String JOKE_EXAMPLE = "404 joke not found";
    private static final Long ID = 1L;

    Joke joke;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        joke = new Joke(JOKE_EXAMPLE);
        joke.setId(ID);
    }

    @Test
    void constructor(){
        assertNotNull(joke);
        assertEquals(JOKE_EXAMPLE, joke.getJoke());
        assertEquals(ID, joke.getId());
    }

    @Test
    void addRates(){
        Set<Rate> rates = Stream.of(new Rate.RateBuilder().id(1L).joke(joke).stars((byte) 1).build(),
                new Rate.RateBuilder().id(2L).joke(joke).stars((byte) 5).build())
                .collect(Collectors.toSet());
        joke.setRates(rates);

        assertNotNull(joke.getRates());
        assertEquals(joke.getRates(), rates);
    }


}