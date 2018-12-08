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


    public MeetingClass(){

    }

    public MeetingClass(String starttime, String nameL, String location) {

        this.nameL = nameL;
        this.starttimeL = starttime;
        this.locationL = location;

    }


    public String getStarttimeL(){
        return starttimeL;

    }

    public String getLocationL() {
        return locationL;
    }



    public void setStarttimeL(String starttime){
        starttimeL = starttime;

    }

    public void setLocationL(String location) {
        locationL = location;

    }


}
