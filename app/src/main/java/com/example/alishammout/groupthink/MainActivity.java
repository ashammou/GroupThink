package com.example.alishammout.groupthink;

import android.app.Activity;
import android.content.Intent;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends Activity implements View.OnClickListener{

    private FirebaseAuth mAuth;
    private EditText enterUsername, enterPassword;
    private Button loginButton, accountB;
    private String UserID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();

        enterUsername = findViewById(R.id.login);
        enterPassword = findViewById(R.id.password);
        loginButton = findViewById(R.id.buttonLogin);
        accountB = findViewById(R.id.accountButton);

        loginButton.setOnClickListener(this);
        accountB.setOnClickListener(this);
    }

    //method for checking valid email format
    public static boolean isEmailValid (String email) {
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    //method for creating new account
    public void createAccount(final String email, final String password) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(MainActivity.this,
                                    "Registration successful.", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(
                                    MainActivity.this, GroupOverview.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(MainActivity.this,
                                    "ERROR: This email already exits",
                                    Toast.LENGTH_SHORT).show();
                        }

                        // ...
                    }
                });
    }

    //method for signing in
    public void signIn(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Intent intent = new Intent(
                                    MainActivity.this, MeetingLayout.class);
                            Toast.makeText(MainActivity.this,
                                    "Login successful",
                                    Toast.LENGTH_SHORT).show();
                            startActivity(intent);
                        } else {
                            Toast.makeText(MainActivity.this,
                                    "ERROR: Make sure you are registered and email and password are correct",
                                    Toast.LENGTH_SHORT).show();
                        }

                    }
                });
    }

    @Override
    public void onClick(View v) {

        String password = enterPassword.getText().toString();
        String email = enterUsername.getText().toString();

        if (v == accountB) {

            //Check for right email format
            if (isEmailValid(email)) {
                if (password.length() >= 6) {

                    //What to do if both email and password are ok
                    createAccount(email, password);
                } else {

                    //What to do if password doesn't fit
                    Toast.makeText(this, "ERROR: Password must have at least 6 characters", Toast.LENGTH_SHORT).show();
                }
            } else {

                //What to do if email doesn't have the right format
                Toast.makeText(this, "ERROR: Invalid email format", Toast.LENGTH_SHORT).show();
            }
        }

        if (v == loginButton) {

            //Check for right email format
            if (isEmailValid(email)) {
                if (password.length() >= 6) {

                    //What to do if both email and password are ok
                    signIn(email, password);

                } else {

                    //What to do if password doesn't fit
                    Toast.makeText(this, "ERROR: Password must have at least 6 characters", Toast.LENGTH_SHORT).show();
                }
            } else {

                //What to do if email doesn't have the right format
                Toast.makeText(this, "ERROR: Invalid email format", Toast.LENGTH_SHORT).show();

            }
        }

    }
}
