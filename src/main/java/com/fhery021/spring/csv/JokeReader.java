package com.fhery021.spring.csv;

import com.fhery021.spring.model.Joke;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by Ferenc on 12/31/2018.
 */
@Service
public class JokeReader {

    @Value("classpath:reddit-jokes.csv")
    private Resource res;

    public List<Joke> processInputFile(){
        List<Joke> inputList = new ArrayList<>();
        try {
            File in = new File(res.getURI());
            InputStream inputStream = new FileInputStream(in);
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            inputList = br.lines().skip(1).map(mapToItem).collect(Collectors.toList());
        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return inputList;
    }

    private final Function<String, Joke> mapToItem = (line) ->{
        String[] p = line.split(",\"");

        if (p[1] != null && p[1].trim().length() > 0){
            char lastChar = p[1].charAt(p[1].length()-1);
            if ( lastChar== '"'){
                p[1] = p[1].substring(0, p[1].length()-1);
            }
            return new Joke(p[1]);
        }

        return null;
    };


}
