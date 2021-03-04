package com.example.andoid.brasov;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class contentRoundAdapter extends ArrayAdapter<contentRound> {


    public contentRoundAdapter(Activity context, ArrayList<contentRound> contentRounds) {
        super(context, 0, contentRounds);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_round, parent, false);
        }

        contentRound currentcontentRound = getItem(position);

        TextView nameTextView = (TextView) listItemView.findViewById(R.id.name_round);
        assert currentcontentRound != null;
        nameTextView.setText(currentcontentRound.getname());

        TextView proffesionTextView = (TextView) listItemView.findViewById(R.id.proffesion_round);
        proffesionTextView.setText(currentcontentRound.getproffesion());

        TextView readTextView = (TextView) listItemView.findViewById(R.id.read_round);
        readTextView.setText(currentcontentRound.getreadMore());

        ImageView pictureView = (ImageView) listItemView.findViewById(R.id.image_view_round_card);
        pictureView.setImageResource(currentcontentRound.getimage());

        return listItemView;
    }

}