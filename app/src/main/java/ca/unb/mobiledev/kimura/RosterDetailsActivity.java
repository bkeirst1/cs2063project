package ca.unb.mobiledev.kimura;

import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RosterDetailsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.roster_details_activity);
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
        Fighter fighter = Data.getInstance().getFighters().get(position);
        TextView nameView = (TextView)findViewById(R.id.nameView);
        TextView recordView = (TextView)findViewById(R.id.recordView);
        TextView nickView = (TextView)findViewById(R.id.nickView);
        TextView heightView = (TextView)findViewById(R.id.heightView);
        TextView weightView = (TextView)findViewById(R.id.weightView);
        TextView reachView = (TextView)findViewById(R.id.reachView);
        TextView stanceView = (TextView)findViewById(R.id.stanceView);
        nameView.setText(fighter.getFirstName() + " " + fighter.getLastName());
        int[] tempRecord = fighter.getRecord();
        recordView.setText(tempRecord[0] + "-" + tempRecord[1] + "-" + tempRecord[2]);
        nickView.setText(fighter.getNickName());
        heightView.setText(Html.fromHtml("<b>Height: </b>" + fighter.getHeight()));
        weightView.setText(Html.fromHtml("<b>Weight: </b>" + String.valueOf(fighter.getWeight())));
        reachView.setText(Html.fromHtml("<b>Reach: </b>" + String.valueOf(fighter.getReach())));
        stanceView.setText(Html.fromHtml("<b>Stance: </b>" + fighter.getStance()));
        getSupportActionBar().setTitle(fighter.getFirstName() + " " + fighter.getLastName());
    }
}
