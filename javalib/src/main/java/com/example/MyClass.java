package com.example;

import java.util.Random;

public class MyClass {

    private static final String[] JOKES = {"Joke 1", "Joke 2", "Joke 3", "Joke 4"};

    public static String getJokes() {
        Random rand = new Random();
        return JOKES[rand.nextInt(JOKES.length)];
    }
}
