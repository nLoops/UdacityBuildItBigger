package com.udacity.gradle.builditbigger.backend;

import com.nloops.jokeslib.JokesProvider;

/**
 * The object model for the data we are sending through endpoints
 */
public class MyBean {

    private String myData;
    private JokesProvider mJokesProvider;

    public MyBean() {
        mJokesProvider = new JokesProvider();
    }

    public String getData() {
        return mJokesProvider.getRandomJoke();
    }

}