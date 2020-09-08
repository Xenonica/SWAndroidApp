package com.example.joshu.fyp;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder>{

    private Context context;
    private List<User> userList;
    Dialog myDialog;

    public UserAdapter(Context context, List<User> userList) {
        this.context = context;
        this.userList = userList;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.userinfo_format,parent, false);
        final UserViewHolder userViewHolder = new UserViewHolder(view);
;
        myDialog = new Dialog(context);
        myDialog.setContentView(R.layout.dialog_layout);

        int width = (int)(Resources.getSystem().getDisplayMetrics().widthPixels*0.90);
        int height = (int)(Resources.getSystem().getDisplayMetrics().heightPixels*0.90);
        myDialog.getWindow().setLayout(width, height);

        userViewHolder.item_contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView dialog_name = myDialog.findViewById(R.id.textview_name);
                TextView dialog_address = myDialog.findViewById(R.id.textview_Address);
                TextView dialog_gender = myDialog.findViewById(R.id.textview_Gender);
                TextView dialog_nirc = myDialog.findViewById(R.id.textView_nirc);
                TextView dialog_dateofbrith = myDialog.findViewById(R.id.textView_dateOfbirth);
                TextView dialog_email = myDialog.findViewById(R.id.textView_email);
                TextView dialog_moblie= myDialog.findViewById(R.id.textView_mobile);
                TextView dialog_parentscontact = myDialog.findViewById(R.id.textView_parentscontact);
                TextView dialog_parentsname = myDialog.findViewById(R.id.textView_parentsName);
                TextView dialog_race =myDialog.findViewById(R.id.textView_race);
                TextView dialog_nationality = myDialog.findViewById(R.id.textView_Nationality);
                TextView dialog_medical = myDialog.findViewById(R.id.textView_medical);

                dialog_name.setText(userList.get(userViewHolder.getAdapterPosition()).getName());
                dialog_address.setText(userList.get(userViewHolder.getAdapterPosition()).getAddress());
                dialog_gender.setText(userList.get(userViewHolder.getAdapterPosition()).getGender());
                dialog_nirc.setText(userList.get(userViewHolder.getAdapterPosition()).getNric());
                dialog_dateofbrith.setText(userList.get(userViewHolder.getAdapterPosition()).getDateofbirth());
                dialog_email.setText(userList.get(userViewHolder.getAdapterPosition()).getEmail());
                dialog_moblie.setText(userList.get(userViewHolder.getAdapterPosition()).getMobile());
                dialog_parentscontact.setText(userList.get(userViewHolder.getAdapterPosition()).getParentscontact());
                dialog_parentsname.setText(userList.get(userViewHolder.getAdapterPosition()).getParentsname());
                dialog_race.setText(userList.get(userViewHolder.getAdapterPosition()).getRace());
                dialog_nationality.setText(userList.get(userViewHolder.getAdapterPosition()).getNationality());
                dialog_medical.setText(userList.get(userViewHolder.getAdapterPosition()).getMedical());
                myDialog.show();
            }
        });



        return userViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = userList.get(position);
        holder.textViewName.setText(user.getName());

        if(position % 2 == 0){
            holder.cv.setCardBackgroundColor(Color.rgb(192,192,192));
        }else{
            holder.cv.setCardBackgroundColor(Color.WHITE);
        }
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    class UserViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName;
        ConstraintLayout item_contact;
        CardView cv;


        public UserViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewName = itemView.findViewById(R.id.textview_name);
            item_contact = itemView.findViewById(R.id.cardview);
            cv = itemView.findViewById(R.id.cardviewname);
        }
    }

}
