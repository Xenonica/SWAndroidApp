package com.example.joshu.fyp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
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

public class UpdateStudentDetails extends AppCompatActivity {

    EditText dateofbirth, email, nric, medical, mobile, address, race, nationality, parentname, parentcontact, gender;
    Spinner classes, names;

    FirebaseAuth firebaseAuth;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    String userID;
    String classestext;
    String a;

    List<String> classlist = new ArrayList<String>();
    ArrayAdapter<String> areasAdapter;
    List<String> nameList = new ArrayList<>();
    ArrayAdapter<String> areasAdapter1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_student_details);

        dateofbirth = findViewById(R.id.editText_updateDoB);
        email = findViewById(R.id.editText_updateEmail);
        medical = findViewById(R.id.editText_updateMedical);
        mobile = findViewById(R.id.editText_updateMobile);
        address = findViewById(R.id.editText_updateAddress);
        nationality = findViewById(R.id.editText_updateNationality);
        race = findViewById(R.id.editText_updateRace);
        parentname = findViewById(R.id.editText_updatePName);
        parentcontact = findViewById(R.id.editText_updatePContact);
        gender = findViewById(R.id.editText_updateGender);
        names = findViewById(R.id.spinner_updateName);
        nric = findViewById(R.id.editText_updateNRIC);

        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
        userID = firebaseUser.getUid();

        Intent i = getIntent();
        a = i.getStringExtra("classSelection");

        areasAdapter1 = new ArrayAdapter<String>(UpdateStudentDetails.this, android.R.layout.simple_spinner_item, nameList);
        areasAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        names.setAdapter(areasAdapter1);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference(userID).child("Classes").child(a);
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                nameList.clear();
                //User user = new User();
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    String name = ds.child("name").getValue(String.class);
                    nameList.add(name);
                }
                areasAdapter1.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });

        names.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                final String name = names.getSelectedItem().toString();
                databaseReference = firebaseDatabase.getReference(userID).child("Classes").child(a);
                databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        for (DataSnapshot child : dataSnapshot.getChildren()) {
                            if (child.child("name").getValue(String.class) == name) {
                                User users = child.getValue(User.class);

                                gender.setText(users.getGender());
                                nric.setText(users.getNric());
                                dateofbirth.setText(users.getDateofbirth());
                                email.setText(users.getEmail());
                                address.setText(users.getAddress());
                                mobile.setText(users.getMobile());
                                race.setText(users.getRace());
                                nationality.setText(users.getNationality());
                                parentname.setText(users.getParentsname());
                                parentcontact.setText(users.getParentscontact());
                                medical.setText(users.getMedical());
                            }
                        }
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                    }
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

    }

    public void updateInfo(View view) {

        try {
            final String name1 = names.getSelectedItem().toString();
            databaseReference = firebaseDatabase.getReference(userID).child("Classes").child(a);
            databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    for (DataSnapshot ds : dataSnapshot.getChildren()) {
                        String sDoB = dateofbirth.getText().toString();
                        String sEmail = email.getText().toString();
                        String sAddress = address.getText().toString();
                        String sMobile = mobile.getText().toString();
                        String sMedical = medical.getText().toString();
                        String sRace = race.getText().toString();
                        String sNationality = nationality.getText().toString();
                        String sParentname = parentname.getText().toString();
                        String sParentcontact = parentcontact.getText().toString();
                        String sGender = gender.getText().toString();
                        String sNRIC = nric.getText().toString();

                        if (ds.child("name").getValue(String.class) == name1) {
                            ds.getRef().child("gender").setValue(sGender);
                            ds.getRef().child("nric").setValue(sNRIC);
                            ds.getRef().child("dateofbirth").setValue(sDoB);
                            ds.getRef().child("email").setValue(sEmail);
                            ds.getRef().child("address").setValue(sAddress);
                            ds.getRef().child("mobile").setValue(sMobile);
                            ds.getRef().child("medical").setValue(sMedical);
                            ds.getRef().child("race").setValue(sRace);
                            ds.getRef().child("nationality").setValue(sNationality);
                            ds.getRef().child("parentsname").setValue(sParentname);
                            ds.getRef().child("parentscontact").setValue(sParentcontact);
                        }
                    }
                    Toast.makeText(getApplicationContext(), "Details updated", Toast.LENGTH_SHORT).show();
                    // attendanceAdapter.notifyDataSetChanged();
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                }
            });
        }
        catch(Exception e){

        }
    }
}
