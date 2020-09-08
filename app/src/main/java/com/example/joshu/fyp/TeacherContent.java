package com.example.joshu.fyp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class TeacherContent extends AppCompatActivity {

    CardView ippt, info, attendance,posts;
    Button logout;
    Button addstudent;
    TextView lecturername;

    FirebaseAuth firebaseAuth;
    FirebaseUser user;
    DatabaseReference getLectuername;
    String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_content);

        lecturername = findViewById(R.id.txt_homeShowName);

        firebaseAuth = FirebaseAuth.getInstance();
        user = firebaseAuth.getCurrentUser();
        userID = user.getUid();
        getLectuername = FirebaseDatabase.getInstance().getReference(userID);

        getLectuername.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()) {
                    Lecturer lecturer = dataSnapshot.getValue(Lecturer.class);
                    lecturername.setText(lecturer.getLecturername());
                }else{
                    lecturername.setText("");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }});


        ipptIntent();
        logoutIntent();
        infoIntent();
        attendanceIntent();
        setPosts();
        addStudentIntent();
    }

    public void ipptIntent(){
        ippt = findViewById(R.id.cardview_ippt);
        ippt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), IPPTContent.class);
                startActivity(intent);
            }
        });

    }


     public void logoutIntent(){
        logout = findViewById(R.id.btn_logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getApplicationContext(), Homepage.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void infoIntent(){
        info = findViewById(R.id.cardview_info);
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), StudentDetailsMenu.class);
                startActivity(intent);
            }
        });
    }

    public void attendanceIntent(){
        attendance = findViewById(R.id.cardview_atttendance);
        attendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AttendanceMenu.class);
                startActivity(intent);
            }
        });

    }

    public void setPosts(){
        posts = findViewById(R.id.cardview_posts);
        posts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PostActivity.class);
                intent.putExtra("lecturerName", lecturername.getText());
                startActivity(intent);
            }
        });
    }

    public void addStudentIntent(){
        addstudent = findViewById(R.id.btn_addStudenrActivity);
        addstudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(getApplicationContext(), AddStudents.class);
                startActivity(intent);
            }
        });
    }


}

