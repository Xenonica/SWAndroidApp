package com.example.joshu.fyp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class UpdateStudentDetails_selectClass extends AppCompatActivity {

    Button next;
    Spinner classspinner;
    FirebaseDatabase firebaseDatabase;
    FirebaseAuth firebaseAuth;
    String userID;
    ArrayAdapter<String> areasAdapter;
    DatabaseReference databaseReference;
    List<String> classlist = new ArrayList<>();
    String classtext;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_student_details_select_class);

        next = findViewById(R.id.btn_selectNext);
        classspinner = findViewById(R.id.spinner_selectClasses);

        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
        userID = firebaseUser.getUid();

        areasAdapter = new ArrayAdapter<String>(UpdateStudentDetails_selectClass.this, android.R.layout.simple_spinner_item, classlist);
        areasAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        classspinner.setAdapter(areasAdapter);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference(userID).child("Classes");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                classlist.clear();
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    String classname = ds.getKey();
                    classlist.add(classname);
                }
                areasAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(UpdateStudentDetails_selectClass.this, UpdateStudentDetails.class);
                intent.putExtra("classSelection", classspinner.getSelectedItem().toString() );
                startActivity(intent);
            }
        });
    }
}
