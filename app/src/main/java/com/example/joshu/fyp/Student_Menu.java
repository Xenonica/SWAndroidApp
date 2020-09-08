package com.example.joshu.fyp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

public class Student_Menu extends AppCompatActivity {

    CardView games, ippt, bmi, posts, venue, lecturer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student__menu);

        games = findViewById(R.id.cardview_games);
        ippt = findViewById(R.id.cardview_ippt);
        bmi = findViewById(R.id.cardview_bmi);
        posts = findViewById(R.id.cardview_posts);
        venue = findViewById(R.id.cardview_venue);
        lecturer = findViewById(R.id.cardview_lecturer);

    }

    public void GameSkills(View view) {
        Intent intent = new Intent(getApplicationContext(), Main_Page_For_Student.class);
        startActivity(intent);
    }

    public void IPPT(View view) {
        Intent intent = new Intent(getApplicationContext(), Student_IPPTMenu.class);
        startActivity(intent);
    }

    public void BMI(View view) {
        Intent intent = new Intent(getApplicationContext(), BMI.class);
        startActivity(intent);
    }

    public void News(View view) {
        Intent intent = new Intent(getApplicationContext(), Student_NewsUpdatePost.class);
        startActivity(intent);
    }

    public void Venue(View view) {
        Intent intent = new Intent(getApplicationContext(), SportsFacilities.class);
        startActivity(intent);
    }

    public void LecturerDetails(View view) {
        Intent intent = new Intent(getApplicationContext(), LecturerDetails.class);
        startActivity(intent);
    }
}
