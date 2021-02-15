package ca.unb.mobiledev.kimura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Fighter> fighters;
    private ArrayList<Event> events;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fighters = new ArrayList<Fighter>();
        events = new ArrayList<Event>();
        scrapeData();
        //NOTE<----NEED TO FIND SOME WAY TO WAIT FOR SCRAPEDATA() METHOD TO FINISH BEFORE ACCESSING ARRAYS.
    }

    private void scrapeData() {
        //web scraper
    }
}