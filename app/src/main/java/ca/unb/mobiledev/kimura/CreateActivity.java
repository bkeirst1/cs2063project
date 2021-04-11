package ca.unb.mobiledev.kimura;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class CreateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("Create", "onCreate() called");
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.create_activity);

        EditText title = (EditText)(findViewById(R.id.eventTitle));
        EditText date = (EditText)(findViewById(R.id.date));
        EditText location = (EditText)(findViewById(R.id.location));
        title.setHint("Event Title");
        date.setHint("Date");
        location.setHint("Location");
        menuHandler();
    }

    private void menuHandler() {
        Button rosterButton;
        Button eventsButton;
        Button compareButton;
        rosterButton = findViewById(R.id.btnRoster);
        rosterButton.setOnClickListener(v -> {
            Intent intent = new Intent(CreateActivity.this, RosterActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            CreateActivity.this.startActivity(intent);
        });
        eventsButton = findViewById(R.id.btnEvents);
        eventsButton.setOnClickListener(v -> {
            Intent intent = new Intent(CreateActivity.this, EventsActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            CreateActivity.this.startActivity(intent);
        });
        compareButton = findViewById(R.id.btnCompare);
        compareButton.setOnClickListener(v -> {
            Intent intent = new Intent(CreateActivity.this, CompareActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            CreateActivity.this.startActivity(intent);
        });
    }
}
