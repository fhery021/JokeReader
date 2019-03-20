package com.fhery021.spring.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Rate extends BaseEntity{

    @Builder
    public Rate(Long id, Joke joke, byte stars) {
        super(id);
        this.stars = stars;
        this.joke = joke;
    }

    private byte stars;

    @ManyToOne
    @JoinColumn(name = "joke_id")
    private Joke joke;

}
