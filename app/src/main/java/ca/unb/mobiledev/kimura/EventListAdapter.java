package ca.unb.mobiledev.kimura;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class EventListAdapter extends ArrayAdapter {

    private final Activity context;

    private final String[] datesArray;

    private final String[] titlesArray;

    private final String[] locationsArray;

    public EventListAdapter(Activity context, String[] datesArray, String[] titlesArray,
                             String[] locationsArray){
        super(context, R.layout.event_row , titlesArray);
        this.context=context;
        this.datesArray = datesArray;
        this.titlesArray = titlesArray;
        this.locationsArray = locationsArray;
    }

    public View getView(int i, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        @SuppressLint({"InflateParams", "ViewHolder"})
        View rowView = inflater.inflate(R.layout.event_row, null,true);

        TextView dateTextField = (TextView)rowView.findViewById(R.id.dateView);
        TextView titleTextField = (TextView)rowView.findViewById(R.id.titleView);
        TextView locationTextField = (TextView)rowView.findViewById(R.id.locationView);
        dateTextField.setText(datesArray[i].replaceAll(",", ", "));
        String title = titlesArray[i];
        if(title.length() > 35) {
            title = titlesArray[i].substring(0, 32) + "...";
        }
        titleTextField.setText(title);
        locationTextField.setText(locationsArray[i].replaceAll(",", ", ").replace("Las", "Las "));
        return rowView;
    }
}
