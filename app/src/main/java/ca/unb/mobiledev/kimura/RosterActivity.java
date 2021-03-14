package ca.unb.mobiledev.kimura;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class RosterActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList<Fighter> fighters = new ArrayList<Fighter>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("Roster", "onCreate() called");
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.roster_activity);

        getData();
        menuHandler();


    }


    private void getData() {
        fighters = Data.getInstance().getFighters();
        String[] nameArray = new String[fighters.size()];
        String[] recordArray = new String[fighters.size()];
        for(int i = 0; i < fighters.size(); i++) {
            nameArray[i] = fighters.get(i).getLastName() + ", " + fighters.get(i).getFirstName();
            int[] tempRecord = fighters.get(i).getRecord();
            recordArray[i] = tempRecord[0] + "-" + tempRecord[1] + "-" + tempRecord[2];
        }
        SmallRosterListAdapter adapter = new SmallRosterListAdapter(this, nameArray, recordArray);
        listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(RosterActivity.this, RosterDetailsActivity.class);
            intent.putExtra("position", position+"");
            startActivity(intent);
        });
    }


    //public boolean onCreateOptionsMenu(Menu menu) {

        // Get the SearchView and set the searchable configuration
       // SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
       // SearchView searchView = (SearchView) menu.findItem(R.id.sFighter).getActionView();
        // Assumes current activity is the searchable activity
       // searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        //searchView.setIconifiedByDefault(false); // Do not iconify the widget; expand it by default

       // return true;
   // }

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
