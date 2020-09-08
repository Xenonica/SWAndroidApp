package com.example.joshu.fyp;

import android.app.DatePickerDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.TimeZone;

public class SubmitAttList extends AppCompatActivity{

    ListView listView;
    List<User> userList;

    EditText textdatepick;
    Button submit, datepick;
    Spinner classes;

    int bYear,bMonth,bDay;
    int aYear, aMonth, aDay;
    String classestext;
    String userID;

    FirebaseAuth firebaseAuth;
    AttendanceAdapter attendanceAdapter;
    User users;

    HashMap<String, Integer> hashMap = new HashMap<>();
    HashMap<String, Integer> hashMap1 = new HashMap<>();

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_att_list);

        overridePendingTransition(R.anim.fadein, R.anim.fadeout);

        submit =findViewById(R.id.btn_submitAtt);
        datepick = findViewById(R.id.datepicker);
        textdatepick = findViewById(R.id.editText_date);
        listView = findViewById(R.id.listview);
        classes = findViewById(R.id.spinner_class);

        userList = new ArrayList<>();
        attendanceAdapter = new AttendanceAdapter(SubmitAttList.this, userList);
        listView.setAdapter(attendanceAdapter);

        firebaseAuth = FirebaseAuth.getInstance();
        final FirebaseUser user = firebaseAuth.getCurrentUser();
        userID = user.getUid();

        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        aDay = calendar.get(Calendar.DAY_OF_MONTH);
        aMonth = calendar.get(Calendar.MONTH);
        aYear = calendar.get(Calendar.YEAR);


        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference(userID).child("Classes");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull final DataSnapshot dataSnapshot) {
                final List<String> classlist = new ArrayList<String>();
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    String classname = ds.getKey();
                    classlist.add(classname);
                }
                ArrayAdapter<String> areasAdapter = new ArrayAdapter<String>(SubmitAttList.this, android.R.layout.simple_spinner_item, classlist);
                areasAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                classes.setAdapter(areasAdapter);

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
                        userList.clear();
                        Iterable<DataSnapshot> children = dataSnapshot.getChildren();
                        for (DataSnapshot child : children) {
                            users = child.getValue(User.class);
                            userList.add(users);
                        }
                        attendanceAdapter.notifyDataSetChanged();
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


    public void submitAttendance(View view) {
        Integer num = 0;

        if (textdatepick.getText().toString().equals("")){
            Toast.makeText(this, "Please enter date", Toast.LENGTH_SHORT).show();
        }
        else {
            for (int i = 0; i < userList.size(); i++) {
                hashMap.put(userList.get(i).getName(), userList.get(i).getAttendancevalue());
                hashMap1.put(userList.get(i).getName(), num);
            }

            for ( int i = 0 ; i < listView.getCount() ; i++) {
                View v = getViewByPosition(i, listView);
                CheckBox cb = v.findViewById(R.id.cb_present);
                String name = ((TextView) v.findViewById(R.id.textview_names)).getText().toString().trim();
                Integer totalAttendance = hashMap.get(name);
                if (cb.isChecked()) {
                    hashMap.put(name, totalAttendance + 11);
                    hashMap1.put(name, num + 1);
                } else {
                    hashMap.put(name, totalAttendance + 10);
                    hashMap1.put(name, num + 0);
                }
            }

            FirebaseDatabase database = FirebaseDatabase.getInstance();
            final DatabaseReference databaseReference = database.getReference(userID).child("Classes").child(classestext);
            final DatabaseReference attendancelist = database.getReference(userID);
            databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    Iterable<DataSnapshot> children = dataSnapshot.getChildren();
                    for (DataSnapshot child : children) {
                        users = child.getValue(User.class);
                        String name = users.getName();
                        int attendance = hashMap.get(name);
                        int num = hashMap1.get(name);
                        attendancelist.child("Attendance").child(classestext).child(bYear + "").child((bMonth + 1) + "").child(bDay + "").child(name).setValue(num);
                        child.getRef().child("attendancevalue").setValue(attendance);
                    }
                    Toast.makeText(getApplicationContext(),"Attendance submitted.", Toast.LENGTH_SHORT).show();
                    attendanceAdapter.notifyDataSetChanged();
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                }
            });
            finish();
        }
    }

    public View getViewByPosition(int position, ListView listView) {
        final int firstListItemPosition = listView.getFirstVisiblePosition();
        final int lastListItemPosition = firstListItemPosition + listView.getChildCount() - 1;

        if (position < firstListItemPosition || position > lastListItemPosition) {
            return listView.getAdapter().getView(position, listView.getChildAt(position), listView);
        } else {
            final int childIndex = position - firstListItemPosition;
            return listView.getChildAt(childIndex);
        }
    }

    public void datePicker(View view) {

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int aYear, int aMonth, int aDay) {

                bYear = aYear;
                bMonth = aMonth;
                bDay = aDay;

                textdatepick.setText(aDay + "-" + (aMonth+1)  + "-" + aYear);

            }
        }, aYear, aMonth, aDay);
        datePickerDialog.show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
    }
}
