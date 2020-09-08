package com.example.joshu.fyp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class Student_IPPT_selectAge extends AppCompatActivity {

    Spinner ageGroup;
    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student__ippt_select_age);

        ageGroup = findViewById(R.id.spinner_Student_ageGroup);
        next = findViewById(R.id.btn_Student_next);

        ArrayAdapter<CharSequence> adapter  = ArrayAdapter.createFromResource(this, R.array.age, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ageGroup.setAdapter(adapter);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Student_ippt.class);
                intent.putExtra("Student_ageGroup", ageGroup.getSelectedItemPosition());
                startActivity(intent);
            }
        });
    }
}
