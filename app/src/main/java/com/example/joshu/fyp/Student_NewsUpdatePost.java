package com.example.joshu.fyp;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Student_NewsUpdatePost extends AppCompatActivity {

    ProgressBar progressBar;
    RecyclerView recyclerViews;
    List<PostModel> postModelLists;
    PostsAdapter postsAdapters;
    DatabaseReference databaseReferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_news_update_post);

        progressBar = findViewById(R.id.progressBar_studentPost);
        recyclerViews = findViewById(R.id.recyclerview_studentpost);

        //recyclerView.setHasFixedSize(true);
        recyclerViews.setLayoutManager(new LinearLayoutManager(this));
        postModelLists = new ArrayList<>();
        postsAdapters = new PostsAdapter(this, postModelLists);
        recyclerViews.setAdapter(postsAdapters);

        //firebaseStorage = FirebaseStorage.getInstance();
        databaseReferences = FirebaseDatabase.getInstance().getReference("uploads");

        databaseReferences.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                postModelLists.clear();
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    PostModel postModel = postSnapshot.getValue(PostModel.class);
                    postModel.setKey(postSnapshot.getKey());
                    postModelLists.add(postModel);
                }
                postsAdapters.notifyDataSetChanged();
                progressBar.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(Student_NewsUpdatePost.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
                progressBar.setVisibility(View.INVISIBLE);
            }
        });

    }
}
