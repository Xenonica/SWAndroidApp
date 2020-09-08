package com.example.joshu.fyp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class AttendanceMenu extends AppCompatActivity {

    CardView submitAtt, viewAtt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance_menu);

        overridePendingTransition(R.anim.fadein, R.anim.fadeout);

        setSubmitAtt();
        setViewAtt();
    }

    public void setSubmitAtt(){
        submitAtt = findViewById(R.id.cardview_submitAtt);
        submitAtt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SubmitAttList.class);
                startActivity(intent);
            }
        });

    }

    public void setViewAtt(){
        viewAtt = findViewById(R.id.cardview_ViewAtt);
        viewAtt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ViewAttList.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
    }
}
