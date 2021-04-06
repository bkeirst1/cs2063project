package ca.unb.mobiledev.kimura;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class EventsActivity extends AppCompatActivity {

    private ListView listView;

    private ArrayList<Event> events;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("Events", "onCreate() called");
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.events_activity);

        getData();
        menuHandler();
    }

    private void getData() {
        events = Data.getInstance().getEvents();
        String[] datesArray = new String[events.size()];
        String[] titlesArray = new String[events.size()];
        String[] locationsArray = new String[events.size()];
        String eventType;
        for(int i = 0; i < events.size(); i++) {
            if(events.get(i).getNumber() == -1) {
                eventType = "Fight Night";
            } else {
                eventType = "" + events.get(i).getNumber();
            }
            datesArray[i] = events.get(i).getDate();
            titlesArray[i] = "UFC " + eventType + ": " + events.get(i).getTitle();
            locationsArray[i] = events.get(i).getLocation();
        }
        EventListAdapter adapter = new EventListAdapter(this, datesArray, titlesArray, locationsArray);
        listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(EventsActivity.this, EventDetailsActivity.class);
            intent.putExtra("position", position+"");
            intent.putParcelableArrayListExtra("fights", events.get(position).getFights());
            startActivity(intent);
        });
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
