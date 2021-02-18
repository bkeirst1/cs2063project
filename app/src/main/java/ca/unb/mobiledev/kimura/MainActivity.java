package ca.unb.mobiledev.kimura;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

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