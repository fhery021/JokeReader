package com.fhery021.spring.controller;

import com.fhery021.spring.csv.JokeReader;
import com.fhery021.spring.model.Joke;
import com.fhery021.spring.repository.JokeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Ferenc on 1/1/2019.
 */
@Controller
@RequestMapping(path = "/jokes")
public class JokeController {

    @Autowired
    private JokeRepository jokeRepository;

    @Autowired
    private JokeReader jokeReader;

    @GetMapping(path = "/addAll")
    public @ResponseBody String addAll(){
        List<Joke> jokes =  jokeReader.processInputFile();
        System.out.println(jokes.get(0).getJoke());
        System.out.println(jokes.get(1).getJoke());
        System.out.println(jokes.size());

        jokes.forEach(jokeRepository::save);

        return "All jokes added to DB.";
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Joke> getAllJokes(){
        return jokeRepository.findAll();
    }
}
