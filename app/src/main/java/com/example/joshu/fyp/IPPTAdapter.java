package com.example.joshu.fyp;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class IPPTAdapter extends RecyclerView.Adapter<IPPTAdapter.IPPTViewHolder> {

    private Context context;
    private List<User> userList;
    private List<IPPT> ipptList;
    Dialog myDialog;
    TextView pushups, situps, running, points, awards;

    public IPPTAdapter() {
    }

    public IPPTAdapter(Context context, List<IPPT> ipptList ) {
        this.context = context;
        this.ipptList = ipptList;
    }

    @NonNull
    @Override
    public IPPTViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.ippt_cardview,parent, false);
        final IPPTViewHolder ipptViewHolder = new IPPTViewHolder(view);

        return ipptViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull IPPTViewHolder holder, int position) {

        if(position % 2 == 0){
            holder.cv.setCardBackgroundColor(Color.rgb(192,192,192));
        }else{
            holder.cv.setCardBackgroundColor(Color.WHITE);
        }
        try {

            IPPT ippt = ipptList.get(position);
            holder.name.setText(ippt.getName());
            holder.pushups.setText(String.valueOf(ippt.getPushup()));
            holder.situps.setText(String.valueOf(ippt.getSitup()));
            holder.running.setText(ippt.getRunningtime());
            holder.points.setText(String.valueOf(ippt.getPoints()));
            holder.awards.setText(ippt.getAward());

        }
        catch (Exception e){
            holder.name.setText("-");
            holder.pushups.setText("-");
            holder.situps.setText("-");
            holder.running.setText("-");
            holder.points.setText("-");
            holder.awards.setText("-");
            Toast.makeText(context, "NO DATA FOUND", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public int getItemCount() {
        return ipptList.size();
    }

    public class IPPTViewHolder extends RecyclerView.ViewHolder {

        TextView name, pushups, situps, running, points, awards;
        CardView cv;

        public IPPTViewHolder(View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.txt_viewIPPTName);
            pushups = itemView.findViewById(R.id.txt_viewIPPTPushups);
            situps = itemView.findViewById(R.id.txt_viewIPPTSitups);
            running = itemView.findViewById(R.id.txt_viewIPPTRun);
            points = itemView.findViewById(R.id.txt_viewIPPTPoints);
            awards = itemView.findViewById(R.id.txt_viewIPPTAward);

            cv = itemView.findViewById(R.id.cardview_viewIPPTR);
        }
    }

}

