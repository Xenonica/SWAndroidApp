package com.example.joshu.fyp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

public class StudentDetailsMenu extends AppCompatActivity {

    CardView update, details;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details_menu);

        update = findViewById(R.id.cardview_updateStudentDetails);
        details = findViewById(R.id.cardview_StudentInfo);
    }

    public void studentInfo(View view) {
        Intent intent = new Intent(getApplicationContext(), UserInfoData.class);
        startActivity(intent);
    }

    public void updateStudentDetails(View view) {
        Intent intent = new Intent(getApplicationContext(), UpdateStudentDetails_selectClass.class);
        startActivity(intent);
    }
}
