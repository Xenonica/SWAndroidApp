package com.example.joshu.fyp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Netball_student extends AppCompatActivity {

    Button netballRules, netballPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_netball_student);

        netballPosition = findViewById(R.id.btn_Netball_Position);
        netballRules = findViewById(R.id.btn_Netball_Rules);

    }

    public void netballRules(View view) {
        Intent intent = new Intent(getApplicationContext(), Student_Netball_Rules.class);
        startActivity(intent);
    }

    public void netballPosition(View view) {
        Intent intent = new Intent(getApplicationContext(), Student_Netball_Position.class);
        startActivity(intent);
    }
}
