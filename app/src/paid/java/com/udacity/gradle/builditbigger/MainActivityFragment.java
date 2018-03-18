package com.udacity.gradle.builditbigger;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import com.nloops.androidjokesmodule.JokesActivity;


public class MainActivityFragment extends Fragment {

    ProgressBar progressBar;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragment_main, container, false);
        Button jokeButton = (Button) root.findViewById(R.id.btn_paid_joke);
        progressBar = (ProgressBar) root.findViewById(R.id.progress_activity);
        jokeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadJoke();
            }
        });

        return root;
    }

    /**
     * helper method to load joke
     */
    @SuppressLint("StaticFieldLeak")
    private void loadJoke() {
        new EndpointsAsyncTask() {
            @Override
            protected void onPreExecute() {
                if (progressBar != null) {
                    progressBar.setVisibility(View.VISIBLE);
                }
            }

            @Override
            protected void onPostExecute(String s) {
                if (s != null) {
                    startDisplayIntent(s);
                }

                progressBar.setVisibility(View.GONE);
            }
        }.execute();
    }

    /**
     * Helper method that take the result of AsyncTask and pass to Joke Activity
     *
     * @param result
     */
    private void startDisplayIntent(String result) {
        Intent intent = new Intent(getActivity(), JokesActivity.class);
        intent.putExtra("joke", result);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        getActivity().startActivity(intent);
    }


}
