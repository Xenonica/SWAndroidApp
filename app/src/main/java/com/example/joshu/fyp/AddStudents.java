package com.example.joshu.fyp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddStudents extends AppCompatActivity {

    FirebaseAuth firebaseAuth;
    String userID;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    Button addStudent;
    EditText student, classes;
    String studentName;
    String className;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_students);

        addStudent = findViewById(R.id.btn_addStudent);
        student = findViewById(R.id.editText_addStudent);
        classes = findViewById(R.id.editText_addClass);

        firebaseAuth = FirebaseAuth.getInstance();
        final FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
        userID = firebaseUser.getUid();

        firebaseDatabase = FirebaseDatabase.getInstance();

        addStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                studentName = student.getText().toString();
                className = classes.getText().toString();
                databaseReference = firebaseDatabase.getReference(userID);
                databaseReference.child("Classes").child(className).child(studentName).child("name").setValue(studentName);
            }
        });

    }
}
