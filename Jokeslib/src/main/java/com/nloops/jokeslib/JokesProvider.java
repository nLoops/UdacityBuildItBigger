package com.nloops.jokeslib;

import java.util.Random;

/**
 * This class will act like a provider of jokesStrings to make it easy to provide android app with jokesStrings
 */
public class JokesProvider {

    // String array that contains jokes
    private String[] jokesStrings;
    // Random to use to provide random joke once.
    private Random random;

    public JokesProvider() {
        jokesStrings = new String[5];
        jokesStrings[0] = "A family of mice were surprised by a big cat. Father Mouse jumped and and said, \"Bow-wow!\" The cat ran away. \"What was that, Father?\" asked Baby Mouse. \"Well, son, that's why it's important to learn a second language.\" ";
        jokesStrings[1] = "The doctor to the patient: 'You are very sick' \n" +
                "The patient to the doctor: 'Can I get a second opinion?' \n" +
                "The doctor again: 'Yes, you are very ugly too...'\n" +
                "I use this joke for retelling in reported speech. ";
        jokesStrings[2] = "A man goes to the doctor and says, \"Doctor, wherever I touch, it hurts.\" \n" +
                "The doctor asks, \"What do you mean?\" \n" +
                "The man says, \"When I touch my shoulder, it really hurts. If I touch my knee - OUCH! When I touch my forehead, it really, really hurts.\" \n" +
                "The doctor says, \"I know what's wrong with you - you've broken your finger!\" ";
        jokesStrings[3] = "Patient: Doctor, I have a pain in my eye whenever I drink tea. \n" +
                "Doctor: Take the spoon out of the mug before you drink. ";
        jokesStrings[4] = "Mother: \"Did you enjoy your first day at school?\" \n" +
                "Girl: \"First day? Do you mean I have to go back tomorrow? ";
        random = new Random();

    }

    /**
     * return jokes array
     *
     * @return
     */
    public String[] getJokesStrings() {
        return jokesStrings;
    }

    /**
     * pick random joke from jokes array
     *
     * @return
     */
    public String getRandomJoke() {
        return jokesStrings[random.nextInt(jokesStrings.length)];
    }
}
