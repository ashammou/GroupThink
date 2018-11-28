package com.example.alishammout.groupthink;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.widget.Toast;

import java.util.*;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

//comment


public class GroupClass extends Activity{

    public List<UserClass> usersinGroupL;
    public List<MeetingClass> meetingsinGroupL;

    FirebaseDatabase database;
    DatabaseReference myRef;

    public GroupClass() {

        usersinGroupL = new ArrayList<>();
        meetingsinGroupL = new ArrayList<>();

    }

    public GroupClass(List<UserClass> usersinGroup, List<MeetingClass> meetingsinGroup) {

        usersinGroupL = new ArrayList<>(usersinGroup);
        meetingsinGroupL = new ArrayList<>(meetingsinGroup);

    }

    public List<UserClass> getUsersinGroup() {
        return usersinGroupL;
    }

    public List <MeetingClass> getMeetingsinGroup() {
        return meetingsinGroupL;
    }

    public void setUsersinGroup(List<UserClass> usersinGroup) {
        usersinGroupL = usersinGroup;
    }

    public void setMeetingsinGroup(List<MeetingClass> meetingsinGroup) {
        meetingsinGroupL = meetingsinGroup;
    }


    //Allows for reading object of group class information from database
    ValueEventListener groupListener = new ValueEventListener() {
        @Override
        //creates snapshot of database for data extraction
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            //conditional on whether passed reference exists to have snapshot taken
            if (dataSnapshot.exists()) {
                //gets value from dataSnapshot from passed reference
                GroupClass group = dataSnapshot.getValue(GroupClass.class);
                //sets layout widget to the value of the reference
                //example: textViewLookupQuantity.setText(post);

            }
            else {
                Toast.makeText(GroupClass.this, "Data does not exist",
                        Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    };






}
