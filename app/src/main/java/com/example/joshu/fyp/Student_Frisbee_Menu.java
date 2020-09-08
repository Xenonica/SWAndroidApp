package com.example.joshu.fyp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Student_Frisbee_Menu extends AppCompatActivity {

    Button general, technique;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student__frisbee__menu);

        general = findViewById(R.id.btn_frisbee_General);
        technique = findViewById(R.id.btn_frisbee_throws);
    }

    public void frisbeeGeneral(View view) {
        Intent intent = new Intent(getApplicationContext(), Student_Frisbee.class);
        startActivity(intent);
    }

    public void frisbeeThrows(View view) {
        Intent intent = new Intent(getApplicationContext(), Student_Frisbee_Techniques.class);
        startActivity(intent);
    }
}
