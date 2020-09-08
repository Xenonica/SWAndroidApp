package com.example.joshu.fyp;

import android.net.Uri;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.ScrollView;
import android.widget.VideoView;

public class Volleyball_student extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volleyball_student);

        ((ScrollView) findViewById(R.id.activity_volleyball_student)).post(new Runnable() {
            public void run() {
                ((ScrollView) findViewById(R.id.activity_volleyball_student)).fullScroll(View.FOCUS_UP);
            }
        });

        VideoView videoView = findViewById(R.id.v_volleyball);

        String videopath = "android.resource://" + getPackageName() + "/" + R.raw.volleyball;
        Uri uri = Uri.parse(videopath);
        videoView.setVideoURI(uri);
        videoView.seekTo(4000);

        MediaController mediaController = new MediaController( this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);
    }
}
