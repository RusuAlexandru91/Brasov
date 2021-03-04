package com.example.andoid.brasov;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class Splash_screen extends AppCompatActivity {

    //Splash Screen Variables
    Animation topAnim, bottomAnim;
    TextView line_one, line_two;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        // This hides the ToolBar
        getSupportActionBar().hide();

        //Splash screen varable Hooks
        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);

        line_one = findViewById(R.id.splash_text_one);
        line_two = findViewById(R.id.splash_text_two);

        // Assign animation Splash screen
        line_one.setAnimation(topAnim);
        line_two.setAnimation(bottomAnim);

        // Handler and intent for next activity
        // In the intent is from this activity to the new dashboard actiity that we created
        //Variable for animation Time
        int SPLASH_SCREEN = 2500;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Splash_screen.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_SCREEN);
    }
}