package com.example.joshu.fyp;

import android.net.Uri;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.ScrollView;
import android.widget.VideoView;

public class table_tennis extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_tennis);

        ((ScrollView) findViewById(R.id.activity_table_tennis)).post(new Runnable() {
            public void run() {
                ((ScrollView) findViewById(R.id.activity_table_tennis)).fullScroll(View.FOCUS_UP);
            }
        });

        VideoView videoView = findViewById(R.id.v_table);

        String videopath = "android.resource://" + getPackageName() + "/" + R.raw.tabletennis;
        Uri uri = Uri.parse(videopath);
        videoView.setVideoURI(uri);
        videoView.seekTo(4000);

        MediaController mediaController = new MediaController( this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);
    }
}
