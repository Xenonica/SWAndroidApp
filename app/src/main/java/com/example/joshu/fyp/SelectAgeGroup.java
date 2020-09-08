package com.example.joshu.fyp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class SelectAgeGroup extends AppCompatActivity {

    Spinner ageGroup;
    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_age_group);

        ageGroup = findViewById(R.id.spinner_ageGroup);
        next = findViewById(R.id.btn_next);

        ArrayAdapter<CharSequence> adapter  = ArrayAdapter.createFromResource(this, R.array.age, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ageGroup.setAdapter(adapter);


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), IPPTCalculator.class);
                intent.putExtra("ageGroup", ageGroup.getSelectedItemPosition());
                startActivity(intent);
            }
        });


    }
}
