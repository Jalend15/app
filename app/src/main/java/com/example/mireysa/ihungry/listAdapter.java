package com.example.mireysa.ihungry;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class listAdapter extends ArrayAdapter<listItem> {

    Context context;

    TextView venueName;
    TextView venueAddress;
    listItem venueItem;

    public listAdapter(Context context) {
        super(context, R.layout.list_item);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertView = layoutInflater.inflate(R.layout.list_item,parent,false);
        }

        // Convert Views
        venueName = (TextView) convertView.findViewById(R.id.placeTitle);
        venueAddress = (TextView) convertView.findViewById(R.id.placeAddress);

        // Get position of current item
        venueItem = getItem(position);

        // Set Item
        venueName.setText(venueItem.getNameOfLocation());
        venueAddress.setText(venueItem.getAddressOfLocation());


        return convertView;
    }
}
