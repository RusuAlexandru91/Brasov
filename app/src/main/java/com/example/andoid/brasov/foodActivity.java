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

public class foodActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        // This hides the ToolBar
        getSupportActionBar().hide();

        // ArrayList with round cardview
        final ArrayList<contentRound> contentRounds = new ArrayList<>();
        contentRounds.add(new contentRound (R.string.bistro_aha,R.string.bistro_l,R.string.Bar_description, R.drawable.aha));
        contentRounds.add(new contentRound (R.string.azima,R.string.fastfood,R.string.Bar_description, R.drawable.azima));
        contentRounds.add(new contentRound (R.string.belvedere,R.string.restaurant,R.string.Bar_description, R.drawable.belevdere));
        contentRounds.add(new contentRound (R.string.braserie,R.string.restaurant,R.string.Bar_description, R.drawable.braserie));
        contentRounds.add(new contentRound (R.string.casa_h,R.string.restaurant,R.string.Bar_description, R.drawable.casah));
        contentRounds.add(new contentRound (R.string.casa_dodo,R.string.restaurant,R.string.Bar_description, R.drawable.casadodo));
        contentRounds.add(new contentRound (R.string.la_ceaun,R.string.restaurant,R.string.Bar_description, R.drawable.laceaun));
        contentRounds.add(new contentRound (R.string.prato,R.string.restaurant,R.string.Bar_description, R.drawable.prato));
        contentRounds.add(new contentRound (R.string.s_house,R.string.restaurant,R.string.Bar_description,R.drawable.steakhouse));
        contentRounds.add(new contentRound (R.string.tratoria,R.string.restaurant,R.string.Bar_description, R.drawable.tratoria));
        contentRounds.add(new contentRound (R.string.casa_tudor,R.string.restaurant,R.string.Bar_description, R.drawable.tudor));
        contentRounds.add(new contentRound (R.string.sergiana,R.string.restaurant,R.string.Bar_description,R.drawable.sergiana));


        final contentRoundAdapter adapter = new contentRoundAdapter(this, contentRounds);
        final ListView listView = (ListView) findViewById(R.id.list_round);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                contentRound item = contentRounds.get(position);

                View dialogView = LayoutInflater.from(foodActivity.this).inflate(R.layout.activity_detail, null, false);

                TextView name_d = (TextView) dialogView.findViewById(R.id.name_detailes);
                name_d.setText(item.getname());

                TextView proffesion_d = (TextView) dialogView.findViewById(R.id.proffesion_detailes);
                proffesion_d.setText(item.getproffesion());

                ImageView image_d = (ImageView) dialogView.findViewById(R.id.imageView__detailes);
                image_d.setImageResource(item.getimage());

                TextView detailes_d = (TextView) dialogView.findViewById(R.id.content_detailes);
                detailes_d.setText(item.getreadMore());

                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(foodActivity.this);
                dialogBuilder.setView(dialogView);
                final AlertDialog alertDialog = dialogBuilder.create();
                alertDialog.show();

                Button alertButton = (Button) alertDialog.findViewById(R.id.button_close_d1);
                alertButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialog.dismiss();
                    }
                });
            }
        });

        // Find the View that shows the Hotels category
        TextView foodPage = (TextView) findViewById(R.id.back_food);
        // Set a click listener on that View
        foodPage.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the back button is clicked on.
            @Override
            public void onClick(View view) {
                Intent foodIntent = new Intent( foodActivity.this, MainActivity.class);
                finish();

            }
        });
    }

}
