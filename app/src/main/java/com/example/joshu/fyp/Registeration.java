package com.example.joshu.fyp;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;

import java.util.Objects;

public class Registeration extends AppCompatActivity {

    EditText email, password, name, contact;
    Button register, photo;
    ImageView showImage;

    FirebaseAuth firebaseAuth;
    FirebaseUser user;
    DatabaseReference databaseReference;
    FirebaseDatabase firebaseDatabase;
    String userID;
    static final int PICK_IMAGE_REQUEST = 1;
    Uri uri;
    StorageReference storageReference;
    StorageTask storageTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeration);

        email = findViewById(R.id.editText_registerEmail);
        password = findViewById(R.id.editText_registerPassword);
        name = findViewById(R.id.editText_registerName);
        contact = findViewById(R.id.editText_registerContact);
        photo = findViewById(R.id.btn_registerPhoto);
        register = findViewById(R.id.btn_registerAccount);
        showImage = findViewById(R.id.imageView_registerPhoto);

        firebaseAuth = FirebaseAuth.getInstance();

        firebaseDatabase = FirebaseDatabase.getInstance();
        storageReference = FirebaseStorage.getInstance().getReference("LecturerPhotos");

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sPassword = password.getText().toString();
                final String sEmail = email.getText().toString();
                final String sName = name.getText().toString();
                final String sContact = contact.getText().toString();

                firebaseAuth.createUserWithEmailAndPassword(sEmail, sPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            user = firebaseAuth.getCurrentUser();
                            userID = user.getUid();
                            Toast.makeText(Registeration.this, "Registration successful", Toast.LENGTH_SHORT).show();
                            databaseReference = firebaseDatabase.getReference();
                            databaseReference.child(userID).child("lecturername").setValue(sName);
                            databaseReference.child(userID).child("lectureremail").setValue(sEmail);
                            databaseReference.child(userID).child("lecturerno").setValue(sContact);

                            if (uri != null) {
                                final StorageReference fileReference = storageReference.child(System.currentTimeMillis()
                                        + "." + getFileExtension(uri));

                                storageTask = fileReference.putFile(uri);

                                Task<Uri> task1 = storageTask.continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
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

                                            databaseReference.child(userID).child("photourl").setValue(miUrlOk);


                                        }
                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(Registeration.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }
                        } else {
                            Toast.makeText(Registeration.this, "Registration unsuccessful", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

        photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFileChooser();
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
            Glide.with(this).load(uri).apply(new RequestOptions().override(300,400)).into(showImage);
            //Picasso.get().load(uri).resize(300,400).into(showImage);
        }
    }

    private String getFileExtension(Uri uri) {
        ContentResolver contentResolver = getContentResolver();
        MimeTypeMap mimeTypeMap = MimeTypeMap.getSingleton();
        return mimeTypeMap.getExtensionFromMimeType(contentResolver.getType(uri));
    }


}
