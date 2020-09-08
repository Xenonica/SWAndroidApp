package com.example.joshu.fyp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Student_ippt extends AppCompatActivity {

    Spinner gender;
    EditText situps, pushups, mins, secs;
    TextView award, points;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_ippt);

        overridePendingTransition(R.anim.fadein, R.anim.fadeout);

        gender = findViewById(R.id.spinner_Student_Gender);
        situps = findViewById(R.id.editText_Student_Situps);
        pushups = findViewById(R.id.editText_Student_Pushups);
        mins = findViewById(R.id.editText_Student_Min);
        secs = findViewById(R.id.editText_Student_Sec);
        points = findViewById(R.id.textView_Student_points);
        award = findViewById(R.id.textView_Student_award);

        ArrayAdapter<CharSequence> adapter  = ArrayAdapter.createFromResource(this, R.array.gender, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        gender.setAdapter(adapter);

        final int ageGroupSelection= getIntent().getIntExtra("Student_ageGroup", -1);

        gender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                parent.getItemAtPosition(position);
                if(position == 0 && ageGroupSelection == 0){
                    ageGroupMale1();
                }
                if(position == 1 && ageGroupSelection == 0){
                    ageGroupFemale1();
                }
                if(position == 0 && ageGroupSelection == 1){
                    ageGroupMale2();
                }
                if(position == 1 && ageGroupSelection == 1){
                    ageGroupFemale2();
                }
                if(position == 0 && ageGroupSelection == 2){
                    ageGroupMale3();
                }
                if(position == 1 && ageGroupSelection == 2){
                    ageGroupFemale3();
                }
                if(position == 0 && ageGroupSelection == 3){
                    ageGroupMale4();
                }
                if(position == 1 && ageGroupSelection == 3){
                    ageGroupFemale4();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    public void ageGroupMale1()
    {
        Button total = findViewById(R.id.btn_Student_Calculate);

        total.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int situpspoints = 0;
                    int pushupspoints = 0;
                    int runningpoints = 0;
                    int total = 0;

                    //SITUP
                    if (Integer.parseInt(situps.getText().toString()) >= 60) {
                        situpspoints = 25;
                    } else if (Integer.parseInt(situps.getText().toString()) == 59 || Integer.parseInt(situps.getText().toString()) == 58 || Integer.parseInt(situps.getText().toString()) == 57) {
                        situpspoints = 24;
                    } else if (Integer.parseInt(situps.getText().toString()) == 56 || Integer.parseInt(situps.getText().toString()) == 55 || Integer.parseInt(situps.getText().toString()) == 54 || Integer.parseInt(situps.getText().toString()) == 53) {
                        situpspoints = 23;
                    } else if (Integer.parseInt(situps.getText().toString()) == 52 || Integer.parseInt(situps.getText().toString()) == 51 || Integer.parseInt(situps.getText().toString()) == 50 || Integer.parseInt(situps.getText().toString()) == 49) {
                        situpspoints = 22;
                    } else if (Integer.parseInt(situps.getText().toString()) == 48 || Integer.parseInt(situps.getText().toString()) == 47 || Integer.parseInt(situps.getText().toString()) == 46 || Integer.parseInt(situps.getText().toString()) == 45 || Integer.parseInt(situps.getText().toString()) == 44) {
                        situpspoints = 21;
                    } else if (Integer.parseInt(situps.getText().toString()) == 43 || Integer.parseInt(situps.getText().toString()) == 42 || Integer.parseInt(situps.getText().toString()) == 41 || Integer.parseInt(situps.getText().toString()) == 40) {
                        situpspoints = 20;
                    } else if (Integer.parseInt(situps.getText().toString()) == 39 || Integer.parseInt(situps.getText().toString()) == 38) {
                        situpspoints = 19;
                    } else if (Integer.parseInt(situps.getText().toString()) == 37 || Integer.parseInt(situps.getText().toString()) == 36) {
                        situpspoints = 18;
                    } else if (Integer.parseInt(situps.getText().toString()) == 35) {
                        situpspoints = 17;
                    } else if (Integer.parseInt(situps.getText().toString()) == 34) {
                        situpspoints = 16;
                    } else if (Integer.parseInt(situps.getText().toString()) == 33) {
                        situpspoints = 15;
                    } else if (Integer.parseInt(situps.getText().toString()) == 31 || Integer.parseInt(situps.getText().toString()) == 32) {
                        situpspoints = 14;
                    } else if (Integer.parseInt(situps.getText().toString()) == 29 || Integer.parseInt(situps.getText().toString()) == 30) {
                        situpspoints = 13;
                    } else if (Integer.parseInt(situps.getText().toString()) == 28) {
                        situpspoints = 12;
                    } else if (Integer.parseInt(situps.getText().toString()) == 27) {
                        situpspoints = 11;
                    } else if (Integer.parseInt(situps.getText().toString()) == 26) {
                        situpspoints = 10;
                    } else if (Integer.parseInt(situps.getText().toString()) == 25) {
                        situpspoints = 9;
                    } else if (Integer.parseInt(situps.getText().toString()) == 24) {
                        situpspoints = 8;
                    } else if (Integer.parseInt(situps.getText().toString()) == 23 || Integer.parseInt(situps.getText().toString()) == 22) {
                        situpspoints = 7;
                    } else if (Integer.parseInt(situps.getText().toString()) == 21 || Integer.parseInt(situps.getText().toString()) == 20) {
                        situpspoints = 6;
                    } else if (Integer.parseInt(situps.getText().toString()) == 19) {
                        situpspoints = 5;
                    } else if (Integer.parseInt(situps.getText().toString()) == 18) {
                        situpspoints = 4;
                    } else if (Integer.parseInt(situps.getText().toString()) == 17) {
                        situpspoints = 3;
                    } else if (Integer.parseInt(situps.getText().toString()) == 16) {
                        situpspoints = 2;
                    } else if (Integer.parseInt(situps.getText().toString()) == 15) {
                        situpspoints = 1;
                    } else {
                        situpspoints = 0;
                    }

                    //PUSHUP
                    if (Integer.parseInt(pushups.getText().toString()) >= 60) {
                        pushupspoints = 25;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 59 || Integer.parseInt(pushups.getText().toString()) == 58 || Integer.parseInt(pushups.getText().toString()) == 57) {
                        pushupspoints = 24;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 56 || Integer.parseInt(pushups.getText().toString()) == 55 || Integer.parseInt(pushups.getText().toString()) == 54 || Integer.parseInt(pushups.getText().toString()) == 53) {
                        pushupspoints = 23;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 52 || Integer.parseInt(pushups.getText().toString()) == 51 || Integer.parseInt(pushups.getText().toString()) == 50 || Integer.parseInt(pushups.getText().toString()) == 49) {
                        pushupspoints = 22;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 48 || Integer.parseInt(pushups.getText().toString()) == 47 || Integer.parseInt(pushups.getText().toString()) == 46 || Integer.parseInt(pushups.getText().toString()) == 45) {
                        pushupspoints = 21;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 44 || Integer.parseInt(pushups.getText().toString()) == 43 || Integer.parseInt(pushups.getText().toString()) == 42 || Integer.parseInt(pushups.getText().toString()) == 41 || Integer.parseInt(pushups.getText().toString()) == 40) {
                        pushupspoints = 20;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 39 || Integer.parseInt(pushups.getText().toString()) == 38) {
                        pushupspoints = 19;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 37 || Integer.parseInt(pushups.getText().toString()) == 36 || Integer.parseInt(pushups.getText().toString()) == 35) {
                        pushupspoints = 18;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 34 || Integer.parseInt(pushups.getText().toString()) == 33 || Integer.parseInt(pushups.getText().toString()) == 32) {
                        pushupspoints = 17;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 31 || Integer.parseInt(pushups.getText().toString()) == 30 || Integer.parseInt(pushups.getText().toString()) == 29) {
                        pushupspoints = 16;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 28 || Integer.parseInt(pushups.getText().toString()) == 27 || Integer.parseInt(pushups.getText().toString()) == 26) {
                        pushupspoints = 15;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 25) {
                        pushupspoints = 14;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 24) {
                        pushupspoints = 13;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 23) {
                        pushupspoints = 12;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 22) {
                        pushupspoints = 11;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 21) {
                        pushupspoints = 10;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 20) {
                        pushupspoints = 9;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 19) {
                        pushupspoints = 8;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 18) {
                        pushupspoints = 6;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 17) {
                        pushupspoints = 4;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 16) {
                        pushupspoints = 2;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 15) {
                        pushupspoints = 1;
                    } else {
                        pushupspoints = 0;
                    }

                    //2.4km
                    if (Integer.parseInt(mins.getText().toString()) <= 8 && Integer.parseInt(secs.getText().toString()) <= 30) {
                        runningpoints = 50;
                    } else if (Integer.parseInt(mins.getText().toString()) == 8 && Integer.parseInt(secs.getText().toString()) <= 40) {
                        runningpoints = 49;
                    } else if (Integer.parseInt(mins.getText().toString()) == 8 && Integer.parseInt(secs.getText().toString()) <= 50) {
                        runningpoints = 48;
                    } else if (Integer.parseInt(mins.getText().toString()) == 8 && Integer.parseInt(secs.getText().toString()) <= 59) {
                        runningpoints = 46;
                    } else if (Integer.parseInt(mins.getText().toString()) == 9 && Integer.parseInt(secs.getText().toString()) == 0) {
                        runningpoints = 46;
                    } else if (Integer.parseInt(mins.getText().toString()) == 9 && Integer.parseInt(secs.getText().toString()) <= 10) {
                        runningpoints = 44;
                    } else if (Integer.parseInt(mins.getText().toString()) == 9 && Integer.parseInt(secs.getText().toString()) <= 20) {
                        runningpoints = 43;
                    } else if (Integer.parseInt(mins.getText().toString()) == 9 && Integer.parseInt(secs.getText().toString()) <= 30) {
                        runningpoints = 42;
                    } else if (Integer.parseInt(mins.getText().toString()) == 9 && Integer.parseInt(secs.getText().toString()) <= 40) {
                        runningpoints = 41;
                    } else if (Integer.parseInt(mins.getText().toString()) == 9 && Integer.parseInt(secs.getText().toString()) <= 59) {
                        runningpoints = 40;
                    } else if (Integer.parseInt(mins.getText().toString()) == 10 && Integer.parseInt(secs.getText().toString()) == 0) {
                        runningpoints = 40;
                    } else if (Integer.parseInt(mins.getText().toString()) == 10 && Integer.parseInt(secs.getText().toString()) <= 20) {
                        runningpoints = 39;
                    } else if (Integer.parseInt(mins.getText().toString()) == 10 && Integer.parseInt(secs.getText().toString()) <= 40) {
                        runningpoints = 38;
                    } else if (Integer.parseInt(mins.getText().toString()) == 10 && Integer.parseInt(secs.getText().toString()) <= 59) {
                        runningpoints = 37;
                    } else if (Integer.parseInt(mins.getText().toString()) == 11 && Integer.parseInt(secs.getText().toString()) == 0) {
                        runningpoints = 37;
                    } else if (Integer.parseInt(mins.getText().toString()) == 11 && Integer.parseInt(secs.getText().toString()) <= 20) {
                        runningpoints = 36;
                    } else if (Integer.parseInt(mins.getText().toString()) == 11 && Integer.parseInt(secs.getText().toString()) <= 40) {
                        runningpoints = 35;
                    } else if (Integer.parseInt(mins.getText().toString()) == 11 && Integer.parseInt(secs.getText().toString()) <= 50) {
                        runningpoints = 34;
                    } else if (Integer.parseInt(mins.getText().toString()) == 11 && Integer.parseInt(secs.getText().toString()) <= 59) {
                        runningpoints = 33;
                    } else if (Integer.parseInt(mins.getText().toString()) == 12 && Integer.parseInt(secs.getText().toString()) == 0) {
                        runningpoints = 33;
                    } else if (Integer.parseInt(mins.getText().toString()) == 12 && Integer.parseInt(secs.getText().toString()) <= 10) {
                        runningpoints = 32;
                    } else if (Integer.parseInt(mins.getText().toString()) == 12 && Integer.parseInt(secs.getText().toString()) <= 20) {
                        runningpoints = 31;
                    } else if (Integer.parseInt(mins.getText().toString()) == 12 && Integer.parseInt(secs.getText().toString()) <= 30) {
                        runningpoints = 30;
                    } else if (Integer.parseInt(mins.getText().toString()) == 12 && Integer.parseInt(secs.getText().toString()) <= 40) {
                        runningpoints = 29;
                    } else if (Integer.parseInt(mins.getText().toString()) == 12 && Integer.parseInt(secs.getText().toString()) <= 50) {
                        runningpoints = 28;
                    } else if (Integer.parseInt(mins.getText().toString()) == 12 && Integer.parseInt(secs.getText().toString()) <= 59) {
                        runningpoints = 27;
                    } else if (Integer.parseInt(mins.getText().toString()) == 13 && Integer.parseInt(secs.getText().toString()) == 0) {
                        runningpoints = 27;
                    } else if (Integer.parseInt(mins.getText().toString()) == 13 && Integer.parseInt(secs.getText().toString()) <= 10) {
                        runningpoints = 26;
                    } else if (Integer.parseInt(mins.getText().toString()) == 13 && Integer.parseInt(secs.getText().toString()) <= 20) {
                        runningpoints = 25;
                    } else if (Integer.parseInt(mins.getText().toString()) == 13 && Integer.parseInt(secs.getText().toString()) <= 30) {
                        runningpoints = 24;
                    } else if (Integer.parseInt(mins.getText().toString()) == 13 && Integer.parseInt(secs.getText().toString()) <= 40) {
                        runningpoints = 23;
                    } else if (Integer.parseInt(mins.getText().toString()) == 13 && Integer.parseInt(secs.getText().toString()) <= 50) {
                        runningpoints = 22;
                    } else if (Integer.parseInt(mins.getText().toString()) == 13 && Integer.parseInt(secs.getText().toString()) <= 59) {
                        runningpoints = 21;
                    } else if (Integer.parseInt(mins.getText().toString()) == 14 && Integer.parseInt(secs.getText().toString()) == 0) {
                        runningpoints = 21;
                    } else if (Integer.parseInt(mins.getText().toString()) == 14 && Integer.parseInt(secs.getText().toString()) <= 10) {
                        runningpoints = 20;
                    } else if (Integer.parseInt(mins.getText().toString()) == 14 && Integer.parseInt(secs.getText().toString()) <= 20) {
                        runningpoints = 19;
                    } else if (Integer.parseInt(mins.getText().toString()) == 14 && Integer.parseInt(secs.getText().toString()) <= 30) {
                        runningpoints = 18;
                    } else if (Integer.parseInt(mins.getText().toString()) == 14 && Integer.parseInt(secs.getText().toString()) <= 40) {
                        runningpoints = 16;
                    } else if (Integer.parseInt(mins.getText().toString()) == 14 && Integer.parseInt(secs.getText().toString()) <= 50) {
                        runningpoints = 14;
                    } else if (Integer.parseInt(mins.getText().toString()) == 14 && Integer.parseInt(secs.getText().toString()) <= 59) {
                        runningpoints = 12;
                    } else if (Integer.parseInt(mins.getText().toString()) == 15 && Integer.parseInt(secs.getText().toString()) == 0) {
                        runningpoints = 12;
                    } else if (Integer.parseInt(mins.getText().toString()) == 15 && Integer.parseInt(secs.getText().toString()) <= 10) {
                        runningpoints = 10;
                    } else if (Integer.parseInt(mins.getText().toString()) == 15 && Integer.parseInt(secs.getText().toString()) <= 20) {
                        runningpoints = 8;
                    } else if (Integer.parseInt(mins.getText().toString()) == 15 && Integer.parseInt(secs.getText().toString()) <= 30) {
                        runningpoints = 6;
                    } else if (Integer.parseInt(mins.getText().toString()) == 15 && Integer.parseInt(secs.getText().toString()) <= 40) {
                        runningpoints = 4;
                    } else if (Integer.parseInt(mins.getText().toString()) == 15 && Integer.parseInt(secs.getText().toString()) <= 50) {
                        runningpoints = 2;
                    } else if (Integer.parseInt(mins.getText().toString()) == 15 && Integer.parseInt(secs.getText().toString()) <= 59) {
                        runningpoints = 1;
                    } else if (Integer.parseInt(mins.getText().toString()) == 16 && Integer.parseInt(secs.getText().toString()) == 0) {
                        runningpoints = 1;
                    } else {
                        runningpoints = 0;
                    }

                    total = situpspoints + pushupspoints + runningpoints;

                    if (total <= 49) {
                        award.setText("Failed");
                    } else if (total <= 59) {
                        award.setText("Pass");
                    } else if (total <= 69) {
                        award.setText("Pass with incentive");
                    } else if (total <= 79) {
                        award.setText("Silver");
                    } else {
                        award.setText("Gold");
                    }

                    points.setText(Integer.toString(total));
                }
                catch (Exception e)
                {
                    Toast.makeText(Student_ippt.this, "Please enter valid entries", Toast.LENGTH_SHORT).show();
                }

            }});


    }

    public void ageGroupMale2()
    {
        Button total = findViewById(R.id.btn_Student_Calculate);

        total.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int situpspoints = 0;
                    int pushupspoints = 0;
                    int runningpoints = 0;
                    int total = 0;

                    //SITUP
                    if (Integer.parseInt(situps.getText().toString()) >= 59) {
                        situpspoints = 25;
                    } else if (Integer.parseInt(situps.getText().toString()) == 58 || Integer.parseInt(situps.getText().toString()) == 57 || Integer.parseInt(situps.getText().toString()) == 56) {
                        situpspoints = 24;
                    } else if (Integer.parseInt(situps.getText().toString()) == 55 || Integer.parseInt(situps.getText().toString()) == 54 || Integer.parseInt(situps.getText().toString()) == 53 || Integer.parseInt(situps.getText().toString()) == 52 ) {
                        situpspoints = 23;
                    } else if (Integer.parseInt(situps.getText().toString()) == 51 || Integer.parseInt(situps.getText().toString()) == 50 || Integer.parseInt(situps.getText().toString()) == 49 || Integer.parseInt(situps.getText().toString()) == 48) {
                        situpspoints = 22;
                    } else if (Integer.parseInt(situps.getText().toString()) == 47 || Integer.parseInt(situps.getText().toString()) == 46 || Integer.parseInt(situps.getText().toString()) == 45 || Integer.parseInt(situps.getText().toString()) == 44) {
                        situpspoints = 21;
                    } else if (Integer.parseInt(situps.getText().toString()) == 43 || Integer.parseInt(situps.getText().toString()) == 42 || Integer.parseInt(situps.getText().toString()) == 41 || Integer.parseInt(situps.getText().toString()) == 40 || Integer.parseInt(situps.getText().toString()) == 39) {
                        situpspoints = 20;
                    } else if (Integer.parseInt(situps.getText().toString()) == 38 || Integer.parseInt(situps.getText().toString()) == 37 ) {
                        situpspoints = 19;
                    } else if (Integer.parseInt(situps.getText().toString()) == 36 || Integer.parseInt(situps.getText().toString()) == 35) {
                        situpspoints = 18;
                    } else if (Integer.parseInt(situps.getText().toString()) == 34) {
                        situpspoints = 17;
                    } else if (Integer.parseInt(situps.getText().toString()) == 33) {
                        situpspoints = 16;
                    } else if (Integer.parseInt(situps.getText().toString()) == 32) {
                        situpspoints = 15;
                    } else if (Integer.parseInt(situps.getText().toString()) == 31 || Integer.parseInt(situps.getText().toString()) == 30) {
                        situpspoints = 14;
                    } else if (Integer.parseInt(situps.getText().toString()) == 29 || Integer.parseInt(situps.getText().toString()) == 28) {
                        situpspoints = 13;
                    } else if (Integer.parseInt(situps.getText().toString()) == 27) {
                        situpspoints = 12;
                    } else if (Integer.parseInt(situps.getText().toString()) == 26) {
                        situpspoints = 11;
                    } else if (Integer.parseInt(situps.getText().toString()) == 25) {
                        situpspoints = 10;
                    } else if (Integer.parseInt(situps.getText().toString()) == 24) {
                        situpspoints = 9;
                    } else if (Integer.parseInt(situps.getText().toString()) == 23) {
                        situpspoints = 8;
                    } else if (Integer.parseInt(situps.getText().toString()) == 22 || Integer.parseInt(situps.getText().toString()) == 21) {
                        situpspoints = 7;
                    } else if (Integer.parseInt(situps.getText().toString()) == 20 || Integer.parseInt(situps.getText().toString()) == 19) {
                        situpspoints = 6;
                    } else if (Integer.parseInt(situps.getText().toString()) == 18) {
                        situpspoints = 5;
                    } else if (Integer.parseInt(situps.getText().toString()) == 17) {
                        situpspoints = 4;
                    } else if (Integer.parseInt(situps.getText().toString()) == 16) {
                        situpspoints = 3;
                    } else if (Integer.parseInt(situps.getText().toString()) == 15) {
                        situpspoints = 2;
                    } else if (Integer.parseInt(situps.getText().toString()) == 14) {
                        situpspoints = 1;
                    } else {
                        situpspoints = 0;
                    }

                    //PUSHUP
                    if (Integer.parseInt(pushups.getText().toString()) >= 59) {
                        pushupspoints = 25;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 58 || Integer.parseInt(pushups.getText().toString()) == 57 || Integer.parseInt(pushups.getText().toString()) == 56) {
                        pushupspoints = 24;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 55 || Integer.parseInt(pushups.getText().toString()) == 54 || Integer.parseInt(pushups.getText().toString()) == 53 || Integer.parseInt(pushups.getText().toString()) == 52) {
                        pushupspoints = 23;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 51 || Integer.parseInt(pushups.getText().toString()) == 50 || Integer.parseInt(pushups.getText().toString()) == 49 || Integer.parseInt(pushups.getText().toString()) == 48) {
                        pushupspoints = 22;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 47 || Integer.parseInt(pushups.getText().toString()) == 46 || Integer.parseInt(pushups.getText().toString()) == 45 || Integer.parseInt(pushups.getText().toString()) == 44) {
                        pushupspoints = 21;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 43 || Integer.parseInt(pushups.getText().toString()) == 42 || Integer.parseInt(pushups.getText().toString()) == 41 || Integer.parseInt(pushups.getText().toString()) == 40 || Integer.parseInt(pushups.getText().toString()) == 39 ) {
                        pushupspoints = 20;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 38 || Integer.parseInt(pushups.getText().toString()) == 37) {
                        pushupspoints = 19;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 36 || Integer.parseInt(pushups.getText().toString()) == 35 || Integer.parseInt(pushups.getText().toString()) == 34) {
                        pushupspoints = 18;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 33 || Integer.parseInt(pushups.getText().toString()) == 32 || Integer.parseInt(pushups.getText().toString()) == 31) {
                        pushupspoints = 17;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 30 || Integer.parseInt(pushups.getText().toString()) == 29 || Integer.parseInt(pushups.getText().toString()) == 28) {
                        pushupspoints = 16;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 27 || Integer.parseInt(pushups.getText().toString()) == 26 || Integer.parseInt(pushups.getText().toString()) == 25 ) {
                        pushupspoints = 15;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 24) {
                        pushupspoints = 14;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 23) {
                        pushupspoints = 13;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 22) {
                        pushupspoints = 12;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 21) {
                        pushupspoints = 11;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 20) {
                        pushupspoints = 10;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 19) {
                        pushupspoints = 9;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 18) {
                        pushupspoints = 8;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 17) {
                        pushupspoints = 6;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 16) {
                        pushupspoints = 4;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 15) {
                        pushupspoints = 2;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 14) {
                        pushupspoints = 1;
                    } else {
                        pushupspoints = 0;
                    }

                    //2.4KM
                    if (Integer.parseInt(mins.getText().toString()) <= 8 && Integer.parseInt(secs.getText().toString()) <= 40) {
                        runningpoints = 50;
                    } else if (Integer.parseInt(mins.getText().toString()) == 8 && Integer.parseInt(secs.getText().toString()) <= 50) {
                        runningpoints = 49;
                    } else if (Integer.parseInt(mins.getText().toString()) == 8 && Integer.parseInt(secs.getText().toString()) <= 59) {
                        runningpoints = 48;
                    } else if (Integer.parseInt(mins.getText().toString()) == 9 && Integer.parseInt(secs.getText().toString()) == 0) {
                        runningpoints = 48;
                    } else if (Integer.parseInt(mins.getText().toString()) == 9 && Integer.parseInt(secs.getText().toString()) <= 10) {
                        runningpoints = 46;
                    } else if (Integer.parseInt(mins.getText().toString()) == 9 && Integer.parseInt(secs.getText().toString()) <= 20) {
                        runningpoints = 44;
                    } else if (Integer.parseInt(mins.getText().toString()) == 9 && Integer.parseInt(secs.getText().toString()) <= 30) {
                        runningpoints = 43;
                    } else if (Integer.parseInt(mins.getText().toString()) == 9 && Integer.parseInt(secs.getText().toString()) <= 40) {
                        runningpoints = 42;
                    } else if (Integer.parseInt(mins.getText().toString()) == 9 && Integer.parseInt(secs.getText().toString()) <= 50) {
                        runningpoints = 41;
                    } else if (Integer.parseInt(mins.getText().toString()) == 9 && Integer.parseInt(secs.getText().toString()) <= 59) {
                        runningpoints = 40;
                    } else if (Integer.parseInt(mins.getText().toString()) == 10 && Integer.parseInt(secs.getText().toString()) <= 10) {
                        runningpoints = 40;
                    } else if (Integer.parseInt(mins.getText().toString()) == 10 && Integer.parseInt(secs.getText().toString()) <= 30) {
                        runningpoints = 39;
                    } else if (Integer.parseInt(mins.getText().toString()) == 10 && Integer.parseInt(secs.getText().toString()) <= 50) {
                        runningpoints = 38;
                    } else if (Integer.parseInt(mins.getText().toString()) == 10 && Integer.parseInt(secs.getText().toString()) <= 59) {
                        runningpoints = 37;
                    } else if (Integer.parseInt(mins.getText().toString()) == 11 && Integer.parseInt(secs.getText().toString()) <= 10) {
                        runningpoints = 37;
                    } else if (Integer.parseInt(mins.getText().toString()) == 11 && Integer.parseInt(secs.getText().toString()) <= 20) {
                        runningpoints = 36;
                    } else if (Integer.parseInt(mins.getText().toString()) == 11 && Integer.parseInt(secs.getText().toString()) <= 30) {
                        runningpoints = 36;
                    } else if (Integer.parseInt(mins.getText().toString()) == 11 && Integer.parseInt(secs.getText().toString()) <= 50) {
                        runningpoints = 35;
                    } else if (Integer.parseInt(mins.getText().toString()) == 11 && Integer.parseInt(secs.getText().toString()) <= 59) {
                        runningpoints = 34;
                    } else if (Integer.parseInt(mins.getText().toString()) == 12 && Integer.parseInt(secs.getText().toString()) == 0) {
                        runningpoints = 34;
                    } else if (Integer.parseInt(mins.getText().toString()) == 12 && Integer.parseInt(secs.getText().toString()) <= 10) {
                        runningpoints = 33;
                    } else if (Integer.parseInt(mins.getText().toString()) == 12 && Integer.parseInt(secs.getText().toString()) <= 20) {
                        runningpoints = 32;
                    } else if (Integer.parseInt(mins.getText().toString()) == 12 && Integer.parseInt(secs.getText().toString()) <= 30) {
                        runningpoints = 31;
                    } else if (Integer.parseInt(mins.getText().toString()) == 12 && Integer.parseInt(secs.getText().toString()) <= 40) {
                        runningpoints = 30;
                    } else if (Integer.parseInt(mins.getText().toString()) == 12 && Integer.parseInt(secs.getText().toString()) <= 50) {
                        runningpoints = 29;
                    } else if (Integer.parseInt(mins.getText().toString()) == 12 && Integer.parseInt(secs.getText().toString()) <= 59) {
                        runningpoints = 28;
                    } else if (Integer.parseInt(mins.getText().toString()) == 13 && Integer.parseInt(secs.getText().toString()) == 0) {
                        runningpoints = 28;
                    } else if (Integer.parseInt(mins.getText().toString()) == 13 && Integer.parseInt(secs.getText().toString()) <= 10) {
                        runningpoints = 27;
                    } else if (Integer.parseInt(mins.getText().toString()) == 13 && Integer.parseInt(secs.getText().toString()) <= 20) {
                        runningpoints = 26;
                    } else if (Integer.parseInt(mins.getText().toString()) == 13 && Integer.parseInt(secs.getText().toString()) <= 30) {
                        runningpoints = 25;
                    } else if (Integer.parseInt(mins.getText().toString()) == 13 && Integer.parseInt(secs.getText().toString()) <= 40) {
                        runningpoints = 24;
                    } else if (Integer.parseInt(mins.getText().toString()) == 13 && Integer.parseInt(secs.getText().toString()) <= 50) {
                        runningpoints = 23;
                    } else if (Integer.parseInt(mins.getText().toString()) == 13 && Integer.parseInt(secs.getText().toString()) <= 59) {
                        runningpoints = 22;
                    } else if (Integer.parseInt(mins.getText().toString()) == 14 && Integer.parseInt(secs.getText().toString()) == 0) {
                        runningpoints = 22;
                    } else if (Integer.parseInt(mins.getText().toString()) == 14 && Integer.parseInt(secs.getText().toString()) <= 10) {
                        runningpoints = 21;
                    } else if (Integer.parseInt(mins.getText().toString()) == 14 && Integer.parseInt(secs.getText().toString()) <= 20) {
                        runningpoints = 20;
                    } else if (Integer.parseInt(mins.getText().toString()) == 14 && Integer.parseInt(secs.getText().toString()) <= 30) {
                        runningpoints = 19;
                    } else if (Integer.parseInt(mins.getText().toString()) == 14 && Integer.parseInt(secs.getText().toString()) <= 40) {
                        runningpoints = 18;
                    } else if (Integer.parseInt(mins.getText().toString()) == 14 && Integer.parseInt(secs.getText().toString()) <= 50) {
                        runningpoints = 16;
                    } else if (Integer.parseInt(mins.getText().toString()) == 14 && Integer.parseInt(secs.getText().toString()) <= 59) {
                        runningpoints = 14;
                    } else if (Integer.parseInt(mins.getText().toString()) == 15 && Integer.parseInt(secs.getText().toString()) == 0) {
                        runningpoints = 14;
                    } else if (Integer.parseInt(mins.getText().toString()) == 15 && Integer.parseInt(secs.getText().toString()) <= 10) {
                        runningpoints = 12;
                    } else if (Integer.parseInt(mins.getText().toString()) == 15 && Integer.parseInt(secs.getText().toString()) <= 20) {
                        runningpoints = 10;
                    } else if (Integer.parseInt(mins.getText().toString()) == 15 && Integer.parseInt(secs.getText().toString()) <= 30) {
                        runningpoints = 8;
                    } else if (Integer.parseInt(mins.getText().toString()) == 15 && Integer.parseInt(secs.getText().toString()) <= 40) {
                        runningpoints = 6;
                    } else if (Integer.parseInt(mins.getText().toString()) == 15 && Integer.parseInt(secs.getText().toString()) <= 50) {
                        runningpoints = 4;
                    } else if (Integer.parseInt(mins.getText().toString()) == 15 && Integer.parseInt(secs.getText().toString()) <= 59) {
                        runningpoints = 2;
                    } else if (Integer.parseInt(mins.getText().toString()) == 16 && Integer.parseInt(secs.getText().toString()) == 0) {
                        runningpoints = 2;
                    } else if (Integer.parseInt(mins.getText().toString()) == 16 && Integer.parseInt(secs.getText().toString()) <= 10) {
                        runningpoints = 1;
                    } else {
                        runningpoints = 0;
                    }

                    total = situpspoints + pushupspoints + runningpoints;

                    if (total <= 49) {
                        award.setText("Failed");
                    } else if (total <= 59) {
                        award.setText("Pass");
                    } else if (total <= 69) {
                        award.setText("Pass with incentive");
                    } else if (total <= 79) {
                        award.setText("Silver");
                    } else {
                        award.setText("Gold");
                    }

                    points.setText(Integer.toString(total));
                }
                catch (Exception e) {
                    Toast.makeText(Student_ippt.this, "Please enter valid entries", Toast.LENGTH_SHORT).show();
                }

            }});
    }

    public void ageGroupMale3()
    {
        Button total = findViewById(R.id.btn_Student_Calculate);

        total.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int situpspoints = 0;
                    int pushupspoints = 0;
                    int runningpoints = 0;
                    int total = 0;

                    //SITUP
                    if (Integer.parseInt(situps.getText().toString()) >= 58) {
                        situpspoints = 25;
                    } else if (Integer.parseInt(situps.getText().toString()) == 57 || Integer.parseInt(situps.getText().toString()) == 56 || Integer.parseInt(situps.getText().toString()) == 55 || Integer.parseInt(situps.getText().toString()) == 54) {
                        situpspoints = 24;
                    } else if (Integer.parseInt(situps.getText().toString()) == 53 || Integer.parseInt(situps.getText().toString()) == 52 || Integer.parseInt(situps.getText().toString()) == 51 || Integer.parseInt(situps.getText().toString()) == 50) {
                        situpspoints = 23;
                    } else if (Integer.parseInt(situps.getText().toString()) == 49 || Integer.parseInt(situps.getText().toString()) == 48 || Integer.parseInt(situps.getText().toString()) == 47 || Integer.parseInt(situps.getText().toString()) == 46 ) {
                        situpspoints = 22;
                    } else if (Integer.parseInt(situps.getText().toString()) == 45 || Integer.parseInt(situps.getText().toString()) == 44 || Integer.parseInt(situps.getText().toString()) == 43 || Integer.parseInt(situps.getText().toString()) == 42) {
                        situpspoints = 21;
                    } else if (Integer.parseInt(situps.getText().toString()) == 41 || Integer.parseInt(situps.getText().toString()) == 40 || Integer.parseInt(situps.getText().toString()) == 39 || Integer.parseInt(situps.getText().toString()) == 38) {
                        situpspoints = 20;
                    } else if (Integer.parseInt(situps.getText().toString()) == 37 || Integer.parseInt(situps.getText().toString()) == 36) {
                        situpspoints = 19;
                    } else if (Integer.parseInt(situps.getText().toString()) == 35 || Integer.parseInt(situps.getText().toString()) == 34) {
                        situpspoints = 18;
                    } else if (Integer.parseInt(situps.getText().toString()) == 33) {
                        situpspoints = 17;
                    } else if (Integer.parseInt(situps.getText().toString()) == 32) {
                        situpspoints = 16;
                    } else if (Integer.parseInt(situps.getText().toString()) == 31) {
                        situpspoints = 15;
                    } else if (Integer.parseInt(situps.getText().toString()) == 30 || Integer.parseInt(situps.getText().toString()) == 29) {
                        situpspoints = 14;
                    } else if (Integer.parseInt(situps.getText().toString()) == 28 || Integer.parseInt(situps.getText().toString()) == 27) {
                        situpspoints = 13;
                    } else if (Integer.parseInt(situps.getText().toString()) == 26) {
                        situpspoints = 12;
                    } else if (Integer.parseInt(situps.getText().toString()) == 25) {
                        situpspoints = 11;
                    } else if (Integer.parseInt(situps.getText().toString()) == 24) {
                        situpspoints = 10;
                    } else if (Integer.parseInt(situps.getText().toString()) == 23) {
                        situpspoints = 9;
                    } else if (Integer.parseInt(situps.getText().toString()) == 22) {
                        situpspoints = 8;
                    } else if (Integer.parseInt(situps.getText().toString()) == 21 || Integer.parseInt(situps.getText().toString()) == 20) {
                        situpspoints = 7;
                    } else if (Integer.parseInt(situps.getText().toString()) == 19 || Integer.parseInt(situps.getText().toString()) == 18) {
                        situpspoints = 6;
                    } else if (Integer.parseInt(situps.getText().toString()) == 17) {
                        situpspoints = 5;
                    } else if (Integer.parseInt(situps.getText().toString()) == 16) {
                        situpspoints = 4;
                    } else if (Integer.parseInt(situps.getText().toString()) == 15) {
                        situpspoints = 3;
                    } else if (Integer.parseInt(situps.getText().toString()) == 14) {
                        situpspoints = 2;
                    } else if (Integer.parseInt(situps.getText().toString()) == 13) {
                        situpspoints = 1;
                    } else {
                        situpspoints = 0;
                    }

                    //PUSHUP
                    if (Integer.parseInt(pushups.getText().toString()) >= 58) {
                        pushupspoints = 25;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 57 || Integer.parseInt(pushups.getText().toString()) == 56 || Integer.parseInt(pushups.getText().toString()) == 55) {
                        pushupspoints = 24;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 54 || Integer.parseInt(pushups.getText().toString()) == 53 || Integer.parseInt(pushups.getText().toString()) == 52 || Integer.parseInt(pushups.getText().toString()) == 51) {
                        pushupspoints = 23;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 50 || Integer.parseInt(pushups.getText().toString()) == 49 || Integer.parseInt(pushups.getText().toString()) == 48) {
                        pushupspoints = 22;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 47 || Integer.parseInt(pushups.getText().toString()) == 46 || Integer.parseInt(pushups.getText().toString()) == 45 || Integer.parseInt(pushups.getText().toString()) == 44) {
                        pushupspoints = 21;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 43 || Integer.parseInt(pushups.getText().toString()) == 42 || Integer.parseInt(pushups.getText().toString()) == 41 || Integer.parseInt(pushups.getText().toString()) == 40 || Integer.parseInt(pushups.getText().toString()) == 39 || Integer.parseInt(pushups.getText().toString()) == 38) {
                        pushupspoints = 20;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 37 || Integer.parseInt(pushups.getText().toString()) == 36) {
                        pushupspoints = 19;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 35 || Integer.parseInt(pushups.getText().toString()) == 34 || Integer.parseInt(pushups.getText().toString()) == 33) {
                        pushupspoints = 18;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 32 || Integer.parseInt(pushups.getText().toString()) == 31 || Integer.parseInt(pushups.getText().toString()) == 30) {
                        pushupspoints = 17;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 29 || Integer.parseInt(pushups.getText().toString()) == 28 || Integer.parseInt(pushups.getText().toString()) == 27) {
                        pushupspoints = 16;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 26 || Integer.parseInt(pushups.getText().toString()) == 25 || Integer.parseInt(pushups.getText().toString()) == 24) {
                        pushupspoints = 15;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 23) {
                        pushupspoints = 14;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 22) {
                        pushupspoints = 13;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 21) {
                        pushupspoints = 12;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 20) {
                        pushupspoints = 11;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 19) {
                        pushupspoints = 10;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 18) {
                        pushupspoints = 9;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 17) {
                        pushupspoints = 8;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 16) {
                        pushupspoints = 6;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 15) {
                        pushupspoints = 4;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 14) {
                        pushupspoints = 2;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 13) {
                        pushupspoints = 1;
                    } else {
                        pushupspoints = 0;
                    }

                    //2.4km
                    if (Integer.parseInt(mins.getText().toString()) <= 8 && Integer.parseInt(secs.getText().toString()) <= 50) {
                        runningpoints = 50;
                    } else if (Integer.parseInt(mins.getText().toString()) == 8 && Integer.parseInt(secs.getText().toString()) <= 59) {
                        runningpoints = 49;
                    } else if (Integer.parseInt(mins.getText().toString()) == 9 && Integer.parseInt(secs.getText().toString()) == 0) {
                        runningpoints = 49;
                    } else if (Integer.parseInt(mins.getText().toString()) == 9 && Integer.parseInt(secs.getText().toString()) <= 10) {
                        runningpoints = 48;
                    } else if (Integer.parseInt(mins.getText().toString()) == 9 && Integer.parseInt(secs.getText().toString()) <= 20) {
                        runningpoints = 46;
                    } else if (Integer.parseInt(mins.getText().toString()) == 9 && Integer.parseInt(secs.getText().toString()) <= 30) {
                        runningpoints = 44;
                    } else if (Integer.parseInt(mins.getText().toString()) == 9 && Integer.parseInt(secs.getText().toString()) <= 40) {
                        runningpoints = 43;
                    } else if (Integer.parseInt(mins.getText().toString()) == 9 && Integer.parseInt(secs.getText().toString()) <= 50) {
                        runningpoints = 42;
                    } else if (Integer.parseInt(mins.getText().toString()) == 9 && Integer.parseInt(secs.getText().toString()) <= 59) {
                        runningpoints = 41;
                    } else if (Integer.parseInt(mins.getText().toString()) == 10 && Integer.parseInt(secs.getText().toString()) == 0 ) {
                        runningpoints = 41;
                    } else if (Integer.parseInt(mins.getText().toString()) == 10 && Integer.parseInt(secs.getText().toString()) <= 20) {
                        runningpoints = 40;
                    } else if (Integer.parseInt(mins.getText().toString()) == 10 && Integer.parseInt(secs.getText().toString()) <= 40) {
                        runningpoints = 39;
                    } else if (Integer.parseInt(mins.getText().toString()) == 10 && Integer.parseInt(secs.getText().toString()) <= 59) {
                        runningpoints = 38;
                    } else if (Integer.parseInt(mins.getText().toString()) == 11 && Integer.parseInt(secs.getText().toString()) == 0) {
                        runningpoints = 38;
                    } else if (Integer.parseInt(mins.getText().toString()) == 11 && Integer.parseInt(secs.getText().toString()) <= 20) {
                        runningpoints = 37;
                    } else if (Integer.parseInt(mins.getText().toString()) == 11 && Integer.parseInt(secs.getText().toString()) <= 40) {
                        runningpoints = 36;
                    } else if (Integer.parseInt(mins.getText().toString()) == 11 && Integer.parseInt(secs.getText().toString()) <= 59) {
                        runningpoints = 35;
                    } else if (Integer.parseInt(mins.getText().toString()) == 12 && Integer.parseInt(secs.getText().toString()) == 0) {
                        runningpoints = 35;
                    } else if (Integer.parseInt(mins.getText().toString()) == 12 && Integer.parseInt(secs.getText().toString()) <= 10) {
                        runningpoints = 34;
                    } else if (Integer.parseInt(mins.getText().toString()) == 12 && Integer.parseInt(secs.getText().toString()) <= 20) {
                        runningpoints = 33;
                    } else if (Integer.parseInt(mins.getText().toString()) == 12 && Integer.parseInt(secs.getText().toString()) <= 30) {
                        runningpoints = 32;
                    } else if (Integer.parseInt(mins.getText().toString()) == 12 && Integer.parseInt(secs.getText().toString()) <= 40) {
                        runningpoints = 31;
                    } else if (Integer.parseInt(mins.getText().toString()) == 12 && Integer.parseInt(secs.getText().toString()) <= 50) {
                        runningpoints = 30;
                    } else if (Integer.parseInt(mins.getText().toString()) == 12 && Integer.parseInt(secs.getText().toString()) <= 59) {
                        runningpoints = 29;
                    } else if (Integer.parseInt(mins.getText().toString()) == 13 && Integer.parseInt(secs.getText().toString()) == 0) {
                        runningpoints = 29;
                    } else if (Integer.parseInt(mins.getText().toString()) == 13 && Integer.parseInt(secs.getText().toString()) == 10 ) {
                        runningpoints = 28;
                    } else if (Integer.parseInt(mins.getText().toString()) == 13 && Integer.parseInt(secs.getText().toString()) <= 20) {
                        runningpoints = 27;
                    } else if (Integer.parseInt(mins.getText().toString()) == 13 && Integer.parseInt(secs.getText().toString()) <= 30) {
                        runningpoints = 26;
                    } else if (Integer.parseInt(mins.getText().toString()) == 13 && Integer.parseInt(secs.getText().toString()) <= 40) {
                        runningpoints = 25;
                    } else if (Integer.parseInt(mins.getText().toString()) == 13 && Integer.parseInt(secs.getText().toString()) <= 50) {
                        runningpoints = 24;
                    } else if (Integer.parseInt(mins.getText().toString()) == 13 && Integer.parseInt(secs.getText().toString()) <= 59) {
                        runningpoints = 23;
                    } else if (Integer.parseInt(mins.getText().toString()) == 14 && Integer.parseInt(secs.getText().toString()) == 0) {
                        runningpoints = 23;
                    } else if (Integer.parseInt(mins.getText().toString()) == 14 && Integer.parseInt(secs.getText().toString()) <=10) {
                        runningpoints = 22;
                    } else if (Integer.parseInt(mins.getText().toString()) == 14 && Integer.parseInt(secs.getText().toString()) <= 20) {
                        runningpoints = 21;
                    } else if (Integer.parseInt(mins.getText().toString()) == 14 && Integer.parseInt(secs.getText().toString()) <= 30) {
                        runningpoints = 20;
                    } else if (Integer.parseInt(mins.getText().toString()) == 14 && Integer.parseInt(secs.getText().toString()) <= 40) {
                        runningpoints = 19;
                    } else if (Integer.parseInt(mins.getText().toString()) == 14 && Integer.parseInt(secs.getText().toString()) <= 50) {
                        runningpoints = 18;
                    } else if (Integer.parseInt(mins.getText().toString()) == 14 && Integer.parseInt(secs.getText().toString()) <= 59) {
                        runningpoints = 16;
                    } else if (Integer.parseInt(mins.getText().toString()) == 15 && Integer.parseInt(secs.getText().toString()) == 0) {
                        runningpoints = 16;
                    } else if (Integer.parseInt(mins.getText().toString()) == 15 && Integer.parseInt(secs.getText().toString()) <= 10) {
                        runningpoints = 14;
                    } else if (Integer.parseInt(mins.getText().toString()) == 15 && Integer.parseInt(secs.getText().toString()) <= 20) {
                        runningpoints = 12;
                    } else if (Integer.parseInt(mins.getText().toString()) == 15 && Integer.parseInt(secs.getText().toString()) <= 30) {
                        runningpoints = 10;
                    } else if (Integer.parseInt(mins.getText().toString()) == 15 && Integer.parseInt(secs.getText().toString()) <= 40) {
                        runningpoints = 8;
                    } else if (Integer.parseInt(mins.getText().toString()) == 15 && Integer.parseInt(secs.getText().toString()) <= 50) {
                        runningpoints = 6;
                    } else if (Integer.parseInt(mins.getText().toString()) == 15 && Integer.parseInt(secs.getText().toString()) <= 59) {
                        runningpoints = 4;
                    } else if (Integer.parseInt(mins.getText().toString()) == 16 && Integer.parseInt(secs.getText().toString()) == 0) {
                        runningpoints = 4;
                    } else if (Integer.parseInt(mins.getText().toString()) == 16 && Integer.parseInt(secs.getText().toString()) <= 10) {
                        runningpoints = 2;
                    } else if (Integer.parseInt(mins.getText().toString()) == 16 && Integer.parseInt(secs.getText().toString()) <= 20) {
                        runningpoints = 1;
                    } else {
                        runningpoints = 0;
                    }

                    total = situpspoints + pushupspoints + runningpoints;

                    if (total <= 49) {
                        award.setText("Failed");
                    } else if (total <= 59) {
                        award.setText("Pass");
                    } else if (total <= 69) {
                        award.setText("Pass with incentive");
                    } else if (total <= 79) {
                        award.setText("Silver");
                    } else {
                        award.setText("Gold");
                    }

                    points.setText(Integer.toString(total));
                }
                catch (Exception e) {
                    Toast.makeText(Student_ippt.this, "Please enter valid entries", Toast.LENGTH_SHORT).show();
                }

            }});
    }

    public void ageGroupMale4()
    {
        Button total = findViewById(R.id.btn_Student_Calculate);

        total.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int situpspoints = 0;
                    int pushupspoints = 0;
                    int runningpoints = 0;
                    int total = 0;

                    //SITUP
                    if (Integer.parseInt(situps.getText().toString()) >= 57) {
                        situpspoints = 25;
                    } else if (Integer.parseInt(situps.getText().toString()) == 56 || Integer.parseInt(situps.getText().toString()) == 55 || Integer.parseInt(situps.getText().toString()) == 54 ) {
                        situpspoints = 24;
                    } else if (Integer.parseInt(situps.getText().toString()) == 53 || Integer.parseInt(situps.getText().toString()) == 52 || Integer.parseInt(situps.getText().toString()) == 51 || Integer.parseInt(situps.getText().toString()) == 50) {
                        situpspoints = 23;
                    } else if (Integer.parseInt(situps.getText().toString()) == 49 || Integer.parseInt(situps.getText().toString()) == 48 || Integer.parseInt(situps.getText().toString()) == 47 || Integer.parseInt(situps.getText().toString()) == 46) {
                        situpspoints = 22;
                    } else if (Integer.parseInt(situps.getText().toString()) == 45 || Integer.parseInt(situps.getText().toString()) == 44 || Integer.parseInt(situps.getText().toString()) == 43 || Integer.parseInt(situps.getText().toString()) == 42) {
                        situpspoints = 21;
                    } else if (Integer.parseInt(situps.getText().toString()) == 41 || Integer.parseInt(situps.getText().toString()) == 40 || Integer.parseInt(situps.getText().toString()) == 39 || Integer.parseInt(situps.getText().toString()) == 38 || Integer.parseInt(situps.getText().toString()) == 37) {
                        situpspoints = 20;
                    } else if (Integer.parseInt(situps.getText().toString()) == 36 || Integer.parseInt(situps.getText().toString()) == 35) {
                        situpspoints = 19;
                    } else if (Integer.parseInt(situps.getText().toString()) == 34 || Integer.parseInt(situps.getText().toString()) == 33) {
                        situpspoints = 18;
                    } else if (Integer.parseInt(situps.getText().toString()) == 32) {
                        situpspoints = 17;
                    } else if (Integer.parseInt(situps.getText().toString()) == 31) {
                        situpspoints = 16;
                    } else if (Integer.parseInt(situps.getText().toString()) == 30) {
                        situpspoints = 15;
                    } else if (Integer.parseInt(situps.getText().toString()) == 29 || Integer.parseInt(situps.getText().toString()) == 28) {
                        situpspoints = 14;
                    } else if (Integer.parseInt(situps.getText().toString()) == 27 || Integer.parseInt(situps.getText().toString()) == 26) {
                        situpspoints = 13;
                    } else if (Integer.parseInt(situps.getText().toString()) == 25) {
                        situpspoints = 12;
                    } else if (Integer.parseInt(situps.getText().toString()) == 24) {
                        situpspoints = 11;
                    } else if (Integer.parseInt(situps.getText().toString()) == 23) {
                        situpspoints = 10;
                    } else if (Integer.parseInt(situps.getText().toString()) == 22) {
                        situpspoints = 9;
                    } else if (Integer.parseInt(situps.getText().toString()) == 21) {
                        situpspoints = 8;
                    } else if (Integer.parseInt(situps.getText().toString()) == 20 || Integer.parseInt(situps.getText().toString()) == 19) {
                        situpspoints = 7;
                    } else if (Integer.parseInt(situps.getText().toString()) == 18 || Integer.parseInt(situps.getText().toString()) == 17) {
                        situpspoints = 6;
                    } else if (Integer.parseInt(situps.getText().toString()) == 16) {
                        situpspoints = 5;
                    } else if (Integer.parseInt(situps.getText().toString()) == 15) {
                        situpspoints = 4;
                    } else if (Integer.parseInt(situps.getText().toString()) == 14) {
                        situpspoints = 3;
                    } else if (Integer.parseInt(situps.getText().toString()) == 13) {
                        situpspoints = 2;
                    } else if (Integer.parseInt(situps.getText().toString()) == 12) {
                        situpspoints = 1;
                    } else {
                        situpspoints = 0;
                    }

                    //PUSH UP
                    if (Integer.parseInt(pushups.getText().toString()) >= 57) {
                        pushupspoints = 25;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 56 || Integer.parseInt(pushups.getText().toString()) == 55 || Integer.parseInt(pushups.getText().toString()) == 54) {
                        pushupspoints = 24;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 53 || Integer.parseInt(pushups.getText().toString()) == 52 || Integer.parseInt(pushups.getText().toString()) == 51 || Integer.parseInt(pushups.getText().toString()) == 50) {
                        pushupspoints = 23;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 49 || Integer.parseInt(pushups.getText().toString()) == 47 || Integer.parseInt(pushups.getText().toString()) == 46) {
                        pushupspoints = 22;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 45 || Integer.parseInt(pushups.getText().toString()) == 44 || Integer.parseInt(pushups.getText().toString()) == 43 || Integer.parseInt(pushups.getText().toString()) == 42) {
                        pushupspoints = 21;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 41 || Integer.parseInt(pushups.getText().toString()) == 40 || Integer.parseInt(pushups.getText().toString()) == 39 || Integer.parseInt(pushups.getText().toString()) == 38 || Integer.parseInt(pushups.getText().toString()) == 37) {
                        pushupspoints = 20;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 36 || Integer.parseInt(pushups.getText().toString()) == 35) {
                        pushupspoints = 19;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 34 || Integer.parseInt(pushups.getText().toString()) == 33 || Integer.parseInt(pushups.getText().toString()) == 32) {
                        pushupspoints = 18;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 31 || Integer.parseInt(pushups.getText().toString()) == 30 || Integer.parseInt(pushups.getText().toString()) == 29) {
                        pushupspoints = 17;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 28 || Integer.parseInt(pushups.getText().toString()) == 27 || Integer.parseInt(pushups.getText().toString()) == 26) {
                        pushupspoints = 16;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 25 || Integer.parseInt(pushups.getText().toString()) == 24 || Integer.parseInt(pushups.getText().toString()) == 23) {
                        pushupspoints = 15;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 22) {
                        pushupspoints = 14;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 21) {
                        pushupspoints = 13;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 20) {
                        pushupspoints = 12;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 19) {
                        pushupspoints = 11;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 18) {
                        pushupspoints = 10;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 17) {
                        pushupspoints = 9;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 16) {
                        pushupspoints = 8;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 15) {
                        pushupspoints = 6;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 14) {
                        pushupspoints = 4;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 13) {
                        pushupspoints = 2;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 12) {
                        pushupspoints = 1;
                    } else {
                        pushupspoints = 0;
                    }

                    //2.4km
                    if (Integer.parseInt(mins.getText().toString()) <= 8 && Integer.parseInt(secs.getText().toString()) <= 59) {
                        runningpoints = 50;
                    }else if (Integer.parseInt(mins.getText().toString()) == 9 && Integer.parseInt(secs.getText().toString()) == 0) {
                        runningpoints = 50;
                    } else if (Integer.parseInt(mins.getText().toString()) == 9 && Integer.parseInt(secs.getText().toString()) <= 10) {
                        runningpoints = 49;
                    } else if (Integer.parseInt(mins.getText().toString()) == 9 && Integer.parseInt(secs.getText().toString()) <= 20) {
                        runningpoints = 48;
                    } else if (Integer.parseInt(mins.getText().toString()) == 9 && Integer.parseInt(secs.getText().toString()) <= 30) {
                        runningpoints = 46;
                    } else if (Integer.parseInt(mins.getText().toString()) == 9 && Integer.parseInt(secs.getText().toString()) <= 40) {
                        runningpoints = 45;
                    } else if (Integer.parseInt(mins.getText().toString()) == 9 && Integer.parseInt(secs.getText().toString()) <= 50) {
                        runningpoints = 44;
                    } else if (Integer.parseInt(mins.getText().toString()) == 9 && Integer.parseInt(secs.getText().toString()) <= 59) {
                        runningpoints = 43;
                    } else if (Integer.parseInt(mins.getText().toString()) == 10 && Integer.parseInt(secs.getText().toString()) == 0) {
                        runningpoints = 43;
                    } else if (Integer.parseInt(mins.getText().toString()) == 10 && Integer.parseInt(secs.getText().toString()) <= 10) {
                        runningpoints = 42;
                    } else if (Integer.parseInt(mins.getText().toString()) == 10 && Integer.parseInt(secs.getText().toString()) <= 20) {
                        runningpoints = 41;
                    } else if (Integer.parseInt(mins.getText().toString()) == 10 && Integer.parseInt(secs.getText().toString()) <= 30) {
                        runningpoints = 40;
                    } else if (Integer.parseInt(mins.getText().toString()) == 10 && Integer.parseInt(secs.getText().toString()) <= 50) {
                        runningpoints = 39;
                    } else if (Integer.parseInt(mins.getText().toString()) == 10 && Integer.parseInt(secs.getText().toString()) <= 59) {
                        runningpoints = 38;
                    } else if (Integer.parseInt(mins.getText().toString()) == 11 && Integer.parseInt(secs.getText().toString()) <= 10) {
                        runningpoints = 38;
                    } else if (Integer.parseInt(mins.getText().toString()) == 11 && Integer.parseInt(secs.getText().toString()) <= 30) {
                        runningpoints = 37;
                    } else if (Integer.parseInt(mins.getText().toString()) == 11 && Integer.parseInt(secs.getText().toString()) <= 50) {
                        runningpoints = 36;
                    } else if (Integer.parseInt(mins.getText().toString()) == 11 && Integer.parseInt(secs.getText().toString()) <= 59) {
                        runningpoints = 35;
                    } else if (Integer.parseInt(mins.getText().toString()) == 12 && Integer.parseInt(secs.getText().toString()) <= 10) {
                        runningpoints = 35;
                    } else if (Integer.parseInt(mins.getText().toString()) == 12 && Integer.parseInt(secs.getText().toString()) <= 20) {
                        runningpoints = 34;
                    } else if (Integer.parseInt(mins.getText().toString()) == 12 && Integer.parseInt(secs.getText().toString()) <= 30) {
                        runningpoints = 33;
                    } else if (Integer.parseInt(mins.getText().toString()) == 12 && Integer.parseInt(secs.getText().toString()) <= 40) {
                        runningpoints = 32;
                    } else if (Integer.parseInt(mins.getText().toString()) == 12 && Integer.parseInt(secs.getText().toString()) <= 50) {
                        runningpoints = 31;
                    } else if (Integer.parseInt(mins.getText().toString()) == 12 && Integer.parseInt(secs.getText().toString()) <= 59) {
                        runningpoints = 30;
                    } else if (Integer.parseInt(mins.getText().toString()) == 13 && Integer.parseInt(secs.getText().toString()) == 0) {
                        runningpoints = 30;
                    } else if (Integer.parseInt(mins.getText().toString()) == 13 && Integer.parseInt(secs.getText().toString()) <= 10 ) {
                        runningpoints = 29;
                    } else if (Integer.parseInt(mins.getText().toString()) == 13 && Integer.parseInt(secs.getText().toString()) <= 20) {
                        runningpoints = 28;
                    } else if (Integer.parseInt(mins.getText().toString()) == 13 && Integer.parseInt(secs.getText().toString()) <= 30) {
                        runningpoints = 27;
                    } else if (Integer.parseInt(mins.getText().toString()) == 13 && Integer.parseInt(secs.getText().toString()) <= 40) {
                        runningpoints = 26;
                    } else if (Integer.parseInt(mins.getText().toString()) == 13 && Integer.parseInt(secs.getText().toString()) <= 50) {
                        runningpoints = 25;
                    } else if (Integer.parseInt(mins.getText().toString()) == 13 && Integer.parseInt(secs.getText().toString()) <= 59) {
                        runningpoints = 24;
                    } else if (Integer.parseInt(mins.getText().toString()) == 14 && Integer.parseInt(secs.getText().toString()) == 0) {
                        runningpoints = 24;
                    } else if (Integer.parseInt(mins.getText().toString()) == 14 && Integer.parseInt(secs.getText().toString()) <=10) {
                        runningpoints = 23;
                    } else if (Integer.parseInt(mins.getText().toString()) == 14 && Integer.parseInt(secs.getText().toString()) <= 20) {
                        runningpoints = 22;
                    } else if (Integer.parseInt(mins.getText().toString()) == 14 && Integer.parseInt(secs.getText().toString()) <= 30) {
                        runningpoints = 21;
                    } else if (Integer.parseInt(mins.getText().toString()) == 14 && Integer.parseInt(secs.getText().toString()) <= 40) {
                        runningpoints = 20;
                    } else if (Integer.parseInt(mins.getText().toString()) == 14 && Integer.parseInt(secs.getText().toString()) <= 50) {
                        runningpoints = 19;
                    } else if (Integer.parseInt(mins.getText().toString()) == 14 && Integer.parseInt(secs.getText().toString()) <= 59) {
                        runningpoints = 18;
                    } else if (Integer.parseInt(mins.getText().toString()) == 15 && Integer.parseInt(secs.getText().toString()) == 0) {
                        runningpoints = 18;
                    } else if (Integer.parseInt(mins.getText().toString()) == 15 && Integer.parseInt(secs.getText().toString()) <= 10) {
                        runningpoints = 16;
                    } else if (Integer.parseInt(mins.getText().toString()) == 15 && Integer.parseInt(secs.getText().toString()) <= 20) {
                        runningpoints = 14;
                    } else if (Integer.parseInt(mins.getText().toString()) == 15 && Integer.parseInt(secs.getText().toString()) <= 30) {
                        runningpoints = 12;
                    } else if (Integer.parseInt(mins.getText().toString()) == 15 && Integer.parseInt(secs.getText().toString()) <= 40) {
                        runningpoints = 10;
                    } else if (Integer.parseInt(mins.getText().toString()) == 15 && Integer.parseInt(secs.getText().toString()) <= 50) {
                        runningpoints = 8;
                    } else if (Integer.parseInt(mins.getText().toString()) == 15 && Integer.parseInt(secs.getText().toString()) <= 59) {
                        runningpoints = 6;
                    } else if (Integer.parseInt(mins.getText().toString()) == 16 && Integer.parseInt(secs.getText().toString()) == 0) {
                        runningpoints = 6;
                    } else if (Integer.parseInt(mins.getText().toString()) == 16 && Integer.parseInt(secs.getText().toString()) <= 10) {
                        runningpoints = 4;
                    } else if (Integer.parseInt(mins.getText().toString()) == 16 && Integer.parseInt(secs.getText().toString()) <= 20) {
                        runningpoints = 2;
                    } else if (Integer.parseInt(mins.getText().toString()) == 16 && Integer.parseInt(secs.getText().toString()) <= 30) {
                        runningpoints = 1;
                    } else {
                        runningpoints = 0;
                    }

                    total = situpspoints + pushupspoints + runningpoints;

                    if (total <= 49) {
                        award.setText("Failed");
                    } else if (total <= 59) {
                        award.setText("Pass");
                    } else if (total <= 69) {
                        award.setText("Pass with incentive");
                    } else if (total <= 79) {
                        award.setText("Silver");
                    } else {
                        award.setText("Gold");
                    }

                    points.setText(Integer.toString(total));
                }
                catch (Exception e) {
                    Toast.makeText(Student_ippt.this, "Please enter valid entries", Toast.LENGTH_SHORT).show();
                }

            }});
    }

    public void ageGroupFemale1(){
        Button total = findViewById(R.id.btn_Student_Calculate);

        total.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int situpspoints = 0;
                    int pushupspoints = 0;
                    int runningpoints = 0;
                    int total = 0;

                    //SITUP
                    if (Integer.parseInt(situps.getText().toString()) >= 52) {
                        situpspoints = 25;
                    } else if (Integer.parseInt(situps.getText().toString()) == 51 || Integer.parseInt(situps.getText().toString()) == 50) {
                        situpspoints = 24;
                    } else if (Integer.parseInt(situps.getText().toString()) == 49 || Integer.parseInt(situps.getText().toString()) == 48 || Integer.parseInt(situps.getText().toString()) == 47) {
                        situpspoints = 23;
                    } else if (Integer.parseInt(situps.getText().toString()) == 46 || Integer.parseInt(situps.getText().toString()) == 45 || Integer.parseInt(situps.getText().toString()) == 44) {
                        situpspoints = 22;
                    } else if (Integer.parseInt(situps.getText().toString()) == 43 || Integer.parseInt(situps.getText().toString()) == 42 || Integer.parseInt(situps.getText().toString()) == 41 || Integer.parseInt(situps.getText().toString()) == 40) {
                        situpspoints = 21;
                    } else if (Integer.parseInt(situps.getText().toString()) == 39 || Integer.parseInt(situps.getText().toString()) == 38 || Integer.parseInt(situps.getText().toString()) == 37 || Integer.parseInt(situps.getText().toString()) == 36 || Integer.parseInt(situps.getText().toString()) == 35) {
                        situpspoints = 20;
                    } else if (Integer.parseInt(situps.getText().toString()) == 34 || Integer.parseInt(situps.getText().toString()) == 33) {
                        situpspoints = 19;
                    } else if (Integer.parseInt(situps.getText().toString()) == 32 || Integer.parseInt(situps.getText().toString()) == 31 || Integer.parseInt(situps.getText().toString()) == 30) {
                        situpspoints = 18;
                    } else if (Integer.parseInt(situps.getText().toString()) == 29) {
                        situpspoints = 17;
                    } else if (Integer.parseInt(situps.getText().toString()) == 28|| Integer.parseInt(situps.getText().toString()) == 27) {
                        situpspoints = 16;
                    } else if (Integer.parseInt(situps.getText().toString()) == 26 || Integer.parseInt(situps.getText().toString()) == 25) {
                        situpspoints = 15;
                    } else if (Integer.parseInt(situps.getText().toString()) == 24) {
                        situpspoints = 14;
                    } else if (Integer.parseInt(situps.getText().toString()) == 23) {
                        situpspoints = 13;
                    } else if (Integer.parseInt(situps.getText().toString()) == 22) {
                        situpspoints = 12;
                    } else if (Integer.parseInt(situps.getText().toString()) == 21) {
                        situpspoints = 11;
                    } else if (Integer.parseInt(situps.getText().toString()) == 20) {
                        situpspoints = 10;
                    } else if (Integer.parseInt(situps.getText().toString()) == 19) {
                        situpspoints = 8;
                    } else if (Integer.parseInt(situps.getText().toString()) == 18) {
                        situpspoints = 6;
                    } else if (Integer.parseInt(situps.getText().toString()) == 17) {
                        situpspoints = 4;
                    } else if (Integer.parseInt(situps.getText().toString()) == 16) {
                        situpspoints = 2;
                    } else if (Integer.parseInt(situps.getText().toString()) == 15) {
                        situpspoints = 1;
                    } else {
                        situpspoints = 0;
                    }

                    //PUSHUP
                    if (Integer.parseInt(pushups.getText().toString()) >= 50) {
                        pushupspoints = 25;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 49 || Integer.parseInt(pushups.getText().toString()) == 48 || Integer.parseInt(pushups.getText().toString()) == 47 || Integer.parseInt(pushups.getText().toString()) == 46) {
                        pushupspoints = 24;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 45 || Integer.parseInt(pushups.getText().toString()) == 44 || Integer.parseInt(pushups.getText().toString()) == 43 || Integer.parseInt(pushups.getText().toString()) == 42) {
                        pushupspoints = 23;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 41 || Integer.parseInt(pushups.getText().toString()) == 40 || Integer.parseInt(pushups.getText().toString()) == 39 || Integer.parseInt(pushups.getText().toString()) == 38 || Integer.parseInt(pushups.getText().toString()) == 37) {
                        pushupspoints = 22;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 36 || Integer.parseInt(pushups.getText().toString()) == 35 || Integer.parseInt(pushups.getText().toString()) == 34 || Integer.parseInt(pushups.getText().toString()) == 33 || Integer.parseInt(pushups.getText().toString()) == 32) {
                        pushupspoints = 21;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 31 || Integer.parseInt(pushups.getText().toString()) == 30 || Integer.parseInt(pushups.getText().toString()) == 29 || Integer.parseInt(pushups.getText().toString()) == 28) {
                        pushupspoints = 20;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 27 || Integer.parseInt(pushups.getText().toString()) == 26 || Integer.parseInt(pushups.getText().toString()) == 25) {
                        pushupspoints = 19;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 24 || Integer.parseInt(pushups.getText().toString()) == 23 || Integer.parseInt(pushups.getText().toString()) == 22) {
                        pushupspoints = 18;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 21) {
                        pushupspoints = 17;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 20) {
                        pushupspoints = 16;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 19 || Integer.parseInt(pushups.getText().toString()) == 18) {
                        pushupspoints = 15;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 17) {
                        pushupspoints = 10;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 16) {
                        pushupspoints = 5;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 15) {
                        pushupspoints = 1;
                    } else {
                        pushupspoints = 0;
                    }

                    //2.4km
                    if (Integer.parseInt(mins.getText().toString()) <= 10 && Integer.parseInt(secs.getText().toString()) == 0) {
                        runningpoints = 50;
                    } else if (Integer.parseInt(mins.getText().toString()) == 9 && Integer.parseInt(secs.getText().toString()) <= 59) {
                        runningpoints = 50;
                    } else if (Integer.parseInt(mins.getText().toString()) == 10 && Integer.parseInt(secs.getText().toString()) <= 10) {
                        runningpoints = 49;
                    } else if (Integer.parseInt(mins.getText().toString()) == 10 && Integer.parseInt(secs.getText().toString()) <= 20) {
                        runningpoints = 48;
                    } else if (Integer.parseInt(mins.getText().toString()) == 10 && Integer.parseInt(secs.getText().toString()) <= 40) {
                        runningpoints = 47;
                    } else if (Integer.parseInt(mins.getText().toString()) == 10 && Integer.parseInt(secs.getText().toString()) <= 59) {
                        runningpoints = 46;
                    } else if (Integer.parseInt(mins.getText().toString()) == 11 && Integer.parseInt(secs.getText().toString()) == 0) {
                        runningpoints = 46;
                    } else if (Integer.parseInt(mins.getText().toString()) == 11 && Integer.parseInt(secs.getText().toString()) <= 20) {
                        runningpoints = 45;
                    } else if (Integer.parseInt(mins.getText().toString()) == 11 && Integer.parseInt(secs.getText().toString()) <= 40) {
                        runningpoints = 44;
                    } else if (Integer.parseInt(mins.getText().toString()) == 11 && Integer.parseInt(secs.getText().toString()) <= 59) {
                        runningpoints = 43;
                    } else if (Integer.parseInt(mins.getText().toString()) == 12 && Integer.parseInt(secs.getText().toString()) == 0) {
                        runningpoints = 43;
                    } else if (Integer.parseInt(mins.getText().toString()) == 12 && Integer.parseInt(secs.getText().toString()) <= 20) {
                        runningpoints = 42;
                    } else if (Integer.parseInt(mins.getText().toString()) == 12 && Integer.parseInt(secs.getText().toString()) <= 40) {
                        runningpoints = 41;
                    } else if (Integer.parseInt(mins.getText().toString()) == 12 && Integer.parseInt(secs.getText().toString()) <= 59) {
                        runningpoints = 39;
                    } else if (Integer.parseInt(mins.getText().toString()) == 13 && Integer.parseInt(secs.getText().toString()) == 0) {
                        runningpoints = 39;
                    } else if (Integer.parseInt(mins.getText().toString()) == 13 && Integer.parseInt(secs.getText().toString()) <= 30) {
                        runningpoints = 38;
                    } else if (Integer.parseInt(mins.getText().toString()) == 13 && Integer.parseInt(secs.getText().toString()) <= 59) {
                        runningpoints = 37;
                    } else if (Integer.parseInt(mins.getText().toString()) == 14 && Integer.parseInt(secs.getText().toString()) == 0) {
                        runningpoints = 37;
                    } else if (Integer.parseInt(mins.getText().toString()) == 14 && Integer.parseInt(secs.getText().toString()) <= 30) {
                        runningpoints = 36;
                    } else if (Integer.parseInt(mins.getText().toString()) == 14 && Integer.parseInt(secs.getText().toString()) <= 59) {
                        runningpoints = 35;
                    } else if (Integer.parseInt(mins.getText().toString()) == 15 && Integer.parseInt(secs.getText().toString()) == 0) {
                        runningpoints = 35;
                    } else if (Integer.parseInt(mins.getText().toString()) == 15 && Integer.parseInt(secs.getText().toString()) <= 20) {
                        runningpoints = 34;
                    } else if (Integer.parseInt(mins.getText().toString()) == 15 && Integer.parseInt(secs.getText().toString()) <= 40) {
                        runningpoints = 33;
                    } else if (Integer.parseInt(mins.getText().toString()) == 15 && Integer.parseInt(secs.getText().toString()) <= 59) {
                        runningpoints = 32;
                    } else if (Integer.parseInt(mins.getText().toString()) == 16 && Integer.parseInt(secs.getText().toString()) == 0) {
                        runningpoints = 32;
                    } else if (Integer.parseInt(mins.getText().toString()) == 16 && Integer.parseInt(secs.getText().toString()) <= 20) {
                        runningpoints = 31;
                    } else if (Integer.parseInt(mins.getText().toString()) == 16 && Integer.parseInt(secs.getText().toString()) <= 40) {
                        runningpoints = 30;
                    } else if (Integer.parseInt(mins.getText().toString()) == 16 && Integer.parseInt(secs.getText().toString()) <= 50) {
                        runningpoints = 29;
                    } else if (Integer.parseInt(mins.getText().toString()) == 16 && Integer.parseInt(secs.getText().toString()) <= 59) {
                        runningpoints = 28;
                    } else if (Integer.parseInt(mins.getText().toString()) == 17 && Integer.parseInt(secs.getText().toString()) == 0) {
                        runningpoints = 28;
                    } else if (Integer.parseInt(mins.getText().toString()) == 17 && Integer.parseInt(secs.getText().toString()) <= 10) {
                        runningpoints = 27;
                    } else if (Integer.parseInt(mins.getText().toString()) == 17 && Integer.parseInt(secs.getText().toString()) <= 20) {
                        runningpoints = 26;
                    } else if (Integer.parseInt(mins.getText().toString()) == 17 && Integer.parseInt(secs.getText().toString()) <= 30) {
                        runningpoints = 25;
                    } else if (Integer.parseInt(mins.getText().toString()) == 17 && Integer.parseInt(secs.getText().toString()) <= 40) {
                        runningpoints = 24;
                    } else if (Integer.parseInt(mins.getText().toString()) == 17 && Integer.parseInt(secs.getText().toString()) <= 50) {
                        runningpoints = 23;
                    } else if (Integer.parseInt(mins.getText().toString()) == 17 && Integer.parseInt(secs.getText().toString()) <= 59) {
                        runningpoints = 22;
                    } else if (Integer.parseInt(mins.getText().toString()) == 18 && Integer.parseInt(secs.getText().toString()) == 0) {
                        runningpoints = 22;
                    } else if (Integer.parseInt(mins.getText().toString()) == 18 && Integer.parseInt(secs.getText().toString()) <= 10) {
                        runningpoints = 21;
                    } else if (Integer.parseInt(mins.getText().toString()) == 18 && Integer.parseInt(secs.getText().toString()) <= 20) {
                        runningpoints = 20;
                    } else if (Integer.parseInt(mins.getText().toString()) == 18 && Integer.parseInt(secs.getText().toString()) <= 30) {
                        runningpoints = 18;
                    } else if (Integer.parseInt(mins.getText().toString()) == 18 && Integer.parseInt(secs.getText().toString()) <= 40) {
                        runningpoints = 16;
                    } else if (Integer.parseInt(mins.getText().toString()) == 18 && Integer.parseInt(secs.getText().toString()) <= 50) {
                        runningpoints = 14;
                    } else if (Integer.parseInt(mins.getText().toString()) == 18 && Integer.parseInt(secs.getText().toString()) <= 59) {
                        runningpoints = 12;
                    } else if (Integer.parseInt(mins.getText().toString()) == 19 && Integer.parseInt(secs.getText().toString()) == 0) {
                        runningpoints = 12;
                    } else if (Integer.parseInt(mins.getText().toString()) == 19 && Integer.parseInt(secs.getText().toString()) <= 10) {
                        runningpoints = 10;
                    } else if (Integer.parseInt(mins.getText().toString()) == 19 && Integer.parseInt(secs.getText().toString()) <= 20) {
                        runningpoints = 8;
                    } else if (Integer.parseInt(mins.getText().toString()) == 19 && Integer.parseInt(secs.getText().toString()) <= 30) {
                        runningpoints = 6;
                    } else if (Integer.parseInt(mins.getText().toString()) == 19 && Integer.parseInt(secs.getText().toString()) <= 40) {
                        runningpoints = 4;
                    } else if (Integer.parseInt(mins.getText().toString()) == 19 && Integer.parseInt(secs.getText().toString()) <= 50) {
                        runningpoints = 2;
                    } else if (Integer.parseInt(mins.getText().toString()) == 19 && Integer.parseInt(secs.getText().toString()) <= 59) {
                        runningpoints = 1;
                    } else if (Integer.parseInt(mins.getText().toString()) == 20 && Integer.parseInt(secs.getText().toString()) == 0) {
                        runningpoints = 1;
                    } else {
                        runningpoints = 0;
                    }

                    total = situpspoints + pushupspoints + runningpoints;

                    if (total <= 49) {
                        award.setText("Failed");
                    } else if (total <= 59) {
                        award.setText("Pass");
                    } else if (total <= 69) {
                        award.setText("Pass with incentive");
                    } else if (total <= 79) {
                        award.setText("Silver");
                    } else {
                        award.setText("Gold");
                    }

                    points.setText(Integer.toString(total));
                }
                catch (Exception e)
                {
                    Toast.makeText(Student_ippt.this, "Please enter valid entries", Toast.LENGTH_SHORT).show();
                }

            }});
    }

    public void ageGroupFemale2(){
        Button total = findViewById(R.id.btn_Student_Calculate);

        total.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int situpspoints = 0;
                    int pushupspoints = 0;
                    int runningpoints = 0;
                    int total = 0;

                    //SITUP
                    if (Integer.parseInt(situps.getText().toString()) >= 50) {
                        situpspoints = 25;
                    } else if (Integer.parseInt(situps.getText().toString()) == 49 || Integer.parseInt(situps.getText().toString()) == 48 || Integer.parseInt(situps.getText().toString()) == 47) {
                        situpspoints = 24;
                    } else if (Integer.parseInt(situps.getText().toString()) == 46 || Integer.parseInt(situps.getText().toString()) == 45 || Integer.parseInt(situps.getText().toString()) == 44 ) {
                        situpspoints = 23;
                    } else if (Integer.parseInt(situps.getText().toString()) == 43 || Integer.parseInt(situps.getText().toString()) == 42 || Integer.parseInt(situps.getText().toString()) == 41) {
                        situpspoints = 22;
                    } else if (Integer.parseInt(situps.getText().toString()) == 40 || Integer.parseInt(situps.getText().toString()) == 39 || Integer.parseInt(situps.getText().toString()) == 38 ) {
                        situpspoints = 21;
                    } else if (Integer.parseInt(situps.getText().toString()) == 37 || Integer.parseInt(situps.getText().toString()) == 36 || Integer.parseInt(situps.getText().toString()) == 35 || Integer.parseInt(situps.getText().toString()) == 34 ) {
                        situpspoints = 20;
                    } else if (Integer.parseInt(situps.getText().toString()) == 33 || Integer.parseInt(situps.getText().toString()) == 32) {
                        situpspoints = 19;
                    } else if (Integer.parseInt(situps.getText().toString()) == 31 || Integer.parseInt(situps.getText().toString()) == 30 || Integer.parseInt(situps.getText().toString()) == 29) {
                        situpspoints = 18;
                    } else if (Integer.parseInt(situps.getText().toString()) == 28) {
                        situpspoints = 17;
                    } else if (Integer.parseInt(situps.getText().toString()) == 27|| Integer.parseInt(situps.getText().toString()) == 26) {
                        situpspoints = 16;
                    } else if (Integer.parseInt(situps.getText().toString()) == 25 || Integer.parseInt(situps.getText().toString()) == 24) {
                        situpspoints = 15;
                    } else if (Integer.parseInt(situps.getText().toString()) == 23) {
                        situpspoints = 14;
                    } else if (Integer.parseInt(situps.getText().toString()) == 22) {
                        situpspoints = 13;
                    } else if (Integer.parseInt(situps.getText().toString()) == 21) {
                        situpspoints = 12;
                    } else if (Integer.parseInt(situps.getText().toString()) == 20) {
                        situpspoints = 11;
                    } else if (Integer.parseInt(situps.getText().toString()) == 19) {
                        situpspoints = 10;
                    } else if (Integer.parseInt(situps.getText().toString()) == 18) {
                        situpspoints = 8;
                    } else if (Integer.parseInt(situps.getText().toString()) == 17) {
                        situpspoints = 6;
                    } else if (Integer.parseInt(situps.getText().toString()) == 16) {
                        situpspoints = 4;
                    } else if (Integer.parseInt(situps.getText().toString()) == 15) {
                        situpspoints = 2;
                    } else if (Integer.parseInt(situps.getText().toString()) == 14) {
                        situpspoints = 1;
                    } else {
                        situpspoints = 0;
                    }

                    //PUSHUP
                    if (Integer.parseInt(pushups.getText().toString()) >= 48) {
                        pushupspoints = 25;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 47 || Integer.parseInt(pushups.getText().toString()) == 46 || Integer.parseInt(pushups.getText().toString()) == 45 || Integer.parseInt(pushups.getText().toString()) == 44) {
                        pushupspoints = 24;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 43 || Integer.parseInt(pushups.getText().toString()) == 42 || Integer.parseInt(pushups.getText().toString()) == 41 || Integer.parseInt(pushups.getText().toString()) == 40 || Integer.parseInt(pushups.getText().toString()) == 39)  {
                        pushupspoints = 23;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 38 || Integer.parseInt(pushups.getText().toString()) == 37 || Integer.parseInt(pushups.getText().toString()) == 36 || Integer.parseInt(pushups.getText().toString()) == 35 || Integer.parseInt(pushups.getText().toString()) == 34) {
                        pushupspoints = 22;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 33 || Integer.parseInt(pushups.getText().toString()) == 32 || Integer.parseInt(pushups.getText().toString()) == 31 ) {
                        pushupspoints = 21;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 30 || Integer.parseInt(pushups.getText().toString()) == 29 || Integer.parseInt(pushups.getText().toString()) == 28 || Integer.parseInt(pushups.getText().toString()) == 27) {
                        pushupspoints = 20;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 26 || Integer.parseInt(pushups.getText().toString()) == 25 || Integer.parseInt(pushups.getText().toString()) == 24) {
                        pushupspoints = 19;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 23 || Integer.parseInt(pushups.getText().toString()) == 22 || Integer.parseInt(pushups.getText().toString()) == 21) {
                        pushupspoints = 18;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 20) {
                        pushupspoints = 17;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 19) {
                        pushupspoints = 16;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 18 || Integer.parseInt(pushups.getText().toString()) == 17) {
                        pushupspoints = 15;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 16) {
                        pushupspoints = 10;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 15) {
                        pushupspoints = 5;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 14) {
                        pushupspoints = 1;
                    } else {
                        pushupspoints = 0;
                    }

                    //2.4km
                    if (Integer.parseInt(mins.getText().toString()) <= 10 && Integer.parseInt(secs.getText().toString()) <= 20) {
                        runningpoints = 50;
                    } else if (Integer.parseInt(mins.getText().toString()) == 10 && Integer.parseInt(secs.getText().toString()) <= 30) {
                        runningpoints = 49;
                    } else if (Integer.parseInt(mins.getText().toString()) == 10 && Integer.parseInt(secs.getText().toString()) <= 40) {
                        runningpoints = 48;
                    } else if (Integer.parseInt(mins.getText().toString()) == 10 && Integer.parseInt(secs.getText().toString()) <= 50) {
                        runningpoints = 47;
                    } else if (Integer.parseInt(mins.getText().toString()) == 10 && Integer.parseInt(secs.getText().toString()) <= 59) {
                        runningpoints = 46;
                    } else if (Integer.parseInt(mins.getText().toString()) == 11 && Integer.parseInt(secs.getText().toString()) <= 10) {
                        runningpoints = 46;
                    } else if (Integer.parseInt(mins.getText().toString()) == 11 && Integer.parseInt(secs.getText().toString()) <= 30) {
                        runningpoints = 45;
                    } else if (Integer.parseInt(mins.getText().toString()) == 11 && Integer.parseInt(secs.getText().toString()) <= 50) {
                        runningpoints = 44;
                    } else if (Integer.parseInt(mins.getText().toString()) == 11 && Integer.parseInt(secs.getText().toString()) <= 59) {
                        runningpoints = 43;
                    } else if (Integer.parseInt(mins.getText().toString()) == 12 && Integer.parseInt(secs.getText().toString()) <= 10) {
                        runningpoints = 43;
                    } else if (Integer.parseInt(mins.getText().toString()) == 12 && Integer.parseInt(secs.getText().toString()) <= 30) {
                        runningpoints = 42;
                    } else if (Integer.parseInt(mins.getText().toString()) == 12 && Integer.parseInt(secs.getText().toString()) <= 50) {
                        runningpoints = 41;
                    } else if (Integer.parseInt(mins.getText().toString()) == 12 && Integer.parseInt(secs.getText().toString()) <= 59) {
                        runningpoints = 39;
                    } else if (Integer.parseInt(mins.getText().toString()) == 13 && Integer.parseInt(secs.getText().toString()) <= 10) {
                        runningpoints = 39;
                    } else if (Integer.parseInt(mins.getText().toString()) == 13 && Integer.parseInt(secs.getText().toString()) <= 40) {
                        runningpoints = 38;
                    } else if (Integer.parseInt(mins.getText().toString()) == 13 && Integer.parseInt(secs.getText().toString()) <= 59) {
                        runningpoints = 37;
                    } else if (Integer.parseInt(mins.getText().toString()) == 14 && Integer.parseInt(secs.getText().toString()) <= 10) {
                        runningpoints = 37;
                    } else if (Integer.parseInt(mins.getText().toString()) == 14 && Integer.parseInt(secs.getText().toString()) <= 40) {
                        runningpoints = 36;
                    } else if (Integer.parseInt(mins.getText().toString()) == 14 && Integer.parseInt(secs.getText().toString()) <= 59) {
                        runningpoints = 35;
                    } else if (Integer.parseInt(mins.getText().toString()) == 15 && Integer.parseInt(secs.getText().toString()) == 10) {
                        runningpoints = 35;
                    } else if (Integer.parseInt(mins.getText().toString()) == 15 && Integer.parseInt(secs.getText().toString()) <= 30) {
                        runningpoints = 34;
                    } else if (Integer.parseInt(mins.getText().toString()) == 15 && Integer.parseInt(secs.getText().toString()) <= 50) {
                        runningpoints = 33;
                    } else if (Integer.parseInt(mins.getText().toString()) == 15 && Integer.parseInt(secs.getText().toString()) <= 59) {
                        runningpoints = 32;
                    } else if (Integer.parseInt(mins.getText().toString()) == 16 && Integer.parseInt(secs.getText().toString()) <= 10) {
                        runningpoints = 32;
                    } else if (Integer.parseInt(mins.getText().toString()) == 16 && Integer.parseInt(secs.getText().toString()) <= 30) {
                        runningpoints = 31;
                    } else if (Integer.parseInt(mins.getText().toString()) == 16 && Integer.parseInt(secs.getText().toString()) <= 50) {
                        runningpoints = 30;
                    } else if (Integer.parseInt(mins.getText().toString()) == 16 && Integer.parseInt(secs.getText().toString()) <= 59) {
                        runningpoints = 29;
                    } else if (Integer.parseInt(mins.getText().toString()) == 17 && Integer.parseInt(secs.getText().toString()) == 0) {
                        runningpoints = 29;
                    } else if (Integer.parseInt(mins.getText().toString()) == 17 && Integer.parseInt(secs.getText().toString()) <= 10) {
                        runningpoints = 28;
                    } else if (Integer.parseInt(mins.getText().toString()) == 17 && Integer.parseInt(secs.getText().toString()) <= 20) {
                        runningpoints = 27;
                    } else if (Integer.parseInt(mins.getText().toString()) == 17 && Integer.parseInt(secs.getText().toString()) <= 30) {
                        runningpoints = 26;
                    } else if (Integer.parseInt(mins.getText().toString()) == 17 && Integer.parseInt(secs.getText().toString()) <= 40) {
                        runningpoints = 25;
                    } else if (Integer.parseInt(mins.getText().toString()) == 17 && Integer.parseInt(secs.getText().toString()) <= 50) {
                        runningpoints = 24;
                    } else if (Integer.parseInt(mins.getText().toString()) == 17 && Integer.parseInt(secs.getText().toString()) <= 59) {
                        runningpoints = 23;
                    } else if (Integer.parseInt(mins.getText().toString()) == 18 && Integer.parseInt(secs.getText().toString()) == 0) {
                        runningpoints = 23;
                    } else if (Integer.parseInt(mins.getText().toString()) == 18 && Integer.parseInt(secs.getText().toString()) <= 10) {
                        runningpoints = 22;
                    } else if (Integer.parseInt(mins.getText().toString()) == 18 && Integer.parseInt(secs.getText().toString()) <= 20) {
                        runningpoints = 21;
                    } else if (Integer.parseInt(mins.getText().toString()) == 18 && Integer.parseInt(secs.getText().toString()) <= 30) {
                        runningpoints = 20;
                    } else if (Integer.parseInt(mins.getText().toString()) == 18 && Integer.parseInt(secs.getText().toString()) <= 40) {
                        runningpoints = 18;
                    } else if (Integer.parseInt(mins.getText().toString()) == 18 && Integer.parseInt(secs.getText().toString()) <= 50) {
                        runningpoints = 16;
                    } else if (Integer.parseInt(mins.getText().toString()) == 18 && Integer.parseInt(secs.getText().toString()) <= 59) {
                        runningpoints = 14;
                    } else if (Integer.parseInt(mins.getText().toString()) == 19 && Integer.parseInt(secs.getText().toString()) == 0) {
                        runningpoints = 14;
                    } else if (Integer.parseInt(mins.getText().toString()) == 19 && Integer.parseInt(secs.getText().toString()) <= 10) {
                        runningpoints = 12;
                    } else if (Integer.parseInt(mins.getText().toString()) == 19 && Integer.parseInt(secs.getText().toString()) <= 20) {
                        runningpoints = 10;
                    } else if (Integer.parseInt(mins.getText().toString()) == 19 && Integer.parseInt(secs.getText().toString()) <= 30) {
                        runningpoints = 8;
                    } else if (Integer.parseInt(mins.getText().toString()) == 19 && Integer.parseInt(secs.getText().toString()) <= 40) {
                        runningpoints = 6;
                    } else if (Integer.parseInt(mins.getText().toString()) == 19 && Integer.parseInt(secs.getText().toString()) <= 50) {
                        runningpoints = 4;
                    } else if (Integer.parseInt(mins.getText().toString()) == 19 && Integer.parseInt(secs.getText().toString()) <= 59) {
                        runningpoints = 2;
                    } else if (Integer.parseInt(mins.getText().toString()) == 20 && Integer.parseInt(secs.getText().toString()) == 0) {
                        runningpoints = 2;
                    } else if (Integer.parseInt(mins.getText().toString()) == 20 && Integer.parseInt(secs.getText().toString()) <= 10) {
                        runningpoints = 1;
                    } else {
                        runningpoints = 0;
                    }

                    total = situpspoints + pushupspoints + runningpoints;

                    if (total <= 49) {
                        award.setText("Failed");
                    } else if (total <= 59) {
                        award.setText("Pass");
                    } else if (total <= 69) {
                        award.setText("Pass with incentive");
                    } else if (total <= 79) {
                        award.setText("Silver");
                    } else {
                        award.setText("Gold");
                    }

                    points.setText(Integer.toString(total));
                }
                catch (Exception e)
                {
                    Toast.makeText(Student_ippt.this, "Please enter valid entries", Toast.LENGTH_SHORT).show();
                }

            }});
    }

    public void ageGroupFemale3(){
        Button total = findViewById(R.id.btn_Student_Calculate);

        total.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int situpspoints = 0;
                    int pushupspoints = 0;
                    int runningpoints = 0;
                    int total = 0;

                    //SITUP
                    if (Integer.parseInt(situps.getText().toString()) >= 48) {
                        situpspoints = 25;
                    } else if (Integer.parseInt(situps.getText().toString()) == 47 || Integer.parseInt(situps.getText().toString()) == 46 || Integer.parseInt(situps.getText().toString()) == 45) {
                        situpspoints = 24;
                    } else if (Integer.parseInt(situps.getText().toString()) == 44 || Integer.parseInt(situps.getText().toString()) == 43 || Integer.parseInt(situps.getText().toString()) == 42 ) {
                        situpspoints = 23;
                    } else if (Integer.parseInt(situps.getText().toString()) == 41 || Integer.parseInt(situps.getText().toString()) == 40 || Integer.parseInt(situps.getText().toString()) == 39) {
                        situpspoints = 22;
                    } else if (Integer.parseInt(situps.getText().toString()) == 38 || Integer.parseInt(situps.getText().toString()) == 37 || Integer.parseInt(situps.getText().toString()) == 36 ) {
                        situpspoints = 21;
                    } else if (Integer.parseInt(situps.getText().toString()) == 35 || Integer.parseInt(situps.getText().toString()) == 34 || Integer.parseInt(situps.getText().toString()) == 33 ) {
                        situpspoints = 20;
                    } else if (Integer.parseInt(situps.getText().toString()) == 32 || Integer.parseInt(situps.getText().toString()) == 31) {
                        situpspoints = 19;
                    } else if (Integer.parseInt(situps.getText().toString()) == 30 || Integer.parseInt(situps.getText().toString()) == 29 || Integer.parseInt(situps.getText().toString()) == 28) {
                        situpspoints = 18;
                    } else if (Integer.parseInt(situps.getText().toString()) == 27) {
                        situpspoints = 17;
                    } else if (Integer.parseInt(situps.getText().toString()) == 26|| Integer.parseInt(situps.getText().toString()) == 25) {
                        situpspoints = 16;
                    } else if (Integer.parseInt(situps.getText().toString()) == 24 || Integer.parseInt(situps.getText().toString()) == 23) {
                        situpspoints = 15;
                    } else if (Integer.parseInt(situps.getText().toString()) == 22) {
                        situpspoints = 14;
                    } else if (Integer.parseInt(situps.getText().toString()) == 21) {
                        situpspoints = 13;
                    } else if (Integer.parseInt(situps.getText().toString()) == 20) {
                        situpspoints = 12;
                    } else if (Integer.parseInt(situps.getText().toString()) == 19) {
                        situpspoints = 11;
                    } else if (Integer.parseInt(situps.getText().toString()) == 18) {
                        situpspoints = 10;
                    } else if (Integer.parseInt(situps.getText().toString()) == 17) {
                        situpspoints = 8;
                    } else if (Integer.parseInt(situps.getText().toString()) == 16) {
                        situpspoints = 6;
                    } else if (Integer.parseInt(situps.getText().toString()) == 15) {
                        situpspoints = 4;
                    } else if (Integer.parseInt(situps.getText().toString()) == 14) {
                        situpspoints = 2;
                    } else if (Integer.parseInt(situps.getText().toString()) == 13) {
                        situpspoints = 1;
                    } else {
                        situpspoints = 0;
                    }

                    //PUSHUP
                    if (Integer.parseInt(pushups.getText().toString()) >= 46) {
                        pushupspoints = 25;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 45 || Integer.parseInt(pushups.getText().toString()) == 44 || Integer.parseInt(pushups.getText().toString()) == 43 || Integer.parseInt(pushups.getText().toString()) == 42) {
                        pushupspoints = 24;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 41 || Integer.parseInt(pushups.getText().toString()) == 40 || Integer.parseInt(pushups.getText().toString()) == 39 || Integer.parseInt(pushups.getText().toString()) == 38 )  {
                        pushupspoints = 23;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 37 || Integer.parseInt(pushups.getText().toString()) == 36 || Integer.parseInt(pushups.getText().toString()) == 35 || Integer.parseInt(pushups.getText().toString()) == 34) {
                        pushupspoints = 22;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 33 || Integer.parseInt(pushups.getText().toString()) == 32 || Integer.parseInt(pushups.getText().toString()) == 31 || Integer.parseInt(pushups.getText().toString()) == 30 ) {
                        pushupspoints = 21;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 29 || Integer.parseInt(pushups.getText().toString()) == 28 || Integer.parseInt(pushups.getText().toString()) == 27 || Integer.parseInt(pushups.getText().toString()) == 26) {
                        pushupspoints = 20;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 25 || Integer.parseInt(pushups.getText().toString()) == 24 || Integer.parseInt(pushups.getText().toString()) == 23) {
                        pushupspoints = 19;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 22 || Integer.parseInt(pushups.getText().toString()) == 21 || Integer.parseInt(pushups.getText().toString()) == 20) {
                        pushupspoints = 18;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 19) {
                        pushupspoints = 17;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 18) {
                        pushupspoints = 16;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 17 || Integer.parseInt(pushups.getText().toString()) == 16) {
                        pushupspoints = 15;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 15) {
                        pushupspoints = 10;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 14) {
                        pushupspoints = 5;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 13) {
                        pushupspoints = 1;
                    } else {
                        pushupspoints = 0;
                    }

                    //2.4km
                    if (Integer.parseInt(mins.getText().toString()) <= 10 && Integer.parseInt(secs.getText().toString()) <= 30) {
                        runningpoints = 50;
                    } else if (Integer.parseInt(mins.getText().toString()) == 10 && Integer.parseInt(secs.getText().toString()) <= 40) {
                        runningpoints = 49;
                    } else if (Integer.parseInt(mins.getText().toString()) == 10 && Integer.parseInt(secs.getText().toString()) <= 50) {
                        runningpoints = 48;
                    } else if (Integer.parseInt(mins.getText().toString()) == 10 && Integer.parseInt(secs.getText().toString()) <= 59) {
                        runningpoints = 47;
                    } else if (Integer.parseInt(mins.getText().toString()) == 11 && Integer.parseInt(secs.getText().toString()) == 0) {
                        runningpoints = 47;
                    } else if (Integer.parseInt(mins.getText().toString()) == 11 && Integer.parseInt(secs.getText().toString()) <= 20) {
                        runningpoints = 46;
                    } else if (Integer.parseInt(mins.getText().toString()) == 11 && Integer.parseInt(secs.getText().toString()) <= 40) {
                        runningpoints = 45;
                    } else if (Integer.parseInt(mins.getText().toString()) == 11 && Integer.parseInt(secs.getText().toString()) <= 59) {
                        runningpoints = 44;
                    } else if (Integer.parseInt(mins.getText().toString()) == 12 && Integer.parseInt(secs.getText().toString()) == 0) {
                        runningpoints = 44;
                    } else if (Integer.parseInt(mins.getText().toString()) == 12 && Integer.parseInt(secs.getText().toString()) <= 20) {
                        runningpoints = 43;
                    } else if (Integer.parseInt(mins.getText().toString()) == 12 && Integer.parseInt(secs.getText().toString()) <= 40) {
                        runningpoints = 42;
                    } else if (Integer.parseInt(mins.getText().toString()) == 12 && Integer.parseInt(secs.getText().toString()) <= 59) {
                        runningpoints = 41;
                    } else if (Integer.parseInt(mins.getText().toString()) == 13 && Integer.parseInt(secs.getText().toString()) == 0) {
                        runningpoints = 41;
                    } else if (Integer.parseInt(mins.getText().toString()) == 13 && Integer.parseInt(secs.getText().toString()) <= 20) {
                        runningpoints = 39;
                    } else if (Integer.parseInt(mins.getText().toString()) == 13 && Integer.parseInt(secs.getText().toString()) <= 50) {
                        runningpoints = 38;
                    } else if (Integer.parseInt(mins.getText().toString()) == 13 && Integer.parseInt(secs.getText().toString()) <= 59) {
                        runningpoints = 37;
                    } else if (Integer.parseInt(mins.getText().toString()) == 14 && Integer.parseInt(secs.getText().toString()) <= 20) {
                        runningpoints = 37;
                    } else if (Integer.parseInt(mins.getText().toString()) == 14 && Integer.parseInt(secs.getText().toString()) <= 50) {
                        runningpoints = 36;
                    } else if (Integer.parseInt(mins.getText().toString()) == 14 && Integer.parseInt(secs.getText().toString()) <= 59) {
                        runningpoints = 35;
                    } else if (Integer.parseInt(mins.getText().toString()) == 15 && Integer.parseInt(secs.getText().toString()) <= 20) {
                        runningpoints = 35;
                    } else if (Integer.parseInt(mins.getText().toString()) == 15 && Integer.parseInt(secs.getText().toString()) <= 40) {
                        runningpoints = 34;
                    } else if (Integer.parseInt(mins.getText().toString()) == 15 && Integer.parseInt(secs.getText().toString()) <= 59) {
                        runningpoints = 33;
                    } else if (Integer.parseInt(mins.getText().toString()) == 16 && Integer.parseInt(secs.getText().toString()) == 0) {
                        runningpoints = 33;
                    } else if (Integer.parseInt(mins.getText().toString()) == 16 && Integer.parseInt(secs.getText().toString()) <= 20) {
                        runningpoints = 32;
                    } else if (Integer.parseInt(mins.getText().toString()) == 16 && Integer.parseInt(secs.getText().toString()) <= 40) {
                        runningpoints = 31;
                    } else if (Integer.parseInt(mins.getText().toString()) == 16 && Integer.parseInt(secs.getText().toString()) <= 59) {
                        runningpoints = 30;
                    } else if (Integer.parseInt(mins.getText().toString()) == 17 && Integer.parseInt(secs.getText().toString()) == 0) {
                        runningpoints = 30;
                    } else if (Integer.parseInt(mins.getText().toString()) == 17 && Integer.parseInt(secs.getText().toString()) <= 10) {
                        runningpoints = 29;
                    } else if (Integer.parseInt(mins.getText().toString()) == 17 && Integer.parseInt(secs.getText().toString()) <= 20) {
                        runningpoints = 28;
                    } else if (Integer.parseInt(mins.getText().toString()) == 17 && Integer.parseInt(secs.getText().toString()) <= 30) {
                        runningpoints = 27;
                    } else if (Integer.parseInt(mins.getText().toString()) == 17 && Integer.parseInt(secs.getText().toString()) <= 40) {
                        runningpoints = 26;
                    } else if (Integer.parseInt(mins.getText().toString()) == 17 && Integer.parseInt(secs.getText().toString()) <= 50) {
                        runningpoints = 25;
                    } else if (Integer.parseInt(mins.getText().toString()) == 17 && Integer.parseInt(secs.getText().toString()) <= 59) {
                        runningpoints = 24;
                    } else if (Integer.parseInt(mins.getText().toString()) == 18 && Integer.parseInt(secs.getText().toString()) == 0) {
                        runningpoints = 24;
                    } else if (Integer.parseInt(mins.getText().toString()) == 18 && Integer.parseInt(secs.getText().toString()) <= 10) {
                        runningpoints = 23;
                    } else if (Integer.parseInt(mins.getText().toString()) == 18 && Integer.parseInt(secs.getText().toString()) <= 20) {
                        runningpoints = 22;
                    } else if (Integer.parseInt(mins.getText().toString()) == 18 && Integer.parseInt(secs.getText().toString()) <= 30) {
                        runningpoints = 21;
                    } else if (Integer.parseInt(mins.getText().toString()) == 18 && Integer.parseInt(secs.getText().toString()) <= 40) {
                        runningpoints = 20;
                    } else if (Integer.parseInt(mins.getText().toString()) == 18 && Integer.parseInt(secs.getText().toString()) <= 50) {
                        runningpoints = 18;
                    } else if (Integer.parseInt(mins.getText().toString()) == 18 && Integer.parseInt(secs.getText().toString()) <= 59) {
                        runningpoints = 16;
                    } else if (Integer.parseInt(mins.getText().toString()) == 19 && Integer.parseInt(secs.getText().toString()) == 0) {
                        runningpoints = 16;
                    } else if (Integer.parseInt(mins.getText().toString()) == 19 && Integer.parseInt(secs.getText().toString()) <= 10) {
                        runningpoints = 14;
                    } else if (Integer.parseInt(mins.getText().toString()) == 19 && Integer.parseInt(secs.getText().toString()) <= 20) {
                        runningpoints = 12;
                    } else if (Integer.parseInt(mins.getText().toString()) == 19 && Integer.parseInt(secs.getText().toString()) <= 30) {
                        runningpoints = 10;
                    } else if (Integer.parseInt(mins.getText().toString()) == 19 && Integer.parseInt(secs.getText().toString()) <= 40) {
                        runningpoints = 8;
                    } else if (Integer.parseInt(mins.getText().toString()) == 19 && Integer.parseInt(secs.getText().toString()) <= 50) {
                        runningpoints = 6;
                    } else if (Integer.parseInt(mins.getText().toString()) == 19 && Integer.parseInt(secs.getText().toString()) <= 59) {
                        runningpoints = 4;
                    } else if (Integer.parseInt(mins.getText().toString()) == 20 && Integer.parseInt(secs.getText().toString()) == 0) {
                        runningpoints = 4;
                    } else if (Integer.parseInt(mins.getText().toString()) == 20 && Integer.parseInt(secs.getText().toString()) <= 10) {
                        runningpoints = 2;
                    } else if (Integer.parseInt(mins.getText().toString()) == 20 && Integer.parseInt(secs.getText().toString()) <= 20) {
                        runningpoints = 1;
                    } else {
                        runningpoints = 0;
                    }

                    total = situpspoints + pushupspoints + runningpoints;

                    if (total <= 49) {
                        award.setText("Failed");
                    } else if (total <= 59) {
                        award.setText("Pass");
                    } else if (total <= 69) {
                        award.setText("Pass with incentive");
                    } else if (total <= 79) {
                        award.setText("Silver");
                    } else {
                        award.setText("Gold");
                    }

                    points.setText(Integer.toString(total));
                }
                catch (Exception e)
                {
                    Toast.makeText(Student_ippt.this, "Please enter valid entries", Toast.LENGTH_SHORT).show();
                }

            }});
    }

    public void ageGroupFemale4() {
        Button total = findViewById(R.id.btn_Student_Calculate);

        total.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int situpspoints = 0;
                    int pushupspoints = 0;
                    int runningpoints = 0;
                    int total = 0;

                    //SITUP
                    if (Integer.parseInt(situps.getText().toString()) >= 45) {
                        situpspoints = 25;
                    } else if (Integer.parseInt(situps.getText().toString()) == 44 || Integer.parseInt(situps.getText().toString()) == 43) {
                        situpspoints = 24;
                    } else if (Integer.parseInt(situps.getText().toString()) == 42 || Integer.parseInt(situps.getText().toString()) == 41) {
                        situpspoints = 23;
                    } else if (Integer.parseInt(situps.getText().toString()) == 40 || Integer.parseInt(situps.getText().toString()) == 39 || Integer.parseInt(situps.getText().toString()) == 38) {
                        situpspoints = 22;
                    } else if (Integer.parseInt(situps.getText().toString()) == 37 || Integer.parseInt(situps.getText().toString()) == 36 || Integer.parseInt(situps.getText().toString()) == 35) {
                        situpspoints = 21;
                    } else if (Integer.parseInt(situps.getText().toString()) == 34 || Integer.parseInt(situps.getText().toString()) == 33 || Integer.parseInt(situps.getText().toString()) == 32) {
                        situpspoints = 20;
                    } else if (Integer.parseInt(situps.getText().toString()) == 31 || Integer.parseInt(situps.getText().toString()) == 30 || Integer.parseInt(situps.getText().toString()) == 29) {
                        situpspoints = 19;
                    } else if (Integer.parseInt(situps.getText().toString()) == 28 || Integer.parseInt(situps.getText().toString()) == 27 || Integer.parseInt(situps.getText().toString()) == 26) {
                        situpspoints = 18;
                    } else if (Integer.parseInt(situps.getText().toString()) == 25) {
                        situpspoints = 17;
                    } else if (Integer.parseInt(situps.getText().toString()) == 24) {
                        situpspoints = 16;
                    } else if (Integer.parseInt(situps.getText().toString()) == 23 || Integer.parseInt(situps.getText().toString()) == 22) {
                        situpspoints = 15;
                    } else if (Integer.parseInt(situps.getText().toString()) == 21) {
                        situpspoints = 14;
                    } else if (Integer.parseInt(situps.getText().toString()) == 20) {
                        situpspoints = 13;
                    } else if (Integer.parseInt(situps.getText().toString()) == 19) {
                        situpspoints = 12;
                    } else if (Integer.parseInt(situps.getText().toString()) == 18) {
                        situpspoints = 11;
                    } else if (Integer.parseInt(situps.getText().toString()) == 17) {
                        situpspoints = 10;
                    } else if (Integer.parseInt(situps.getText().toString()) == 16) {
                        situpspoints = 8;
                    } else if (Integer.parseInt(situps.getText().toString()) == 15) {
                        situpspoints = 6;
                    } else if (Integer.parseInt(situps.getText().toString()) == 14) {
                        situpspoints = 4;
                    } else if (Integer.parseInt(situps.getText().toString()) == 13) {
                        situpspoints = 2;
                    } else if (Integer.parseInt(situps.getText().toString()) == 12) {
                        situpspoints = 1;
                    } else {
                        situpspoints = 0;
                    }

                    //PUSHUP
                    if (Integer.parseInt(pushups.getText().toString()) >= 44) {
                        pushupspoints = 25;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 43 || Integer.parseInt(pushups.getText().toString()) == 42) {
                        pushupspoints = 24;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 41 || Integer.parseInt(pushups.getText().toString()) == 40 || Integer.parseInt(pushups.getText().toString()) == 39) {
                        pushupspoints = 23;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 38 || Integer.parseInt(pushups.getText().toString()) == 37 || Integer.parseInt(pushups.getText().toString()) == 36 || Integer.parseInt(pushups.getText().toString()) == 35) {
                        pushupspoints = 22;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 34 || Integer.parseInt(pushups.getText().toString()) == 33 || Integer.parseInt(pushups.getText().toString()) == 32 || Integer.parseInt(pushups.getText().toString()) == 31 || Integer.parseInt(pushups.getText().toString()) == 30) {
                        pushupspoints = 21;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 29 || Integer.parseInt(pushups.getText().toString()) == 28 || Integer.parseInt(pushups.getText().toString()) == 27 || Integer.parseInt(pushups.getText().toString()) == 26 || Integer.parseInt(pushups.getText().toString()) == 25) {
                        pushupspoints = 20;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 24 || Integer.parseInt(pushups.getText().toString()) == 23 || Integer.parseInt(pushups.getText().toString()) == 22) {
                        pushupspoints = 19;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 21 || Integer.parseInt(pushups.getText().toString()) == 20 || Integer.parseInt(pushups.getText().toString()) == 19) {
                        pushupspoints = 18;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 18) {
                        pushupspoints = 17;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 17) {
                        pushupspoints = 16;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 16 || Integer.parseInt(pushups.getText().toString()) == 15) {
                        pushupspoints = 15;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 14) {
                        pushupspoints = 10;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 13) {
                        pushupspoints = 5;
                    } else if (Integer.parseInt(pushups.getText().toString()) == 12) {
                        pushupspoints = 1;
                    } else {
                        pushupspoints = 0;
                    }

                    //2.4km
                    if (Integer.parseInt(mins.getText().toString()) <= 10 && Integer.parseInt(secs.getText().toString()) <= 40) {
                        runningpoints = 50;
                    } else if (Integer.parseInt(mins.getText().toString()) == 10 && Integer.parseInt(secs.getText().toString()) <= 50) {
                        runningpoints = 49;
                    } else if (Integer.parseInt(mins.getText().toString()) == 10 && Integer.parseInt(secs.getText().toString()) <= 59) {
                        runningpoints = 48;
                    } else if (Integer.parseInt(mins.getText().toString()) == 11 && Integer.parseInt(secs.getText().toString()) == 0) {
                        runningpoints = 48;
                    } else if (Integer.parseInt(mins.getText().toString()) == 11 && Integer.parseInt(secs.getText().toString()) <= 10) {
                        runningpoints = 47;
                    } else if (Integer.parseInt(mins.getText().toString()) == 11 && Integer.parseInt(secs.getText().toString()) <= 30) {
                        runningpoints = 46;
                    } else if (Integer.parseInt(mins.getText().toString()) == 11 && Integer.parseInt(secs.getText().toString()) <= 50) {
                        runningpoints = 45;
                    } else if (Integer.parseInt(mins.getText().toString()) == 11 && Integer.parseInt(secs.getText().toString()) <= 59) {
                        runningpoints = 44;
                    } else if (Integer.parseInt(mins.getText().toString()) == 12 && Integer.parseInt(secs.getText().toString()) <= 10) {
                        runningpoints = 44;
                    } else if (Integer.parseInt(mins.getText().toString()) == 12 && Integer.parseInt(secs.getText().toString()) <= 30) {
                        runningpoints = 43;
                    } else if (Integer.parseInt(mins.getText().toString()) == 12 && Integer.parseInt(secs.getText().toString()) <= 50) {
                        runningpoints = 42;
                    } else if (Integer.parseInt(mins.getText().toString()) == 12 && Integer.parseInt(secs.getText().toString()) <= 59) {
                        runningpoints = 41;
                    } else if (Integer.parseInt(mins.getText().toString()) == 13 && Integer.parseInt(secs.getText().toString()) <= 10) {
                        runningpoints = 41;
                    } else if (Integer.parseInt(mins.getText().toString()) == 13 && Integer.parseInt(secs.getText().toString()) <= 30) {
                        runningpoints = 39;
                    } else if (Integer.parseInt(mins.getText().toString()) == 13 && Integer.parseInt(secs.getText().toString()) <= 59) {
                        runningpoints = 38;
                    } else if (Integer.parseInt(mins.getText().toString()) == 14 && Integer.parseInt(secs.getText().toString()) == 0) {
                        runningpoints = 38;
                    } else if (Integer.parseInt(mins.getText().toString()) == 14 && Integer.parseInt(secs.getText().toString()) <= 30) {
                        runningpoints = 37;
                    } else if (Integer.parseInt(mins.getText().toString()) == 14 && Integer.parseInt(secs.getText().toString()) <= 59) {
                        runningpoints = 36;
                    } else if (Integer.parseInt(mins.getText().toString()) == 15 && Integer.parseInt(secs.getText().toString()) == 0) {
                        runningpoints = 36;
                    } else if (Integer.parseInt(mins.getText().toString()) == 15 && Integer.parseInt(secs.getText().toString()) <= 30) {
                        runningpoints = 35;
                    } else if (Integer.parseInt(mins.getText().toString()) == 15 && Integer.parseInt(secs.getText().toString()) <= 50) {
                        runningpoints = 34;
                    } else if (Integer.parseInt(mins.getText().toString()) == 15 && Integer.parseInt(secs.getText().toString()) <= 59) {
                        runningpoints = 33;
                    } else if (Integer.parseInt(mins.getText().toString()) == 16 && Integer.parseInt(secs.getText().toString()) <= 10) {
                        runningpoints = 33;
                    } else if (Integer.parseInt(mins.getText().toString()) == 16 && Integer.parseInt(secs.getText().toString()) <= 30) {
                        runningpoints = 32;
                    } else if (Integer.parseInt(mins.getText().toString()) == 16 && Integer.parseInt(secs.getText().toString()) <= 50) {
                        runningpoints = 31;
                    } else if (Integer.parseInt(mins.getText().toString()) == 16 && Integer.parseInt(secs.getText().toString()) <= 59) {
                        runningpoints = 30;
                    } else if (Integer.parseInt(mins.getText().toString()) == 17 && Integer.parseInt(secs.getText().toString()) == 0) {
                        runningpoints = 30;
                    } else if (Integer.parseInt(mins.getText().toString()) == 17 && Integer.parseInt(secs.getText().toString()) <= 20) {
                        runningpoints = 29;
                    } else if (Integer.parseInt(mins.getText().toString()) == 17 && Integer.parseInt(secs.getText().toString()) <= 30) {
                        runningpoints = 28;
                    } else if (Integer.parseInt(mins.getText().toString()) == 17 && Integer.parseInt(secs.getText().toString()) <= 40) {
                        runningpoints = 27;
                    } else if (Integer.parseInt(mins.getText().toString()) == 17 && Integer.parseInt(secs.getText().toString()) <= 50) {
                        runningpoints = 26;
                    } else if (Integer.parseInt(mins.getText().toString()) == 17 && Integer.parseInt(secs.getText().toString()) <= 59) {
                        runningpoints = 25;
                    } else if (Integer.parseInt(mins.getText().toString()) == 18 && Integer.parseInt(secs.getText().toString()) == 0) {
                        runningpoints = 25;
                    } else if (Integer.parseInt(mins.getText().toString()) == 18 && Integer.parseInt(secs.getText().toString()) <= 10) {
                        runningpoints = 24;
                    } else if (Integer.parseInt(mins.getText().toString()) == 18 && Integer.parseInt(secs.getText().toString()) <= 20) {
                        runningpoints = 23;
                    } else if (Integer.parseInt(mins.getText().toString()) == 18 && Integer.parseInt(secs.getText().toString()) <= 30) {
                        runningpoints = 22;
                    } else if (Integer.parseInt(mins.getText().toString()) == 18 && Integer.parseInt(secs.getText().toString()) <= 40) {
                        runningpoints = 21;
                    } else if (Integer.parseInt(mins.getText().toString()) == 18 && Integer.parseInt(secs.getText().toString()) <= 50) {
                        runningpoints = 20;
                    } else if (Integer.parseInt(mins.getText().toString()) == 18 && Integer.parseInt(secs.getText().toString()) <= 59) {
                        runningpoints = 18;
                    } else if (Integer.parseInt(mins.getText().toString()) == 19 && Integer.parseInt(secs.getText().toString()) == 0) {
                        runningpoints = 18;
                    } else if (Integer.parseInt(mins.getText().toString()) == 19 && Integer.parseInt(secs.getText().toString()) <= 10) {
                        runningpoints = 16;
                    } else if (Integer.parseInt(mins.getText().toString()) == 19 && Integer.parseInt(secs.getText().toString()) <= 20) {
                        runningpoints = 14;
                    } else if (Integer.parseInt(mins.getText().toString()) == 19 && Integer.parseInt(secs.getText().toString()) <= 30) {
                        runningpoints = 12;
                    } else if (Integer.parseInt(mins.getText().toString()) == 19 && Integer.parseInt(secs.getText().toString()) <= 40) {
                        runningpoints = 10;
                    } else if (Integer.parseInt(mins.getText().toString()) == 19 && Integer.parseInt(secs.getText().toString()) <= 50) {
                        runningpoints = 8;
                    } else if (Integer.parseInt(mins.getText().toString()) == 19 && Integer.parseInt(secs.getText().toString()) <= 59) {
                        runningpoints = 6;
                    } else if (Integer.parseInt(mins.getText().toString()) == 20 && Integer.parseInt(secs.getText().toString()) == 0) {
                        runningpoints = 6;
                    } else if (Integer.parseInt(mins.getText().toString()) == 20 && Integer.parseInt(secs.getText().toString()) <= 10) {
                        runningpoints = 4;
                    } else if (Integer.parseInt(mins.getText().toString()) == 20 && Integer.parseInt(secs.getText().toString()) <= 20) {
                        runningpoints = 2;
                    } else if (Integer.parseInt(mins.getText().toString()) == 20 && Integer.parseInt(secs.getText().toString()) <= 30) {
                        runningpoints = 1;
                    } else {
                        runningpoints = 0;
                    }

                    total = situpspoints + pushupspoints + runningpoints;

                    if (total <= 49) {
                        award.setText("Failed");
                    } else if (total <= 59) {
                        award.setText("Pass");
                    } else if (total <= 69) {
                        award.setText("Pass with incentive");
                    } else if (total <= 79) {
                        award.setText("Silver");
                    } else {
                        award.setText("Gold");
                    }

                    points.setText(Integer.toString(total));
                } catch (Exception e) {
                    Toast.makeText(Student_ippt.this, "Please enter valid entries", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }


    @Override
    protected void onPause() {
        super.onPause();
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
    }
}
