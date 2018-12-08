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


public class GroupClass {

    public ArrayList<String> usersInGroup;
    public String groupname;

    public GroupClass(ArrayList<String> usersInGroup, String groupname) {
        this.usersInGroup = usersInGroup;
        this.groupname = groupname;
    }

    public GroupClass() {
    }

    public ArrayList<String> getUsersInGroup() {
        return usersInGroup;
    }

    public void setUsersInGroup(ArrayList<String> usersInGroup) {
        this.usersInGroup = usersInGroup;
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }
}
