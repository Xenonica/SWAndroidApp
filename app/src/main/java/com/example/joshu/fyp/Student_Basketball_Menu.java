package com.example.joshu.fyp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeBaseActivity;

public class Student_Basketball_Menu extends YouTubeBaseActivity {

    Button skills, rules, roles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_basketball_menu);

        skills = findViewById(R.id.btn_basketball_Skills);
        rules = findViewById(R.id.btn_basketball_Rules);
        roles = findViewById(R.id.btn_basketball_Roles);

    }


    public void basketballSkills(View view) {
        Intent intent = new Intent(getApplicationContext(), Student_Basketball_Skills.class);
        startActivity(intent);
    }

    public void basketballRules(View view) {
        Intent intent = new Intent(getApplicationContext(), Student_Basketball_Rules.class);
        startActivity(intent);
    }

    public void basketballRoles(View view) {
        Intent intent = new Intent(getApplicationContext(), Student_Basketball_Roles.class);
        startActivity(intent);
    }
}
