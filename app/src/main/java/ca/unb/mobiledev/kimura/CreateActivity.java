package ca.unb.mobiledev.kimura;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class CreateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("Create", "onCreate() called");
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.create_activity);

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
//            Intent intent = new Intent(CreateActivity.this, MainActivity.class);
//            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
//            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//            CreateActivity.this.startActivity(intent);
            finish();
        });
        compareButton = findViewById(R.id.btnCreate);
        compareButton.setOnClickListener(v -> {
            Intent intent = new Intent(CreateActivity.this, CompareActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            CreateActivity.this.startActivity(intent);
        });
    }

    public void onPause() {
        super.onPause();
        overridePendingTransition(0, 0);
    }
}
