package com.nloops.androidjokesmodule;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class JokesActivity extends AppCompatActivity {

    private TextView jokeTextView;
    public static final String INTENT_EXTRAS = "joke";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jokes);
        jokeTextView = findViewById(R.id.tv_text_joke);

        Intent intent = getIntent();
        if (intent.hasExtra(INTENT_EXTRAS)) {
            jokeTextView.setText(intent.getStringExtra(INTENT_EXTRAS));
        } else {
            Toast.makeText(this,
                    getString(R.string.no_passed_joke),
                    Toast.LENGTH_LONG).show();
        }

    }
}
