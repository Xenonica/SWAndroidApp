package com.example.joshu.fyp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Student_Swimming_Menu extends AppCompatActivity {

    Button swimStrokes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student__swimming__menu);

        swimStrokes = findViewById(R.id.btn_swimming_Strokes);


    }

    public void swimStrokes(View view) {
        Intent intent = new Intent(getApplicationContext(), Student_Swimming_Strokes.class);
        startActivity(intent);
    }
}
