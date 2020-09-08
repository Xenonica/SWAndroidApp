package com.example.joshu.fyp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class Student_Swimming_Strokes extends YouTubeBaseActivity  implements View.OnClickListener{

    Button btn_treadingPlay, btn_freestylePlay, btn_butterflyPlay, btn_breastPlay, btn_backplay;
    YouTubePlayerView youtube_swimmingStroke;
    YouTubePlayer youTubePlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student__swimming__strokes);

        btn_treadingPlay = findViewById(R.id.btn_swimmingTreading_Play);
        btn_freestylePlay = findViewById(R.id.btn_swimmingFreestyle_Play);
        btn_butterflyPlay = findViewById(R.id.btn_swimmingButterfly_Play);
        btn_breastPlay = findViewById(R.id.btn_swimmingBreast_Play);
        btn_backplay = findViewById(R.id.btn_swimmingBack_Play);

        youtube_swimmingStroke = findViewById(R.id.youTube_swimmingStroke);

        btn_treadingPlay.setOnClickListener(this);
        btn_freestylePlay.setOnClickListener(this);
        btn_butterflyPlay.setOnClickListener(this);
        btn_breastPlay.setOnClickListener(this);
        btn_backplay.setOnClickListener(this);

        youtube_swimmingStroke.initialize(YoutubeConfig.getApiKey(), new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player, boolean b) {
                if (!b) {
                    if (youTubePlayer == null) {
                        youTubePlayer = player;
                    }
                }
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        });
    }

    private void playVideo(String videoId){
        if(youTubePlayer != null){
            youTubePlayer.loadVideo(videoId);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_swimmingTreading_Play:
                playVideo("q9QCBGdztLk");
                break;
            case R.id.btn_swimmingFreestyle_Play:
                playVideo("5HLW2AI1Ink");
                break;
            case R.id.btn_swimmingButterfly_Play:
                playVideo("H16wDdWw3Cc");
                break;
            case R.id.btn_swimmingBreast_Play:
                playVideo("QGZ8rIy-YtI");
                break;
            case R.id.btn_swimmingBack_Play:
                playVideo("JghqyliWwb4");
                break;

            default:
                break;
        }
    }
}
