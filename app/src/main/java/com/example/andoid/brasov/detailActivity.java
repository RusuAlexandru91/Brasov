package com.example.andoid.brasov;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class detailActivity extends AppCompatActivity {
    //Variables
    TextView mDetailes, mProffesion, mDescription;
    ImageView mImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        // Hide Toolbat
        getSupportActionBar().hide();

// Assigning variables with cast
        mProffesion = (TextView) findViewById(R.id.proffesion_detailes);
        mDetailes = (TextView) findViewById(R.id.name_detailes);
        mDescription = (TextView) findViewById(R.id.content_detailes);
        mImage = (ImageView) findViewById(R.id.imageView__detailes) ;

        // Bundle
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            // Setting the texts
            mDetailes.setText(getIntent().getStringExtra("name"));
            mProffesion.setText(getIntent().getStringExtra("proffesion"));
            mDescription.setText(getIntent().getStringExtra("readmore"));
            // Setting the image
            int detail_image = bundle.getInt("image");
            mImage.setImageResource(detail_image);
        }
        }
}