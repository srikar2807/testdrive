package com.apps.srikar.testdrive;

import android.app.Activity;
import android.os.AsyncTask;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetRequest extends AsyncTask<String, Void, String> {

    MainActivity activity;

    public GetRequest(MainActivity activity) {
        this.activity = activity;
    }

    @Override
    protected String doInBackground(String... params) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(params[0]).build();
        Response responses;
        try {
            responses = client.newCall(request).execute();
            return responses.body().string();
        } catch (IOException ignored) {
        }
        return "Error";
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        activity.updateValues(s);
    }
}
