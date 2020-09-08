package com.example.joshu.fyp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class Student_Basketball_Rules extends YouTubeBaseActivity {

    Button btnPlay;
    YouTubePlayerView youtube_basketballRules;
    YouTubePlayer.OnInitializedListener onInitializedListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student__basketball__rules);

        ((ScrollView) findViewById(R.id.activity_student_basketball_rules)).post(new Runnable() {
            public void run() {
                ((ScrollView) findViewById(R.id.activity_student_basketball_rules)).fullScroll(View.FOCUS_UP);
            }
        });


        btnPlay = findViewById(R.id.btn_basketballRules_play);
        youtube_basketballRules = (YouTubePlayerView) findViewById(R.id.youTube_basketballRules);

        onInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo("wYjp2zoqQrs");
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Toast.makeText(Student_Basketball_Rules.this, "Please check your internet connection", Toast.LENGTH_SHORT).show();
            }
        };

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                youtube_basketballRules.initialize(YoutubeConfig.getApiKey(), onInitializedListener);
            }
        });



    }
}
