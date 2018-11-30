package com.example.alishammout.groupthink;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.widget.Toast;

import java.util.*;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;




public class UserClass extends Activity  {


        public String usernameL,passwordL;
        public ArrayList<String> groupsInL;

        FirebaseDatabase database;
        DatabaseReference myRef;

        public UserClass()  {

                usernameL = "";
                passwordL = "";
                groupsInL = new ArrayList<>();



        }

        public UserClass (String username,String password,ArrayList<String> groupsIn) {
                usernameL=username;
                passwordL= password;
                groupsInL = new ArrayList<>(groupsIn);

        }


        public String getUsernameL(){

                return usernameL;

        }

        public String getPasswordL(){
                return passwordL;
        }

        public List<String> getGroupsInL() {
                return groupsInL;
        }

        public void setUsername(String username){

                usernameL = username;

        }

        public void setPasswordL(String password){
                passwordL = password;
        }

        public void setGroupsInL(List<String> groupsIn) {
                groupsInL = new ArrayList<>(groupsIn);
        }

        //Allows for reading object of group class information from database
        ValueEventListener userListener = new ValueEventListener() {
                @Override
                //creates snapshot of database for data extraction
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        //conditional on whether passed reference exists to have snapshot taken
                        if (dataSnapshot.exists()) {
                                //gets value from dataSnapshot from passed reference
                               UserClass user = dataSnapshot.getValue(UserClass.class);
                                //sets layout widget to the value of the reference
                                //example: textViewLookupQuantity.setText(post);

                        }
                        else {
                                Toast.makeText(UserClass.this, "Data does not exist",
                                        Toast.LENGTH_SHORT).show();
                        }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
        };








}