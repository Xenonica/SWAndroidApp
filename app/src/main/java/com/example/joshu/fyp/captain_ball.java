package com.example.joshu.fyp;

import android.net.Uri;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.ScrollView;
import android.widget.VideoView;

public class captain_ball extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_captain_ball);

         ScrollView scrollView = findViewById(R.id.activity_captain_ball);

                scrollView.fullScroll(ScrollView.FOCUS_UP);

        VideoView videoView = findViewById(R.id.v_cap);

        String videopath = "android.resource://" + getPackageName() + "/" + R.raw.captain;
        Uri uri = Uri.parse(videopath);
        videoView.setVideoURI(uri);

        MediaController mediaController = new MediaController( this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);
    }
}
