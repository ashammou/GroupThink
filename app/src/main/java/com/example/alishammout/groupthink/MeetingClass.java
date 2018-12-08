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


public class MeetingClass {

    public String starttimeL, locationL, nameL;
    public List<AgendaItemsClass> agendaL = new ArrayList<>();

    FirebaseDatabase database;
    DatabaseReference myRef;


    public MeetingClass(){



    }

    public MeetingClass(List<AgendaItemsClass> agenda, String starttime, String nameL, String location) {

        this.nameL = nameL;
        this.agendaL = agenda;
        this.starttimeL = starttime;
        this.locationL = location;

        this.agendaL = new ArrayList<>(agenda);



    }


    public String getStarttimeL(){
        return starttimeL;

    }

    public String getLocationL() {
        return locationL;
    }

    public List<AgendaItemsClass> getAgendaL(){
        return agendaL;
    }




    public void setStarttimeL(String starttime){
        starttimeL = starttime;

    }

    public void setLocationL(String location) {
        locationL = location;

    }

    public void setAgendaL(List<AgendaItemsClass> agenda) {
        agendaL = new ArrayList<>(agenda);
    }



    //Allows for reading object of group class information from database
    ValueEventListener meetingListener = new ValueEventListener() {
        @Override
        //creates snapshot of database for data extraction
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            //conditional on whether passed reference exists to have snapshot taken
            if (dataSnapshot.exists()) {
                //gets value from dataSnapshot from passed reference
                MeetingClass meeting = dataSnapshot.getValue(MeetingClass.class);
                //sets layout widget to the value of the reference
                //example: textViewLookupQuantity.setText(post);

            }
            else {

            }
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    };




}
