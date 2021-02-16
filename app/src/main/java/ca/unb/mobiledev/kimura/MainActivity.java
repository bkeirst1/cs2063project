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
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Fighter> fighters;

    private ArrayList<Event> events;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.e("main", "oncreate");
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        fighters = new ArrayList<Fighter>();
        events = new ArrayList<Event>();

        menuHandler();
    }

    protected void onStart() {
        super.onStart();
        WebScraper scraper = new WebScraper(this);
        try {
            scraper.execute().get(); //SCRAPE DATA
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addFighter(Fighter fighter) {
        fighters.add(fighter);
    }

    public void addEvent(Event event) {
        events.add(event);
    }

    private void menuHandler() {
        Button rosterButton;
        Button createButton;
        Button compareButton;
        rosterButton = findViewById(R.id.btnRoster);
        rosterButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, RosterActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            MainActivity.this.startActivity(intent);
        });
        createButton = findViewById(R.id.btnCreate);
        createButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, CreateActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            MainActivity.this.startActivity(intent);
        });
        compareButton = findViewById(R.id.btnCompare);
        compareButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, CompareActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            MainActivity.this.startActivity(intent);
        });
    }

    public void onPause() {
        super.onPause();
        overridePendingTransition(0, 0);
    }
}