package com.udacity.gradle.builditbigger;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;


public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragment_main, container, false);
        Button jokeButton = (Button) root.findViewById(R.id.btn_paid_joke);
        final ProgressBar progressBar = (ProgressBar) root.findViewById(R.id.progress_activity);
        jokeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new EndpointsAsyncTask(root.getContext(), progressBar).execute();
            }
        });

        return root;
    }


}
