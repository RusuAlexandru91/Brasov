package com.example.andoid.brasov;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    /**
     * Variables for media and play button
     **/
    // Globals for media player
    Button play;
    private MediaPlayer mMediaPlayer;

    // Variables for FW , BW and time
    Button btnForward;
    Button btnBackward;
    private final int seekForwardTime = 5000; // 5000 milliseconds
    private final int seekBackwardTime = 5000; // 5000 milliseconds

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // hide ToolBar
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

        final contentRoundAdapter adapter = new contentRoundAdapter(this, contentRounds);
        final ListView listView = (ListView) findViewById(R.id.list_round);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                contentRound item = contentRounds.get(position);

                View dialogView = LayoutInflater.from(MainActivity.this).inflate(R.layout.activity_detail, null, false);

                TextView name_d = (TextView) dialogView.findViewById(R.id.name_detailes);
                name_d.setText(item.getname());

                TextView proffesion_d = (TextView) dialogView.findViewById(R.id.proffesion_detailes);
                proffesion_d.setText(item.getproffesion());

                ImageView image_d = (ImageView) dialogView.findViewById(R.id.imageView__detailes);
                image_d.setImageResource(item.getimage());

                TextView detailes_d = (TextView) dialogView.findViewById(R.id.content_detailes);
                detailes_d.setText(item.getreadMore());

                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(MainActivity.this);
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

        // onClickListener to open Hotels Page

        // Find the View that shows the Hotels category
        Button hotels = (Button) findViewById(R.id.hotels_main);
        // Set a click listener on that View
        hotels.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the Hotels button is clicked on.
            @Override
            public void onClick(View view) {
                Intent hotelsIntent = new Intent(MainActivity.this, hotelsActivity.class);
                startActivity(hotelsIntent);
            }
        });

        // onClickListener to open Places Page
        // Find the View that shows the Places category
        Button places = (Button) findViewById(R.id.places_main);
        // Set a click listener on that View
        places.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the Places Button is clicked on.
            @Override
            public void onClick(View view) {
                Intent placesIntent = new Intent(MainActivity.this, placesActivity.class);
                startActivity(placesIntent);
            }
        });

        //onClickListener to open Food Page
        // Find the View that shows the Food category
        Button food = (Button) findViewById(R.id.food_main);
        // Set a click listener on that View
        food.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the Food Button is clicked on.
            @Override
            public void onClick(View view) {
                Intent foodIntent = new Intent(MainActivity.this, foodActivity.class);
                startActivity(foodIntent);
            }
        });

        // onClickListener to open People Page
        TextView people = (TextView) findViewById(R.id.see_all_one);
        // Set a click listener on that View
        people.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the People View is clicked on.
            @Override
            public void onClick(View view) {
                Intent peopleIntent = new Intent(MainActivity.this, peopleActivity.class);
                startActivity(peopleIntent);
            }
        });

        // Media player action with conditions
        play = (Button) findViewById(R.id.play_button);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (mMediaPlayer != null && mMediaPlayer.isPlaying()) {
                    mMediaPlayer.pause();
                    play.setBackgroundResource(R.drawable.baseline_play_arrow_black_24dp);
                } else {
                    mMediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.voice_intro_long);
                    mMediaPlayer.start();
                    mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            play.setBackgroundResource(R.drawable.baseline_play_arrow_black_24dp);
                        }
                    });
                    play.setBackgroundResource(R.drawable.baseline_pause_black_24dp);
                }

                //Forward button click event
                btnForward = (Button) findViewById(R.id.btnForward);
                btnForward.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View arg0) {
                        // get current song position
                        int currentPosition = mMediaPlayer.getCurrentPosition();
                        // check if seekForward time is lesser than song duration
                        if (currentPosition + seekForwardTime <= mMediaPlayer.getDuration()) {
                            // forward song
                            mMediaPlayer.seekTo(currentPosition + seekForwardTime);
                        } else {
                            // forward to end position
                            mMediaPlayer.seekTo(mMediaPlayer.getDuration());
                        }
                    }
                });

                // Backward button click event
                btnBackward = (Button) findViewById(R.id.btnBackward);
                btnBackward.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View arg0) {
                        // get current song position
                        int currentPosition = mMediaPlayer.getCurrentPosition();
                        // check if seekForward time is lesser than song duration
                        if (currentPosition - seekBackwardTime >= 0) {
                            // forward song
                            mMediaPlayer.seekTo(currentPosition - seekBackwardTime);
                        } else {
                            // forward to end position
                            mMediaPlayer.seekTo(0);
                        }
                    }
                });
            }
        });
    }

    // Intent to open Places
    public void openPlacesList(View view) {
        Intent i = new Intent(this, placesActivity.class);
        startActivity(i);
    }

    // Intent to open Food
    public void openFoodList(View view) {
        Intent i = new Intent(this, foodActivity.class);
        startActivity(i);
    }


    // Intent to open People
    public void openPeopleList(View view) {
        Intent i = new Intent(this, peopleActivity.class);
        startActivity(i);
    }

    @Override
    protected void onStop() {
        super.onStop();
        play.setBackgroundResource(R.drawable.baseline_play_arrow_black_24dp);

        if (mMediaPlayer != null) {
            mMediaPlayer.stop();
            mMediaPlayer.reset();
        }
    }
}
