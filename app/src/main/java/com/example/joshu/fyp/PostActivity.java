package com.example.joshu.fyp;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PostActivity extends AppCompatActivity implements  PostsAdapter.OnItemClickListener {

    static final int PICK_IMAGE_REQUEST = 1;
    Button chooseImage, upload;
    ProgressBar progressBar;
    ImageView imageView;
    EditText postTitle;
    TextView lecturername;
    Uri uri;

    StorageReference storageReference;
    DatabaseReference databaseReference;
    StorageTask task;
    FirebaseAuth firebaseAuth;
    FirebaseUser user;

    RecyclerView recyclerView;
    PostsAdapter imageAdapter;
    DatabaseReference databaseReference1;
    FirebaseStorage firebaseStorage;
    ValueEventListener valueEventListener;
    List<PostModel> postModelList;

    DatabaseReference getLectuername;
    String userID;

    Intent i;
    String lecturerName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        overridePendingTransition(R.anim.fadein, R.anim.fadeout);

        chooseImage = findViewById(R.id.btn_choosefile);
        upload = findViewById(R.id.btn_upload);
        postTitle = findViewById(R.id.editText_postTitle);
        progressBar = findViewById(R.id.progressBar2);
        imageView = findViewById(R.id.imageView_image);
        lecturername = findViewById(R.id.txt_lecturerpostname);

        recyclerView = findViewById(R.id.recyclerview_posts);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setNestedScrollingEnabled(false);


        postModelList = new ArrayList<>();
        imageAdapter = new PostsAdapter(PostActivity.this, postModelList);
        recyclerView.setAdapter(imageAdapter);
        imageAdapter.setOnItemClickListener(PostActivity.this);

        storageReference = FirebaseStorage.getInstance().getReference("uploads");
        databaseReference = FirebaseDatabase.getInstance().getReference("uploads");


        firebaseAuth = FirebaseAuth.getInstance();
        user = firebaseAuth.getCurrentUser();
        userID = user.getUid();
       // getLectuername = FirebaseDatabase.getInstance().getReference(userID);
        i = getIntent();
        lecturerName = i.getStringExtra("lecturerName");

        /*getLectuername.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Lecturer lecturer = dataSnapshot.getValue(Lecturer.class);
                lecturername.setText(lecturer.getLecturername());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });*/


        chooseImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFileChooser();
            }
        });

        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (task != null && task.isInProgress()) {
                    Toast.makeText(PostActivity.this, "Upload in progress", Toast.LENGTH_SHORT).show();
                } else {
                    uploadfile();
                }
            }
        });

        firebaseStorage = FirebaseStorage.getInstance();
        databaseReference1 = FirebaseDatabase.getInstance().getReference("uploads");

        valueEventListener = databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                postModelList.clear();
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    PostModel postModel = postSnapshot.getValue(PostModel.class);
                    postModel.setKey(postSnapshot.getKey());
                    postModelList.add(postModel);
                }
                imageAdapter.notifyDataSetChanged();
                progressBar.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(PostActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
                progressBar.setVisibility(View.INVISIBLE);
            }
        });

    }




    private void openFileChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            uri = data.getData();
            Picasso.get().load(uri).into(imageView);
        }
    }

    private String getFileExtension(Uri uri) {
        ContentResolver contentResolver = getContentResolver();
        MimeTypeMap mimeTypeMap = MimeTypeMap.getSingleton();
        return mimeTypeMap.getExtensionFromMimeType(contentResolver.getType(uri));
    }

    private void uploadfile() {
        if (uri != null) {
            progressBar.setVisibility(View.VISIBLE);

            final StorageReference fileReference = storageReference.child(System.currentTimeMillis()
                    + "." + getFileExtension(uri));

            task = fileReference.putFile(uri);

             Task<Uri> task1 = task.continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
                @Override
                public Task<Uri> then(@NonNull Task<UploadTask.TaskSnapshot> task) throws Exception {
                    if (!task.isSuccessful()) {
                        throw Objects.requireNonNull(task.getException());
                    }

                    return fileReference.getDownloadUrl();
                }
            }).addOnCompleteListener(new OnCompleteListener<Uri>() {
                @Override
                public void onComplete(@NonNull Task<Uri> task) {
                    if (task.isSuccessful()) {

                        final Uri downloadUri = task.getResult();
                        String miUrlOk = downloadUri.toString();

                        Toast.makeText(PostActivity.this, "Post successful", Toast.LENGTH_SHORT).show();
                        PostModel postModel = new PostModel(lecturerName, postTitle.getText().toString().trim(), miUrlOk);
                        String uploadId = databaseReference.push().getKey();
                        databaseReference.child(uploadId).setValue(postModel);

                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imageView.setImageDrawable(null);
                                progressBar.setVisibility(View.INVISIBLE);
                                uri = null;
                                //postTitle.setText("");
                            }
                        }, 2000);

                    }
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(PostActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }
        else if(TextUtils.isEmpty(postTitle.getText())){
            Toast.makeText(PostActivity.this, "Post something", Toast.LENGTH_SHORT).show();
            return;
        } else if(imageView.getDrawable() == null) {
            progressBar.setVisibility(View.VISIBLE);
            firebaseAuth = FirebaseAuth.getInstance();
            user = firebaseAuth.getCurrentUser();

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    progressBar.setVisibility(View.INVISIBLE);
                    String uploadId = databaseReference.push().getKey();

                    PostModel postModel = new PostModel(lecturerName, postTitle.getText().toString().trim());
                    databaseReference.child(uploadId).setValue(postModel);

                    Toast.makeText(PostActivity.this, "Post successful", Toast.LENGTH_SHORT).show();
                    //postTitle.setText("");
                }
            }, 2000);

        }

    }

    @Override
    public void onItemClick(int position) {
        Toast.makeText(this, "Normal click at position: " + position, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onDeleteClick(int position) {
        try {
            PostModel selectedItem = postModelList.get(position);
            final String selectedKey = selectedItem.getKey();

            databaseReference.child(selectedKey).removeValue();
            StorageReference storageReference = firebaseStorage.getReferenceFromUrl(selectedItem.getImageurl());
            storageReference.delete().addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void aVoid) {
                    databaseReference.child(selectedKey).removeValue();
                    Toast.makeText(PostActivity.this, "Post deleted", Toast.LENGTH_SHORT).show();
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(PostActivity.this, "Post deleted failed", Toast.LENGTH_SHORT).show();
                }
            });
        } catch(Exception e){

        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        databaseReference.removeEventListener(valueEventListener);
    }

    @Override
    protected void onPause() {
        super.onPause();
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
    }
}

