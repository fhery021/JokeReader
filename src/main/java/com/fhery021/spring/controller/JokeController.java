package com.fhery021.spring.controller;

import com.fhery021.spring.csv.JokeReader;
import com.fhery021.spring.model.Joke;
import com.fhery021.spring.service.JokeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Ferenc on 1/1/2019.
 */
@Controller
@RequestMapping(path = "/jokes")
public class JokeController {

    private JokeReader jokeReader;

    private final JokeService jokeService;

    public JokeController(JokeReader jokeReader, JokeService service) {
        this.jokeReader = jokeReader;
        this.jokeService = service;
    }

    @GetMapping(path = "/initDB")
    public @ResponseBody String addAll(){
        jokeService.deleteAll();
        List<Joke> jokes =  jokeReader.processInputFile();
        System.out.println(jokes.size());

        jokes.forEach(jokeService::save);

        return "All jokes added to DB.";
    }

    @GetMapping(path = "/addFirst50")
    @ResponseBody
    public List<Joke> addFirst50(){
        List<Joke> allJokes =  jokeReader.processInputFile();

        jokeService.saveAll(allJokes.subList(0,50));

        return jokeService.getAllJokes();

    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Joke> getAllJokes(){
        return jokeService.getAllJokes();
    }

    @GetMapping(path = "/getRandomJoke")
    @ResponseBody
    public Joke getRandomJoke(){
        return jokeService.getRandomJoke();
    }

    @GetMapping(path = "/getRandomJokes/{size}")
    @ResponseBody
    public List<Joke> getRandomJokes(@PathVariable Long size){
        if (size == null){
            return null;
        }
        List<Joke> jokes = new ArrayList<>();
        final Long total = jokeService.count();
        for (int i=0; i<size; i++){
            jokeService.getById(ThreadLocalRandom.current().nextLong(1, total)).ifPresent(jokes::add);
        }

        return jokes;
    }


}
