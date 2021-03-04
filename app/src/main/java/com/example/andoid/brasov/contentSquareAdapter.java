package com.example.andoid.brasov;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class contentSquareAdapter extends ArrayAdapter<contentSquare> {

    public contentSquareAdapter(Activity context, ArrayList<contentSquare> contentSqares) {
        super(context, 0, contentSqares);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_square, parent, false);
        }

        contentSquare currentcontentSquare = getItem(position);

        TextView nameTextView = (TextView) listItemView.findViewById(R.id.name_square);
        nameTextView.setText(currentcontentSquare.getname());

        TextView adressTextView = (TextView) listItemView.findViewById(R.id.adress_square);
        adressTextView.setText(currentcontentSquare.getadress());

        ImageView pictureMainView = (ImageView) listItemView.findViewById(R.id.image_view_sqare_card);
        pictureMainView.setImageResource(currentcontentSquare.getImageMain());

        ImageView pictureStarsView = (ImageView) listItemView.findViewById(R.id.stars);
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.stars);

        if (currentcontentSquare.hasImage()){
            // Set the ImageView to the image resource specified in the current
            imageView.setImageResource(currentcontentSquare.getimageStars());
            // Make shure the view is visible
            imageView.setVisibility(View.VISIBLE);
        }
        else{
            // Do not show immage for phrases in our case
            imageView.setVisibility(View.GONE);
        }

        return listItemView;
    }

}