package ca.unb.mobiledev.kimura;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class CompareActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("Compare", "onCreate() called");
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.compare_activity);

        menuHandler();
    }

    private void menuHandler() {
        Button rosterButton;
        Button eventsButton;
        Button createButton;
        rosterButton = findViewById(R.id.btnRoster);
        rosterButton.setOnClickListener(v -> {
            Intent intent = new Intent(CompareActivity.this, RosterActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            CompareActivity.this.startActivity(intent);
        });
        eventsButton = findViewById(R.id.btnEvents);
        eventsButton.setOnClickListener(v -> {
//            Intent intent = new Intent(CompareActivity.this, MainActivity.class);
//            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
//            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//            CompareActivity.this.startActivity(intent);
            finish();
        });
        createButton = findViewById(R.id.btnCreate);
        createButton.setOnClickListener(v -> {
            Intent intent = new Intent(CompareActivity.this, CreateActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            CompareActivity.this.startActivity(intent);
        });
    }

    public void onPause() {
        super.onPause();
        overridePendingTransition(0, 0);
    }
}
