package com.nloops.androidjokesmodule;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokesActivity extends AppCompatActivity {

    TextView jokeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jokes);
        jokeTextView = findViewById(R.id.tv_text_joke);

        Intent intent = getIntent();
        if (intent.hasExtra("joke")) {
            jokeTextView.setText(intent.getStringExtra("joke"));
        }

    }
}
