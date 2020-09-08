package com.example.joshu.fyp;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Homepage extends AppCompatActivity {

    Button teacher, student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        teacherIntent();
        studentIntent();

    }

    public void teacherIntent()
    {
        teacher = (Button) findViewById(R.id.btnTeacher);


        teacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent teacher = new Intent (getApplicationContext(), TeacherLogin.class);
                startActivity(teacher);
            }
        });
    }
    public void studentIntent()
    {
        student = (Button) findViewById(R.id.btnStudent);

        student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent student = new Intent(getApplicationContext(), Student_Menu.class);
               startActivity(student);
            }
        });






    }


}
