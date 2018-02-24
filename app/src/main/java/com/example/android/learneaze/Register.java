package com.example.android.learneaze;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
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
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class Register extends AppCompatActivity {

    Button regButton;
    EditText mailText, passText;
    ProgressBar progressBar;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        setTitle( " Sign Up");

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#68caff")));

        if(getSupportActionBar() != null) {

            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        firebaseAuth = FirebaseAuth.getInstance();

        regButton = (Button) findViewById(R.id.butSingUp);

        mailText = (EditText) findViewById(R.id.edit_Email);

        passText = (EditText) findViewById(R.id.edit_pass);

        progressBar = (ProgressBar) findViewById(R.id.progress);

        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = mailText.getText().toString().trim();

                String password = passText.getText().toString().trim();

                //E-mail and Password is not Empty
                if (email.isEmpty()) {
                    mailText.setError("Email is required");
                    mailText.requestFocus();
                    return;
                }

                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    mailText.setError("Please enter a valid email");
                    mailText.requestFocus();
                    return;
                }

                if (password.isEmpty()) {
                    passText.setError("Password is required");
                    passText.requestFocus();
                    return;
                }

                if (password.length() < 6) {
                    passText.setError("Minimum lenght of password should be 6");
                    passText.requestFocus();
                    return;
                }

                // Setting Progress Report.
                progressBar.setVisibility(View.VISIBLE);

                firebaseAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                progressBar.setVisibility(View.GONE);

                                if (task.isSuccessful()) {

                                    Intent j = new Intent(Register.this, Branches.class);
                                    j.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                                    j.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                                    startActivity(j);
                                    finish();
                                }
                                else if (task.getException() instanceof FirebaseAuthUserCollisionException) {
                                        Toast.makeText(getApplicationContext(), "You are already registered", Toast.LENGTH_SHORT).show();
                                    }

                                else{

                                    Toast.makeText(Register.this, "Registration failed, try again ", Toast.LENGTH_SHORT).show();
                                }

                            }

                        });
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
