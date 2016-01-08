package com.apps.srikar.testdrive;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new GetRequest(this).execute("http://weather.yahooapis.com/forecastrss?w=2295420&u=c&d=10");
    }

    public void updateValues(String s) {
        TextView tv = (TextView) findViewById(R.id.response);
        tv.setText(s);
    }
}
