package com.example.joshu.fyp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.example.joshu.fyp.R;
import com.example.joshu.fyp.User;

import java.util.List;

public class AttendanceAdapter extends BaseAdapter {

    Context context;
    LayoutInflater inflater;
    List<User> userList;

    AttendanceAdapter(Context context, List<User> userList) {
        this.context = context;
        this.userList = userList;
    }

    @Override
    public int getCount() {
        return userList.size();
    }

    @Override
    public Object getItem(int position) {
        return userList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        CheckBox cb;
        TextView name;

        View view = View.inflate(context, R.layout.attendanceformat, null);
        final User user = userList.get(position);

        cb = view.findViewById(R.id.cb_present);
        name = view.findViewById(R.id.textview_names);
        name.setText(user.getName());

        cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                userList.get(position).selected = isChecked;
            }
        });

        cb.setChecked(userList.get(position).selected);


        return view;

    }
}