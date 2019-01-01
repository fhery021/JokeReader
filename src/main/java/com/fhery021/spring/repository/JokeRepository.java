package com.fhery021.spring.repository;

import com.fhery021.spring.model.Joke;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Ferenc on 1/1/2019.
 */
public interface JokeRepository extends CrudRepository<Joke, Long>{
}
