package ca.unb.mobiledev.kimura;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class FighterAdapter extends ArrayAdapter<Fighter> {

    private final Activity context;

    public FighterAdapter(Activity context, int resourceID, int textViewID, ArrayList<Fighter> list){
        super(context, resourceID, textViewID, list);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return rowView(convertView, position);
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return rowView(convertView, position);
    }

    private View rowView(View convertView , int position){
        Fighter item = getItem(position);
        LayoutInflater inflater = context.getLayoutInflater();
        @SuppressLint({"InflateParams", "ViewHolder"})
        View rowView = inflater.inflate(R.layout.fighter_row, null,true);
        TextView field = (TextView)rowView.findViewById(R.id.textView);
        field.setText(item.getFirstName() + " " + item.getLastName());
        return rowView;
    }

    private class viewHolder {
        TextView txtTitle;
        ImageView imageView;
    }
}
