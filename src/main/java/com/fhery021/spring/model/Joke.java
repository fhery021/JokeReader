package com.fhery021.spring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Ferenc on 12/31/2018.
 */
@Entity
public class Joke {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String Joke;

    public Joke(String joke) {
        Joke = joke;
    }

    public Joke(){}


    public String getJoke() {
        return Joke;
    }

    public void setJoke(String joke) {
        Joke = joke;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
