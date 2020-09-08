package com.example.joshu.fyp;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class LecturerAdapter extends RecyclerView.Adapter<LecturerAdapter.LecturerViewHolder> {

    private Context context;
    private List<Lecturer> lecturerList;


    public LecturerAdapter(Context context, List<Lecturer> lecturerList) {
        this.context = context;
        this.lecturerList = lecturerList;
    }

    class LecturerViewHolder extends RecyclerView.ViewHolder{

        TextView lecturername, lectureremail, lecturernumber;
        ImageView lecturerimage;
        CardView cv;

        public LecturerViewHolder(View itemView) {
            super(itemView);

            lecturername = itemView.findViewById(R.id.txt_LecturerName);
            lectureremail = itemView.findViewById(R.id.txt_LecturerEmail);
            lecturernumber = itemView.findViewById(R.id.txt_LecturerNumber);
            lecturerimage = itemView.findViewById(R.id.imageView_lecturer);
            cv = itemView.findViewById(R.id.cardview_lecturerDetails);
        }
    }

    @NonNull
    @Override
    public LecturerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.lecturerlayout, parent, false);
        LecturerViewHolder lecturerViewHolder = new LecturerViewHolder(view);

        return lecturerViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull LecturerViewHolder holder, int position) {

        if(position % 2 == 0){
            holder.cv.setCardBackgroundColor(Color.rgb(192,192,192));
        }else{
            holder.cv.setCardBackgroundColor(Color.WHITE);
        }

        Lecturer lecturer = lecturerList.get(position);
        holder.lecturername.setText(lecturer.getLecturername());
        holder.lectureremail.setText(lecturer.getLectureremail());
        holder.lecturernumber.setText(lecturer.getLecturerno());
        Picasso.get().load(lecturer.getPhotourl()).placeholder(R.drawable.lectuerplaceholder).into(holder.lecturerimage);
    }

    @Override
    public int getItemCount() {
        return (lecturerList.size()-1);
    }


}
