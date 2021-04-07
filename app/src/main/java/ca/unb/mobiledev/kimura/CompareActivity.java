package ca.unb.mobiledev.kimura;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class CompareActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("Compare", "onCreate() called");
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.compare_activity);
        Spinner fighterOneSpinner = (Spinner)findViewById(R.id.fighterOneSpinner);
        Spinner fighterTwoSpinner = (Spinner)findViewById(R.id.fighterTwoSpinner);
        fighterOneSpinner.setOnItemSelectedListener(this);
        fighterTwoSpinner.setOnItemSelectedListener(this);
        ArrayList<Fighter> fighters = Data.getInstance().getFighters();
        FighterAdapter adapter = new FighterAdapter(this, android.R.layout.simple_spinner_item, R.id.textView, fighters);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fighterOneSpinner.setAdapter(adapter);
        fighterTwoSpinner.setAdapter(adapter);
        menuHandler();
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Fighter fighter = (Fighter)parent.getItemAtPosition(position);
        TextView firstNameView;
        TextView lastNameView;
        TextView nickNameView;
        TextView heightView;
        TextView weightView;
        TextView reachView;
        TextView stanceView;
        TextView recordView;
        if(parent.getId() == R.id.fighterOneSpinner) {
            System.out.println("one");
            System.out.println(fighter.getLastName());
            firstNameView = (TextView)findViewById(R.id.fighter_one_firstName);
            lastNameView = (TextView)findViewById(R.id.fighter_one_lastName);
            nickNameView = (TextView)findViewById(R.id.fighter_one_nickName);
            heightView = (TextView)findViewById(R.id.fighter_one_height);
            weightView = (TextView)findViewById(R.id.fighter_one_weight);
            reachView = (TextView)findViewById(R.id.fighter_one_reach);
            stanceView = (TextView)findViewById(R.id.fighter_one_stance);
            recordView = (TextView)findViewById(R.id.fighter_one_record);
        }
        else {
            System.out.println("two");
            System.out.println(fighter.getLastName());
            firstNameView = (TextView)findViewById(R.id.fighter_two_firstName);
            lastNameView = (TextView)findViewById(R.id.fighter_two_lastName);
            nickNameView = (TextView)findViewById(R.id.fighter_two_nickName);
            heightView = (TextView)findViewById(R.id.fighter_two_height);
            weightView = (TextView)findViewById(R.id.fighter_two_weight);
            reachView = (TextView)findViewById(R.id.fighter_two_reach);
            stanceView = (TextView)findViewById(R.id.fighter_two_stance);
            recordView = (TextView)findViewById(R.id.fighter_two_record);
        }
        firstNameView.setText(fighter.getFirstName());
        lastNameView.setText(fighter.getLastName());
        nickNameView.setText(fighter.getNickName());
        heightView.setText(fighter.getHeight());
        weightView.setText(fighter.getWeight() + "");
        reachView.setText(fighter.getReach() + "");
        stanceView.setText(fighter.getStance());
        recordView.setText(fighter.getRecord()[0] + "-" + fighter.getRecord()[1] + "-" + fighter.getRecord()[2]);
    }

    public void onNothingSelected(AdapterView<?> arg0) {}

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
            Intent intent = new Intent(CompareActivity.this, EventsActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            CompareActivity.this.startActivity(intent);
        });
        createButton = findViewById(R.id.btnCreate);
        createButton.setOnClickListener(v -> {
            Intent intent = new Intent(CompareActivity.this, CreateActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            CompareActivity.this.startActivity(intent);
        });
    }
}
