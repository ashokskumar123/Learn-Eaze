package com.example.android.learneaze;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LogIn extends AppCompatActivity {

    Button signup, login;

    EditText username, password;

    FirebaseAuth mauth;

    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        username = (EditText) findViewById(R.id.login_user);

        password = (EditText) findViewById(R.id.login_pass);

        signup = (Button) findViewById(R.id.button_signup);

        login = (Button) findViewById(R.id.button_login);

        progressBar =(ProgressBar) findViewById(R.id.progress);

        mauth = FirebaseAuth.getInstance();

        setTitle(" Sign Up");

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#68caff")));

        if (getSupportActionBar() != null) {

            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(LogIn.this, Register.class);
                startActivity(i);

            }


        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                userlogin();
            }


        });

    }

     public void userlogin() {

        String log_email = username.getText().toString().trim();

        String log_pass = password.getText().toString().trim();

         //E-mail and Password is not Empty
         if (log_email.isEmpty()) {
             username.setError("Email is required");
             username.requestFocus();
             return;
         }

         if (!Patterns.EMAIL_ADDRESS.matcher(log_email).matches()) {
             username.setError("Please enter a valid email");
             username.requestFocus();
             return;
         }

         if (log_pass.isEmpty()) {
             password.setError("Password is required");
             password.requestFocus();
             return;
         }

         if (log_pass.length() < 6) {
             password.setError("Minimum lenght of password should be 6");
             password.requestFocus();
             return;
         }

         // Setting Progress Report.
         progressBar.setVisibility(View.VISIBLE);

        mauth.signInWithEmailAndPassword(log_email,log_pass)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        progressBar.setVisibility(View.GONE);

                        if (task.isSuccessful()) {
                            Intent j = new Intent(LogIn.this, Branches.class);
                            j.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                            j.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                            startActivity(j);
                            finish();

                        } else {

                            Toast.makeText(getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
     }






    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);

    }
}
