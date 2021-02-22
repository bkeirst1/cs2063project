package ca.unb.mobiledev.kimura;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class SmallRosterListAdapter extends ArrayAdapter {
    private final Activity context;

    private final String[] nameArray;
    private final String[] recordArray;

    public SmallRosterListAdapter(Activity context, String[] nameArray, String[] recordArray){
        super(context, R.layout.fighter_small_row , nameArray);
        this.context=context;
        this.nameArray = nameArray;
        this.recordArray = recordArray;
    }

    public View getView(int i, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        @SuppressLint({"InflateParams", "ViewHolder"})
        View rowView = inflater.inflate(R.layout.fighter_small_row, null,true);

        TextView nameTextField = (TextView)rowView.findViewById(R.id.nameView);
        TextView recordTextField = (TextView)rowView.findViewById(R.id.recordView);
        nameTextField.setText(nameArray[i]);
        recordTextField.setText(recordArray[i]);
        return rowView;
    }
}
