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


public class AgendaItemsClass extends Activity{

    public String descriptionL, timeL, notesL, speakerL;

    FirebaseDatabase database;
    DatabaseReference myRef;

    public AgendaItemsClass() {


    }

    public AgendaItemsClass(String description, String notes) {

        descriptionL = description;

        notesL = notes;



    }

    public String getDescriptionL(){

        return descriptionL;

    }



    public String getNotesL(){
        return notesL;
    }


    public void setDescriptionL(String description) {
        descriptionL = description;


    }


    public void setNotesL(String notes) {
        notesL = notes;
    }


    //Allows for reading object of Agenda items class information from database
    ValueEventListener agendaListener = new ValueEventListener() {
        @Override
        //creates snapshot of database for data extraction
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            //conditional on whether passed reference exists to have snapshot taken
            if (dataSnapshot.exists()) {
                //gets value from dataSnapshot from passed reference
                AgendaItemsClass agenda = dataSnapshot.getValue(AgendaItemsClass.class);
                //sets layout widget to the value of the reference
                //example: textViewLookupQuantity.setText(post);

            }
            else {
                Toast.makeText(AgendaItemsClass.this, "Data does not exist",
                        Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    };


}
