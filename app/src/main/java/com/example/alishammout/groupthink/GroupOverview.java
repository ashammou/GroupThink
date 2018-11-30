package com.example.alishammout.groupthink;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class GroupOverview extends Activity implements View.OnClickListener {

    private Button buttonAddGroup;
    private UserClass user;
    private RecyclerViewAdapterGroupOverview recyclerViewAdapterGroupOverview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_overview);
        buttonAddGroup = findViewById(R.id.buttonAddGroup);

        buttonAddGroup.setOnClickListener(this);
        initRecyclerView();
        getUser();
    }

    public void getUser() {
        user = new UserClass();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference GroupDisplayRef = database.getReference("UserClass");

        // Read from the database
        GroupDisplayRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot child : dataSnapshot.getChildren()) {

                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
            }
        });

    }

    /*
    private void initGroups() {


        // will be replaced by Firebase code
        ArrayList<String> groupsUser1 = new ArrayList<>();
        groupsUser1.add("TO426");
        groupsUser1.add("TO414");
        user = new UserClass("Marius", "password", groupsUser1);

    }
    */

    private void initRecyclerView () {
        RecyclerView recyclerView = findViewById(R.id.recyclerGroupOverview);
        recyclerViewAdapterGroupOverview = new RecyclerViewAdapterGroupOverview(user, this);
        recyclerView.setAdapter(recyclerViewAdapterGroupOverview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    public void onClick(View v) {
        if (v == buttonAddGroup) {
            startActivity(new Intent(GroupOverview.this, AddGroup.class));
        }
    }
}
