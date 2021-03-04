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

public class peopleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people);

        // This hides the ToolBar
        getSupportActionBar().hide();

        // ArrayList with round cardview
        final ArrayList<contentRound> contentRounds = new ArrayList<>();
        contentRounds.add(new contentRound(R.string.mock_person, R.string.mock_proffeson, R.string.mock_readMore, R.drawable.placeholder_person));
        contentRounds.add(new contentRound(R.string.mock_person, R.string.mock_proffeson, R.string.mock_readMore, R.drawable.placeholder_person));
        contentRounds.add(new contentRound(R.string.mock_person, R.string.mock_proffeson, R.string.mock_readMore, R.drawable.placeholder_person));
        contentRounds.add(new contentRound(R.string.mock_person, R.string.mock_proffeson, R.string.mock_readMore, R.drawable.placeholder_person));
        contentRounds.add(new contentRound(R.string.mock_person, R.string.mock_proffeson, R.string.mock_readMore, R.drawable.placeholder_person));
        contentRounds.add(new contentRound(R.string.mock_person, R.string.mock_proffeson, R.string.mock_readMore, R.drawable.placeholder_person));
        contentRounds.add(new contentRound(R.string.mock_person, R.string.mock_proffeson, R.string.mock_readMore, R.drawable.placeholder_person));
        contentRounds.add(new contentRound(R.string.mock_person, R.string.mock_proffeson, R.string.mock_readMore, R.drawable.placeholder_person));
        contentRounds.add(new contentRound(R.string.mock_person, R.string.mock_proffeson, R.string.mock_readMore, R.drawable.placeholder_person));
        contentRounds.add(new contentRound(R.string.mock_person, R.string.mock_proffeson, R.string.mock_readMore, R.drawable.placeholder_person));

        final contentRoundAdapter adapter = new contentRoundAdapter(this, contentRounds);
        final ListView listView = (ListView) findViewById(R.id.list_round);
        listView.setAdapter(adapter);

        // OnItemClickListener for opening ea item in the list

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                contentRound item = contentRounds.get(position);

                View dialogView = LayoutInflater.from(peopleActivity.this).inflate(R.layout.activity_detail, null, false);

                TextView name_d = (TextView) dialogView.findViewById(R.id.name_detailes);
                name_d.setText(item.getname());

                TextView proffesion_d = (TextView) dialogView.findViewById(R.id.proffesion_detailes);
                proffesion_d.setText(item.getproffesion());

                ImageView image_d = (ImageView) dialogView.findViewById(R.id.imageView__detailes);
                image_d.setImageResource(item.getimage());

                TextView detailes_d = (TextView) dialogView.findViewById(R.id.content_detailes);
                detailes_d.setText(item.getreadMore());

                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(peopleActivity.this);
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

        //onClickListener for back button to go to main screen
        // Find the View that shows the People category
        TextView peoplePage = (TextView) findViewById(R.id.back_people);
        // Set a click listener on that View
        peoplePage.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the back button is clicked on.
            @Override
            public void onClick(View view) {
                Intent foodIntent = new Intent(peopleActivity.this, MainActivity.class);
                finish();

            }
        });
    }
}