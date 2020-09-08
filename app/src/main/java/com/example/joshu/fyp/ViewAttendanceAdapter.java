package com.example.joshu.fyp;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ViewAttendanceAdapter extends RecyclerView.Adapter<ViewAttendanceAdapter.ViewAttendanceViewHolder> {

    LayoutInflater inflater;
    List<User> viewAttendance;
    Context context;
    User users;

    public class ViewAttendanceViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        TextView attendancePER, attendance;
        CardView cv;

        public ViewAttendanceViewHolder(View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.txt_ViewNameAtt);
            attendancePER = itemView.findViewById(R.id.txt_PercentageAtt);
            attendance = itemView.findViewById(R.id.txt_attendance);
            cv = itemView.findViewById(R.id.cardview_viewAtt);
        }
    }

    public ViewAttendanceAdapter(Context context, List<User> viewAttendance){
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.viewAttendance = viewAttendance;
    }


    @NonNull
    @Override
    public ViewAttendanceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.viewattendance, parent, false);
        ViewAttendanceViewHolder attendanceViewHolder = new ViewAttendanceViewHolder(view);
        return attendanceViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewAttendanceViewHolder holder, int position) {

        User user = viewAttendance.get(position);
        holder.name.setText(user.getName());

        if(position % 2 == 0){
            holder.cv.setCardBackgroundColor(Color.rgb(192,192,192));
        }else{
            holder.cv.setCardBackgroundColor(Color.WHITE);
        }

        try {
            Integer al = user.getAttendancevalue();
            int count = 0;
            int countTot = 0;
            count = count + al % 10;
            int a = al % 10;
            al = al / 10;
            countTot = countTot + al % 10;
            int b = al % 10;
            holder.attendancePER.setText(String.valueOf((count * 100) / countTot + "%"));
            holder.attendance.setText(String.valueOf(a) + "/" + String.valueOf(b));
        } catch (Exception e) {
        }

    }

    @Override
    public int getItemCount() {
        return viewAttendance.size();
    }
}
