package com.udacity.gradle.builditbigger;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.nloops.androidjokesmodule.JokesActivity;


public class MainActivityFragment extends Fragment {

    private ProgressBar mProgressBar;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragment_main, container, false);

        Button jokeButton = (Button) root.findViewById(R.id.btn_free_joke);
        mProgressBar = (ProgressBar) root.findViewById(R.id.progress_activity);
        jokeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadJoke();
            }
        });

        AdView mAdView = (AdView) root.findViewById(R.id.adView);
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);
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
                if (mProgressBar != null) {
                    mProgressBar.setVisibility(View.VISIBLE);
                }
            }

            @Override
            protected void onPostExecute(String s) {
                if (s != null) {
                    startDisplayIntent(s);
                } else {
                    Toast.makeText(getActivity().getApplicationContext(),
                            "Cannot get data from server", Toast.LENGTH_LONG).show();
                }

                mProgressBar.setVisibility(View.GONE);
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
        intent.putExtra(JokesActivity.INTENT_EXTRAS, result);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        getActivity().startActivity(intent);
    }


}
