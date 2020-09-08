package com.example.joshu.fyp;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ViewIPPT extends AppCompatActivity {


    Spinner classes;

    FirebaseAuth firebaseAuth;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    RecyclerView recyclerView;

    String userID;
    String classestext;

    IPPT ippt;

    List<IPPT> ipptList;
    List<User> userList;
    IPPTAdapter ipptAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_ippt);

        overridePendingTransition(R.anim.fadein, R.anim.fadeout);

        classes = findViewById(R.id.spinner_viewIPPTClass);
        recyclerView = findViewById(R.id.recyclerview_ippt);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ipptList = new ArrayList<>();
        userList = new ArrayList<>();
        ipptAdapter = new IPPTAdapter(this, ipptList);
        recyclerView.setAdapter(ipptAdapter);


        firebaseAuth = FirebaseAuth.getInstance();
        final FirebaseUser user = firebaseAuth.getCurrentUser();
        userID = user.getUid();

        final List<String> classlist = new ArrayList<String>();
        final ArrayAdapter<String> areasAdapter = new ArrayAdapter<String>(ViewIPPT.this, android.R.layout.simple_spinner_item, classlist);
        areasAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        classes.setAdapter(areasAdapter);
        firebaseDatabase = FirebaseDatabase.getInstance();

        databaseReference = firebaseDatabase.getReference(userID).child("Classes");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull final DataSnapshot dataSnapshot) {
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


        classes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                classestext = parent.getItemAtPosition(position).toString().trim();
                databaseReference = firebaseDatabase.getReference(userID).child("Classes").child(classestext);
                databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        ipptList.clear();
                        for (DataSnapshot ds : dataSnapshot.getChildren()) {

                            ippt = ds.child("IPPT").getValue(IPPT.class);
                            ipptList.add(ippt);
                        }
                        ipptAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        Toast.makeText(ViewIPPT.this, databaseError.toString(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
    }
}
