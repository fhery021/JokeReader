package com.fhery021.spring.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Ferenc on 12/31/2018.
 */
@Entity
@Getter
@Setter
public class Joke {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String Joke;

    private Long views;
    private Long likes;
    private Long dislikes;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "joke")
    private Set<Rate> rates = new HashSet<>();

    public Joke(String joke) {
        Joke = joke;
    }

    public Joke(){}
}
