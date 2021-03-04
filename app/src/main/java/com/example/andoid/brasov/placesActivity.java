package com.example.andoid.brasov;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;

public class placesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places);

        // This hides the ToolBar
        getSupportActionBar().hide();

        // ArrayList with round cardview
        final ArrayList<contentSquare> contentSquares = new ArrayList<>();
        contentSquares.add(new contentSquare (R.string.concil_square,R.string.concil_square_descriprion,R.drawable.places_piata));
        contentSquares.add(new contentSquare (R.string.black_church,R.string.black_church_description,R.drawable.places_bisericabv));
        contentSquares.add(new contentSquare (R.string.first_romanian_scholl,R.string.first_romanian_scholl_description,R.drawable.places_scoala));
        contentSquares.add(new contentSquare (R.string.rope_Street,R.string.rope_Street_description,R.drawable.places_sforii));
        contentSquares.add(new contentSquare (R.string.brasov_cetate,R.string.brasov_cetate_description,R.drawable.places_cetate));
        contentSquares.add(new contentSquare (R.string.pietre_solomon,R.string.pietre_solomon_description,R.drawable.places_pietre));
        contentSquares.add(new contentSquare (R.string.turnuri,R.string.turnuri_description,R.drawable.places_turnuri));
        contentSquares.add(new contentSquare (R.string.tampa,R.string.tampa_description,R.drawable.places_tampa));
        contentSquares.add(new contentSquare (R.string.zoo,R.string.zoo_description,R.drawable.places_zoo));
        contentSquares.add(new contentSquare (R.string.imprejurimi,R.string.imprejurimi_description,R.drawable.places_imprejur));

        // Create Array list and display it
        contentSquareAdapter adapter = new contentSquareAdapter(this, contentSquares);
        final ListView listView = (ListView) findViewById(R.id.list_square);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                contentSquare item = contentSquares.get(position);

                final View dialogView = LayoutInflater.from(placesActivity.this).inflate(R.layout.activity_detail2, null, false);

                TextView name_d = (TextView) dialogView.findViewById(R.id.name_detailes2);
                name_d.setText(item.getname());

                TextView detailes_d = (TextView) dialogView.findViewById(R.id.content_detailes2);
                detailes_d.setText(item.getadress());

                ImageView image_d = (ImageView) dialogView.findViewById(R.id.imageView__detailes2);
                image_d.setImageResource(item.getImageMain());

                ImageView stars = (ImageView) dialogView.findViewById(R.id.stars);
                stars.setImageResource(item.getimageStars());

                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(placesActivity.this);
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

        //onClickListener for back button to go to main screen
        // Find the View that shows the Places category
        TextView placesPage = (TextView) findViewById(R.id.back_places);
        // Set a click listener on that View
        placesPage.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the back button is clicked on.
            @Override
            public void onClick(View view) {
                Intent foodIntent = new Intent(placesActivity.this, MainActivity.class);
                finish();
            }
        });
    }

}