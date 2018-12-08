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

    public String descriptionL, timeL, notesL;

    public AgendaItemsClass(String descriptionL, String timeL, String notesL) {
        this.descriptionL = descriptionL;
        this.timeL = timeL;
        this.notesL = notesL;
    }

    public AgendaItemsClass() {
    }

    public String getDescriptionL() {
        return descriptionL;
    }

    public void setDescriptionL(String descriptionL) {
        this.descriptionL = descriptionL;
    }

    public String getTimeL() {
        return timeL;
    }

    public void setTimeL(String timeL) {
        this.timeL = timeL;
    }

    public String getNotesL() {
        return notesL;
    }

    public void setNotesL(String notesL) {
        this.notesL = notesL;
    }
}