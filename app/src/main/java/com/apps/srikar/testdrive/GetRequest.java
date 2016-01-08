package com.apps.srikar.testdrive;

import android.app.Activity;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetRequest extends AsyncTask<String, Void, String> {

    Activity activity;

    public GetRequest(Activity activity) {
        this.activity = activity;
    }

    @Override
    protected String doInBackground(String... params) {
        URL obj;
        String url = params[0];
        try {
            obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            //add request header
            con.setRequestProperty("User-Agent", "Mozilla/5.0");
            int responseCode = con.getResponseCode();
            System.out.println("\nSending 'GET' request to URL : " + url);
            System.out.println("Response Code : " + responseCode);
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            System.out.println(response.toString());
            return response.toString();
            //print result
        } catch (IOException ignored) {
        }
        return "Error";
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        ((MainActivity)activity).updateValues(s);

    }
}
