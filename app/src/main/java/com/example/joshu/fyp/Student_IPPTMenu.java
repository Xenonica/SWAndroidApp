package com.example.joshu.fyp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

public class Student_IPPTMenu extends AppCompatActivity {

    CardView calculator, pushups, situps, running;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student__ipptmenu);

        calculator = findViewById(R.id.cardview_StudentIPPTCalculator);
        pushups = findViewById(R.id.cardview_Pushups);
        situps = findViewById(R.id.cardview_situps);
        running = findViewById(R.id.cardview_2_4km);


    }


    public void StudentIPPTCalculator(View view) {
        Intent intent = new Intent(getApplicationContext(), Student_IPPT_selectAge.class);
        startActivity(intent);
    }

    public void StudentPushups(View view) {
        Intent intent = new Intent(getApplicationContext(), Student_IPPT_Pushups.class);
        startActivity(intent);
    }

    public void StudentSitups(View view) {
        Intent intent = new Intent(getApplicationContext(), Student_IPPT_Situps.class);
        startActivity(intent);
    }

    public void StudentRunning(View view) {
        Intent intent = new Intent(getApplicationContext(), Student_IPPT_Running.class);
        startActivity(intent);
    }
}
