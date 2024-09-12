package com.example.websocketssample;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class Jokes {

    public String randomJoke() {
        String[] jokes = {
                "Why don't scientists trust atoms? Because they make up everything!",
                "Why did the scarecrow win an award? Because he was outstanding in his field!",
                "Why don't skeletons fight each other? They don't have the guts.",
                "What do you call fake spaghetti? An impasta!",
                "What do you call cheese that isn't yours? Nacho cheese!"
        };

        Random rand = new Random();
        int randomIndex = rand.nextInt(jokes.length);
       return jokes[randomIndex];
    }





}
