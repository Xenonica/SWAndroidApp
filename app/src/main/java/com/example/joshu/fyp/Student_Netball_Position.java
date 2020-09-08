package com.example.joshu.fyp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class Student_Netball_Position extends YouTubeBaseActivity {

    Button btnPlay;
    YouTubePlayerView youtube_NetballPosition;
    YouTubePlayer.OnInitializedListener onInitializedListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student__netball__position);

        btnPlay = findViewById(R.id.btn_NetballPosition_Play);
        youtube_NetballPosition = (YouTubePlayerView) findViewById(R.id.youTube_netballPosition);

        onInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo("6vID6LKydPw");
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                    Toast.makeText(Student_Netball_Position.this, "Please check your internet connection", Toast.LENGTH_SHORT).show();
            }
        };

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                youtube_NetballPosition.initialize(YoutubeConfig.getApiKey(), onInitializedListener);
            }
        });
    }
}
