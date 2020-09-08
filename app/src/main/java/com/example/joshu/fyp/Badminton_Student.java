package com.example.joshu.fyp;

import android.net.Uri;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.ScrollView;
import android.widget.VideoView;

public class Badminton_Student extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_badminton__student);

        ((ScrollView) findViewById(R.id.activty_badminton)).post(new Runnable() {
            public void run() {
                ((ScrollView) findViewById(R.id.activty_badminton)).fullScroll(View.FOCUS_UP);
            }
        });

        VideoView videoView = findViewById(R.id.v_badminton);

        String videopath = "android.resource://" + getPackageName() + "/" + R.raw.badminton;
        Uri uri = Uri.parse(videopath);
        videoView.setVideoURI(uri);
        videoView.seekTo(4000);

        MediaController mediaController = new MediaController( this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);


    }

}
