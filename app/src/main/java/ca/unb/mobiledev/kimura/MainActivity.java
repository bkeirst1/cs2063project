package ca.unb.mobiledev.kimura;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.StrictMode;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.e("main", "oncreate");
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        switchContexts();
    }

    protected void onStart() {
        super.onStart();
        WebScraper scraper = new WebScraper(this);
        try {
            scraper.execute().get();//SCRAPE DATA
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void switchContexts() {
        Intent intent = new Intent(MainActivity.this, EventsActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        MainActivity.this.startActivity(intent);
    }

}