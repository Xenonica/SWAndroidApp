package com.example.joshu.fyp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.PostsViewHolder> {
    Context context;
    List<PostModel> uploads;
    OnItemClickListener onItemClickListener;
    boolean isImageFitToScreen;

    public PostsAdapter(Context context, List<PostModel> uploads){
        this.context = context;
        this.uploads = uploads;
    }
    @NonNull
    @Override
    public PostsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.cardview_post, parent, false);
        return new PostsViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PostsViewHolder holder, int position) {

        //if(position % 2 == 0){
            //holder.cv.setCardBackgroundColor(Color.rgb(192,192,192));
       // }else{
        //    holder.cv.setCardBackgroundColor(Color.WHITE);
      //  }

        PostModel uploadcurrent = uploads.get(position);
        holder.textviewname.setText(uploadcurrent.getName());
        holder.textviewemail.setText(uploadcurrent.getEmail());
        Picasso.get().load(uploadcurrent.getImageurl()).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return uploads.size();
    }

    public class PostsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnCreateContextMenuListener, MenuItem.OnMenuItemClickListener{

        TextView textviewname, textviewemail;
        ImageView imageView;
        //CardView cv;

        public PostsViewHolder(View itemView) {
            super(itemView);

            textviewname = itemView.findViewById(R.id.textview_imagename);
            imageView = itemView.findViewById(R.id.imageview_upload);
            textviewemail = itemView.findViewById(R.id.textView_emailpost);
            //cv = itemView.findViewById(R.id.cardView_post);

            itemView.setOnClickListener(this);
            itemView.setOnCreateContextMenuListener(this);
        }

        @Override
        public void onClick(View v) {
            if(onItemClickListener != null){
                int position = getAdapterPosition();
                if(position != RecyclerView.NO_POSITION){
                    onItemClickListener.onItemClick(position);
                }
            }
        }

        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            menu.setHeaderTitle("Select Action");
            MenuItem delete = menu.add(Menu.NONE, 1, 1, "Delete");

            delete.setOnMenuItemClickListener(this);
        }

        @Override
        public boolean onMenuItemClick(MenuItem item) {
            if(onItemClickListener != null){
                int position = getAdapterPosition();
                if(position != RecyclerView.NO_POSITION){
                    switch(item.getItemId()){
                        case 1:
                            onItemClickListener.onDeleteClick(position);
                    }
                }
            }
            return false;
        }
    }

    public interface OnItemClickListener{
        void onItemClick(int position);

        void onDeleteClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        onItemClickListener = listener;

    }
}
