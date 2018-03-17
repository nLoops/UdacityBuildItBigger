package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.util.Pair;
import android.view.View;
import android.widget.ProgressBar;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;
import com.udacity.gradle.builditbigger.backend.myApi.model.MyBean;
import com.nloops.androidjokesmodule.JokesActivity;

import java.io.IOException;

/**
 * This class will manage background task to get data from java library
 */

public class EndpointsAsyncTask extends AsyncTask<Pair<Context, String>, Void, String> {

    private static MyApi myApiService = null;
    private Context mContext;
    private ProgressBar mProgressBar;

    public EndpointsAsyncTask(Context context, ProgressBar progressBar) {
        this.mContext = context;
        this.mProgressBar = progressBar;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        if (mProgressBar != null) {
            mProgressBar.setVisibility(View.VISIBLE);
        }

    }

    @Override
    protected String doInBackground(Pair<Context, String>[] pairs) {
        if (myApiService == null) {
            MyApi.Builder builder = new MyApi.Builder(
                    AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(),
                    null)
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/");
            myApiService = builder.build();
        }

        try {
            return myApiService.provideJoke(new MyBean()).execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        mProgressBar.setVisibility(View.INVISIBLE);
        startDisplayIntent(s);
    }

    private void startDisplayIntent(String result) {
        Intent intent = new Intent(mContext, JokesActivity.class);
        intent.putExtra("joke", result);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mContext.startActivity(intent);

    }
}
