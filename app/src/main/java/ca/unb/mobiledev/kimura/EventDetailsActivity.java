package ca.unb.mobiledev.kimura;

import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class EventDetailsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.event_details_activity);
        setTextFields();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void setTextFields() {
        int position = Integer.parseInt(getIntent().getStringExtra("position"));
        Event event = Data.getInstance().getEvents().get(position);
        String title;
        String location;
        String date;
        if(event.getNumber() == -1) {
            title = "UFC Fight Night: " + event.getTitle();
        } else {
            title = "UFC " + event.getNumber() + ": " + event.getTitle();
        }
        location = event.getLocation().replaceAll(",", ", ").replace("Las", "Las ");
        date = event.getDate().replaceAll(",", ", ");
        getSupportActionBar().setTitle(title);
        TextView titleView = (TextView)findViewById(R.id.event_title);
        TextView locationView = (TextView)findViewById(R.id.event_location);
        TextView dateView = (TextView)findViewById(R.id.event_date);
        titleView.setText(Html.fromHtml("<b>Title: </b>" + title));
        locationView.setText(Html.fromHtml("<b>Location: </b>" + location));
        dateView.setText(Html.fromHtml("<b>Date: </b>" + date));
    }
}
