package com.example.alishammout.groupthink;

import android.app.Activity;
import android.content.Intent;
import java.util.*;
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
    private FirebaseAuth.AuthStateListener mAuthListener;
    FirebaseDatabase database;
    DatabaseReference myRef;
    private EditText enterUsername, enterPassword;
    private Button loginButton, accountB;

    
//testing Marius commit

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enterUsername = findViewById(R.id.login);
        enterPassword = findViewById(R.id.password);
        loginButton = findViewById(R.id.buttonLogin);
        accountB = findViewById(R.id.accountButton);

        loginButton.setOnClickListener(this);
        accountB.setOnClickListener(this);

        //Authentication functionality initialization
        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    //User is signed in


                } else {
                    //User is signed out


                }

            }

        };
    }

    //Allows for reading information from database
    ValueEventListener postListener = new ValueEventListener() {
        @Override
        //creates snapshot of database for data extraction
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            //conditional on whether passed reference exists to have snapshot taken
            if (dataSnapshot.exists()) {
                //gets value from dataSnapshot from passed reference
                String post = dataSnapshot.getValue(String.class);
                //sets layout widget to the value of the reference
                //example: textViewLookupQuantity.setText(post);

            }
            else {
                Toast.makeText(MainActivity.this, "The reference is invalid", Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    };

    //this method allows for the creation of a user account
    public void createAccount(String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this,
                new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            Toast.makeText(MainActivity.this, "Register Success",
                                    Toast.LENGTH_SHORT).show();
                            // Sign in success, update UI with the signed-in user's information
                        } else {
                            Toast.makeText(MainActivity.this, "Register Failure",
                                    Toast.LENGTH_SHORT).show();
                            // If sign in fails, display a message to the user.
                        }
                    }
                });
    }

    //This method allows for the signing in of a user
    public void signIn(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            //Takes to group page
                            startActivity(new Intent(MainActivity.this, GroupOverview.class));



                        } else {
                            //Sign in was a failure and tells user
                            Toast.makeText(MainActivity.this, "Sign In Failure",
                                    Toast.LENGTH_SHORT).show();


                        }

                    }
                });
    }








    @Override
    public void onClick(View v) {

        String loginS;
        String passwordS;
        passwordS = enterPassword.getText().toString();
        loginS = enterUsername.getText().toString();



        if (v == loginButton) {

            signIn(loginS, passwordS);


        }

        else if (v == accountB) {

            createAccount(loginS, passwordS);
        }

    }
}
