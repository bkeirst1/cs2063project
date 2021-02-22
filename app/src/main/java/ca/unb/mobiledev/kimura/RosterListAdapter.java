package ca.unb.mobiledev.kimura;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class RosterListAdapter extends ArrayAdapter {

    private final Activity context;

    private final String[] nameArray;
    private final String[] heightArray;
    private final String[] nickArray;
    private final double[] weightArray;
    private final double[] reachArray;
    private final String[] stanceArray;
    private final String[] recordArray;

    public RosterListAdapter(Activity context, String[] nameArray, String[] heightArray,
                             String[] nickArray, double[] weightArray, double[] reachArray,
                             String[] stanceArray, String[] recordArray){
        super(context, R.layout.roster_details_activity, nameArray);
        this.context=context;
        this.nameArray = nameArray;
        this.heightArray = heightArray;
        this.nickArray = nickArray;
        this.weightArray = weightArray;
        this.reachArray = reachArray;
        this.stanceArray = stanceArray;
        this.recordArray = recordArray;
    }

    public View getView(int i, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        @SuppressLint({"InflateParams", "ViewHolder"})
        View rowView = inflater.inflate(R.layout.roster_details_activity, null,true);

        TextView nameTextField = (TextView)rowView.findViewById(R.id.nameView);
        TextView heightTextField = (TextView)rowView.findViewById(R.id.heightView);
        TextView nickTextField = (TextView)rowView.findViewById(R.id.nickView);
        TextView weightTextField = (TextView)rowView.findViewById(R.id.weightView);
        TextView reachTextField = (TextView)rowView.findViewById(R.id.reachView);
        TextView stanceTextField = (TextView)rowView.findViewById(R.id.stanceView);
        TextView recordTextField = (TextView)rowView.findViewById(R.id.recordView);
        nameTextField.setText(nameArray[i]);
        heightTextField.setText(heightArray[i]);
        nickTextField.setText(nickArray[i]);
        weightTextField.setText(String.valueOf(weightArray[i]));
        reachTextField.setText(String.valueOf(reachArray[i]));
        stanceTextField.setText(stanceArray[i]);
        recordTextField.setText(recordArray[i]);
        return rowView;
    }
}

