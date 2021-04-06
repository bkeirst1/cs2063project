package ca.unb.mobiledev.kimura;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class FightListAdapter extends ArrayAdapter {
    private final Activity context;

    private final String[] fighterOneArray;

    private final String[] fighterTwoArray;

    private final String[] weightClassArray;

    public FightListAdapter(Activity context, String[] fighterOneArray, String[] fighterTwoArray,
                            String[] weightClassArray){
        super(context, R.layout.fight_row , fighterOneArray);
        this.context=context;
        this.fighterOneArray = fighterOneArray;
        this.fighterTwoArray = fighterTwoArray;
        this.weightClassArray = weightClassArray;
    }

    public View getView(int i, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        @SuppressLint({"InflateParams", "ViewHolder"})
        View rowView = inflater.inflate(R.layout.fight_row, null,true);

        TextView fighterOneTextField = (TextView)rowView.findViewById(R.id.fighterOneView);
        TextView fighterTwoTextField = (TextView)rowView.findViewById(R.id.fighterTwoView);
        TextView weightClassTextField = (TextView)rowView.findViewById(R.id.weightClassView);
        fighterOneTextField.setText(fighterOneArray[i]);
        fighterTwoTextField.setText(fighterTwoArray[i]);
        weightClassTextField.setText(weightClassArray[i]);
        return rowView;
    }
}
