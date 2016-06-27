package com.example;

import java.util.ArrayList;
import java.util.Random;

public class Jokes
{
    private ArrayList<String> jokesList;

    public Jokes()
    {
        jokesList=new ArrayList<>();
        jokesList.add("What do you do?\n" + "\n" + "Read Books!\n" + "\n" + "That means Potato Potahto!\n");
        jokesList.add("What happens to a frog's car when it breaks down?\n" + "\n" + "It gets toad away.\n");
        jokesList.add("Why was six scared of seven?\n" + "\n" + "Because seven 'ate' nine.\n");
        jokesList.add(" What is the difference between snowmen and snowwomen? \n" + "\n" + "Snowballs.\n");
        jokesList.add("Why was the fish expelled from school?\n" + "\n" + "Because he was caught with seaweed.\n");
        jokesList.add("How do you stop a fish from smelling?\n" + "\n" + "Just cut its nose off.\n");
        jokesList.add("How would you name a fish which doesnt have an eye?\n" + "\n" + "FSH!\n");
        jokesList.add("Do you know what cows usually do for entertainment?\n" + "\n" + "They rent moo-oo-oo-vies!\n");
    }
    public String getJoke()
    {
        Random random=new Random();
        return jokesList.get(random.nextInt(jokesList.size()));
    }
}
