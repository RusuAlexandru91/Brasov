package com.example.andoid.brasov;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class hotelsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotels);

        //hide ToolBar
        getSupportActionBar().hide();

        // ArrayList with round cardview
        final ArrayList<contentSquare> contentSquares = new ArrayList<>();
        contentSquares.add(new contentSquare (R.string.hotel_alpin,R.string.hotel_description,R.drawable.hotel_aro,R.drawable.stars_five_png));
        contentSquares.add(new contentSquare (R.string.hotel_alpin,R.string.hotel_description,R.drawable.hotel_alpin,R.drawable.stars_for_png));
        contentSquares.add(new contentSquare (R.string.hotel_belvedere,R.string.hotel_description,R.drawable.hotel_belvedere,R.drawable.stars_for_png));
        contentSquares.add(new contentSquare (R.string.hotel_ramada,R.string.hotel_description,R.drawable.hotel_ramada,R.drawable.stars_for_png));
        contentSquares.add(new contentSquare (R.string.hotel_Kronwell,R.string.hotel_description,R.drawable.hotel_kronwell,R.drawable.stars_for_png));
        contentSquares.add(new contentSquare (R.string.hotel_Wolkendorf,R.string.hotel_description,R.drawable.hotel_wolkendorf,R.drawable.stars_for_png));
        contentSquares.add(new contentSquare (R.string.hotel_Ambient,R.string.hotel_description,R.drawable.hotel_ambient,R.drawable.stars_for_png));
        contentSquares.add(new contentSquare (R.string.hotel_Rainer,R.string.hotel_description,R.drawable.hotel_rainer,R.drawable.stars_free_png));
        contentSquares.add(new contentSquare (R.string.hotel_Wanger,R.string.hotel_description,R.drawable.hotel_divina,R.drawable.stars_free_png));

        contentSquareAdapter adapter = new contentSquareAdapter(this, contentSquares);
        ListView listView = (ListView) findViewById(R.id.list_square);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                contentSquare item = contentSquares.get(position);

                View dialogView = LayoutInflater.from(hotelsActivity.this).inflate(R.layout.activity_detail2, null, false);

                TextView name_d = (TextView) dialogView.findViewById(R.id.name_detailes2);
                name_d.setText(item.getname());

                TextView detailes_d = (TextView) dialogView.findViewById(R.id.content_detailes2);
                detailes_d.setText(item.getadress());

                ImageView image_d = (ImageView) dialogView.findViewById(R.id.imageView__detailes2);
                image_d.setImageResource(item.getImageMain());

                ImageView stars = (ImageView) dialogView.findViewById(R.id.stars);
                stars.setImageResource(item.getimageStars());

                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(hotelsActivity.this);
                dialogBuilder.setView(dialogView);
                final AlertDialog alertDialog = dialogBuilder.create();
                alertDialog.show();

                Button alertButton = (Button) alertDialog.findViewById(R.id.button_close_d2);
                alertButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialog.dismiss();
                    }
                });
            }
        });

        // Find the View that shows the Hotels category
        TextView hotelPage = (TextView) findViewById(R.id.back_hotels);
        // Set a click listener on that View
        hotelPage.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the back button is clicked on.
            @Override
            public void onClick(View view) {
                Intent hotelIntent = new Intent(hotelsActivity.this, MainActivity.class);
                finish();
            }
        });
    }

}