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


public class AgendaItemsClass {

    public String descriptionL, timeL, notesL, speakerL;

    FirebaseDatabase database;
    DatabaseReference myRef;

    public AgendaItemsClass() {



    }

    public AgendaItemsClass(String description, String notes) {

        this.descriptionL = description;

        this.notesL = notes;



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



}
