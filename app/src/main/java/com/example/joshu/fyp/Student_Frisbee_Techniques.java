package com.example.joshu.fyp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class Student_Frisbee_Techniques extends YouTubeBaseActivity {

    Button btnPlay;
    YouTubePlayerView youtube_frisbeeTechnique;
    YouTubePlayer.OnInitializedListener onInitializedListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student__frisbee__techniques);

        btnPlay = findViewById(R.id.btn_frisbeeSkills_Play);
        youtube_frisbeeTechnique = (YouTubePlayerView) findViewById(R.id.youTube_frisbeeSkills);

        onInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo("EPtM0NaTZ7I");
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Toast.makeText(Student_Frisbee_Techniques.this, "Please check your internet connection", Toast.LENGTH_SHORT).show();
            }
        };

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                youtube_frisbeeTechnique.initialize(YoutubeConfig.getApiKey(), onInitializedListener);
            }
        });
    }
}
