package com.fhery021.spring;

import com.fhery021.spring.csv.JokeReader;
import com.fhery021.spring.model.Joke;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class JokesReaderApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(JokesReaderApplication.class, args);

	}

}

