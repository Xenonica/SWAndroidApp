package com.example.joshu.fyp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class Student_Basketball_Skills extends YouTubeBaseActivity implements View.OnClickListener{

    Button btn_dribblingPlay, btn_shootingPlay, btn_passingPlay, btn_defencePlay, btn_play;
    YouTubePlayerView youtube_basketballSkills;
    YouTubePlayer youTubePlayer;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student__basketball__skills);



        btn_dribblingPlay = findViewById(R.id.btn_basketballSkills_dribbling);
        btn_shootingPlay = findViewById(R.id.btn_basketballSkills_shooting);
        btn_passingPlay = findViewById(R.id.btn_basketballSkills_passing);
        btn_defencePlay = findViewById(R.id.btn_basketballSkills_defence);

        youtube_basketballSkills = findViewById(R.id.youTube_basketballSkills);

        btn_dribblingPlay.setOnClickListener(this);
        btn_shootingPlay.setOnClickListener(this);
        btn_passingPlay.setOnClickListener(this);
        btn_defencePlay.setOnClickListener(this);

        youtube_basketballSkills.initialize(YoutubeConfig.getApiKey(), new YouTubePlayer.OnInitializedListener() {
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
            case R.id.btn_basketballSkills_dribbling:
                playVideo("bnjed9YVCRs");
                break;
            case R.id.btn_basketballSkills_shooting:
                playVideo("SyvuSxCyfi0");
                break;
            case R.id.btn_basketballSkills_passing:
                playVideo("PukmYnApL2Y");
                break;
            case R.id.btn_basketballSkills_defence:
                playVideo("6IcPmb2yjlA");
                break;

            default:
                break;
        }
    }
}
