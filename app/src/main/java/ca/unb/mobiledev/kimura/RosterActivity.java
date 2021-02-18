package ca.unb.mobiledev.kimura;

import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RosterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("Roster", "onCreate() called");
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.roster_activity);

        menuHandler();
    }

    private void menuHandler() {
        Button eventsButton;
        Button createButton;
        Button compareButton;
        eventsButton = findViewById(R.id.btnEvents);
        eventsButton.setOnClickListener(v -> {
            Intent intent = new Intent(RosterActivity.this, EventsActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            RosterActivity.this.startActivity(intent);
        });
        createButton = findViewById(R.id.btnCreate);
        createButton.setOnClickListener(v -> {
            Intent intent = new Intent(RosterActivity.this, CreateActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            RosterActivity.this.startActivity(intent);
        });
        compareButton = findViewById(R.id.btnCompare);
        compareButton.setOnClickListener(v -> {
            Intent intent = new Intent(RosterActivity.this, CompareActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            RosterActivity.this.startActivity(intent);
        });
    }
}
