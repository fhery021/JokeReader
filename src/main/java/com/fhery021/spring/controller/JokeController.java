package com.fhery021.spring.controller;

import com.fhery021.spring.csv.JokeReader;
import com.fhery021.spring.model.Joke;
import com.fhery021.spring.service.JokeService;
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
    private JokeReader jokeReader;

    @Autowired
    private JokeService jokeService;

//    @GetMapping(path = "/addAll")
//    public @ResponseBody String addAll(){
//        List<Joke> jokes =  jokeReader.processInputFile();
//        System.out.println(jokes.size());
//
//        jokes.forEach(jokeRepository::save);
//
//        return "All jokes added to DB.";
//    }

    @GetMapping(path = "/addFirst50")
    @ResponseBody
    public List<Joke> addFirst50(){
        List<Joke> allJokes =  jokeReader.processInputFile();

        jokeService.saveJokes(allJokes.subList(0,50));

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

}
