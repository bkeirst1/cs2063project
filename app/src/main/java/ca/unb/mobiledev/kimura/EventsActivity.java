package ca.unb.mobiledev.kimura;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class EventsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("Events", "onCreate() called");
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.events_activity);

        menuHandler();
    }

    private void menuHandler() {
        Button rosterButton;
        Button compareButton;
        Button createButton;
        rosterButton = findViewById(R.id.btnRoster);
        rosterButton.setOnClickListener(v -> {
            Intent intent = new Intent(EventsActivity.this, RosterActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            EventsActivity.this.startActivity(intent);
        });
        compareButton = findViewById(R.id.btnCompare);
        compareButton.setOnClickListener(v -> {
            Intent intent = new Intent(EventsActivity.this, CompareActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            EventsActivity.this.startActivity(intent);
        });
        createButton = findViewById(R.id.btnCreate);
        createButton.setOnClickListener(v -> {
            Intent intent = new Intent(EventsActivity.this, CreateActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            EventsActivity.this.startActivity(intent);
        });
    }
}
