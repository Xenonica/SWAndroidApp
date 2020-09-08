package com.example.joshu.fyp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main_Page_For_Student extends AppCompatActivity {
    Button Badminton, Basketball,Volleyball,Netball,Frisbee,TableTennis,cap,swim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__page__for__student);

        BadmintonIntent();
        BasketballIntent();
        VolleyballIntent();
        NetballIntent();
        FrisbeeIntent();
        TableTennisIntent();
        capIntent();
        swimIntent();

    }
    public void BadmintonIntent()
    {
        Badminton = (Button) findViewById(R.id.btn_Badminton);

        Badminton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent badminton = new Intent (getApplicationContext(), Badminton_Student.class);
                startActivity(badminton);
            }
        });
    }
    public void BasketballIntent()
    {
        Basketball = (Button) findViewById(R.id.btn_Basketball);

        Basketball.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent basketball = new Intent (getApplicationContext(),Student_Basketball_Menu.class);
                startActivity(basketball);
            }
        });
    }
    public void VolleyballIntent()
    {
        Volleyball = (Button) findViewById(R.id.btn_Volleyball);

        Volleyball.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent volleyball = new Intent (getApplicationContext(),Volleyball_student.class);
                startActivity(volleyball);
            }
        });
    }
    public void NetballIntent()
    {
        Netball = (Button) findViewById(R.id.btn_netball);

        Netball.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent netball = new Intent(getApplicationContext(),Netball_student.class);
                startActivity(netball);
            }
        });
    }

    public void FrisbeeIntent()
    {
        Frisbee = (Button) findViewById(R.id.btn_fribee);

        Frisbee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent frisbee = new Intent(getApplicationContext(),Student_Frisbee_Menu.class);
                startActivity(frisbee);
            }
        });
    }

    public void TableTennisIntent()
    {
        TableTennis = (Button) findViewById(R.id.btn_tableTennis);

        TableTennis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tabletennis = new Intent(getApplicationContext(),table_tennis.class);
                startActivity(tabletennis);
            }
        });
    }

    public void capIntent()
    {
        cap = (Button) findViewById(R.id.btn_cap);

        cap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cap = new Intent(getApplicationContext(),captain_ball.class);
                startActivity(cap);
            }
        });
    }

    public void swimIntent()
    {
        swim = (Button)findViewById(R.id.btn_swim);

        swim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent swim = new Intent(getApplicationContext(),Student_Swimming_Menu.class);
                startActivity(swim);
            }
        });
    }
}
