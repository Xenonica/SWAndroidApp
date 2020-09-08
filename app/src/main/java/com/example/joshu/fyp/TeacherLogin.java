package com.example.joshu.fyp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class TeacherLogin extends AppCompatActivity {

    EditText edit_email, edit_password;
    Button login;
    ProgressBar progressBar;
    TextView passwordchange, registeraccount;
    CheckBox rememberaMe;
    private Boolean saveLogin;

    private FirebaseAuth firebaseAuth;

    private SharedPreferences loginPreferences;
    private SharedPreferences.Editor loginPrefsEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_login);

        ConstraintLayout constraintLayout = findViewById(R.id.layout);
        AnimationDrawable animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(1000);
        animationDrawable.setExitFadeDuration(1000);
        animationDrawable.start();

        edit_email = findViewById(R.id.editText_email);
        edit_password = findViewById(R.id.editText_password);
        login = findViewById(R.id.btnLogin);
        passwordchange = findViewById(R.id.txt_changePassword);
        registeraccount = findViewById(R.id.txt_registerAccount);
        progressBar = findViewById(R.id.progressBar);
        rememberaMe = findViewById(R.id.checkBox_rememberMe);

        loginPreferences = getSharedPreferences("loginPrefs", MODE_PRIVATE);
        loginPrefsEditor = loginPreferences.edit();

        saveLogin = loginPreferences.getBoolean("saveLogin", false);
        if (saveLogin == true) {
            edit_email.setText(loginPreferences.getString("username", ""));
            edit_password.setText(loginPreferences.getString("password", ""));
            rememberaMe.setChecked(true);
        }

        progressBar.setVisibility(View.INVISIBLE);

        firebaseAuth = FirebaseAuth.getInstance();

        passwordchange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ChangePassword.class);
                startActivity(intent);
            }
        });

        registeraccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Registeration.class);
                startActivity(intent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    validate(edit_email.getText().toString(), edit_password.getText().toString());
                    if (rememberaMe.isChecked()) {
                        loginPrefsEditor.putBoolean("saveLogin", true);
                        loginPrefsEditor.putString("username", edit_email.getText().toString());
                        loginPrefsEditor.putString("password", edit_password.getText().toString());
                        loginPrefsEditor.commit();
                    } else {
                        loginPrefsEditor.clear();
                        loginPrefsEditor.commit();
                    }
                } catch (Exception e) {

                    toastMessage("Please enter something");
                }


            }
        });
    }

    private void validate(String username, String password) {
        firebaseAuth.signInWithEmailAndPassword(username, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    progressBar.setVisibility(View.VISIBLE);
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            FirebaseUser user = firebaseAuth.getCurrentUser();
                            toastMessage("Welcome " + user.getEmail());
                            Intent home = new Intent(TeacherLogin.this, TeacherContent.class);
                            startActivity(home);
                            finish();
                        }
                    }, 2000);
                } else {
                    toastMessage("Please enter the correct details and check your internet connection");
                }

            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser user = firebaseAuth.getCurrentUser();
        if (user != null) {
            Intent home = new Intent(this, TeacherContent.class);
            startActivity(home);
            finish();
        }
    }


    public void toastMessage(String message)
    {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}



