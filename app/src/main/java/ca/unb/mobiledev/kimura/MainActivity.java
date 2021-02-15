package ca.unb.mobiledev.kimura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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

public class MainActivity extends AppCompatActivity {

    private ArrayList<Fighter> fighters;

    private ArrayList<Event> events;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fighters = new ArrayList<Fighter>();
        events = new ArrayList<Event>();

        WebScraper scraper = new WebScraper(this);
        try {
            scraper.execute().get(); //SCRAPE DATA
        } catch (Exception e) {
            e.printStackTrace();
        }
//        for(Fighter fighter: fighters) {
//            System.out.println(fighter.getLastName());
//        }
//        for(Event event: events) {
//            System.out.println(event.getTitle());
//        }
        //NOTE<----NEED TO FIND SOME WAY TO WAIT FOR SCRAPEDATA() METHOD TO FINISH BEFORE ACCESSING ARRAYS.
    }

    public void addFighter(Fighter fighter) {
        fighters.add(fighter);
    }

    public void addEvent(Event event) {
        events.add(event);
    }
}