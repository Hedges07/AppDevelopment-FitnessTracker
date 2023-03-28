package com.example.fitnessapp;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.MediaController;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.VideoView;

import java.util.ArrayList;

public class workout_view extends AppCompatActivity {

    VideoView workout_video;
    TextView workout_title, workout_description;

    String video_url;
    int video_id;

     static ArrayList<String> favorites = new ArrayList<String>();
    View favoritesView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_view);

        workout_video = findViewById(R.id.workoutVideo);
        workout_title = findViewById(R.id.workout_title);
        workout_description = findViewById(R.id.workoutDescription);
        favoritesView = findViewById(R.id.favourite_check);


        //TODO:: NEED TO SET UP TO WORK WITH USERNAME
        for(int i = 0; i < favorites.size(); i++) {
            if(favorites.get(i).equals(getIntent().getStringExtra("workout_title"))) {
                favoritesView.setBackgroundColor(Color.YELLOW);
            }
        }

        //Get extras from intent and set url, title and description
        //Title
        workout_title.setText(getIntent().getStringExtra("workout_title"));
        //Description
        workout_description.setText(getIntent().getStringExtra("workout_description"));
        //Video
        video_url = getIntent().getStringExtra("workout_video");
        video_id = getResources().getIdentifier(video_url, "raw", this.getPackageName());
        workout_video.setVideoPath("android.resource://"+getPackageName()+ "/"+ video_id);

        //Set up pause and fast forward for video
        MediaController mediaController = new MediaController(this);
        workout_video.setMediaController(mediaController);
        workout_video.start();

        favoritesView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(workout_view.this, FavouritesActivity.class);
                favorites.add(getIntent().getStringExtra("workout_title"));
                intent.putStringArrayListExtra("Favorites", favorites);
                startActivity(intent);
            }
        });
    }
}