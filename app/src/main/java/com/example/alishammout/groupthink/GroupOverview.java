package com.example.alishammout.groupthink;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_overview);
        buttonAddGroup = findViewById(R.id.buttonAddGroup);


        buttonAddGroup.setOnClickListener(this);
        initGroups();


        //getUser();
    }


    public void getUser() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();

        //Here is where the data comes from Firebase
        DatabaseReference GroupDisplayRef = database.getReference("Group");

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

    // will be replaced by Firebase code
    private void initGroups() {
        ArrayList<String> groupsUser1 = new ArrayList<>();
        groupsUser1.add("TO426");
        groupsUser1.add("TO414");
        user = new UserClass("1223333","Marius", "password", groupsUser1);
        initRecyclerView();

    }


    private void initRecyclerView () {
        RecyclerView recyclerView = findViewById(R.id.recyclerGroupOverview);
        RecyclerViewAdapterGroupOverview recyclerViewAdapterGroupOverview = new RecyclerViewAdapterGroupOverview(user, this);
        recyclerView.setAdapter(recyclerViewAdapterGroupOverview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    public void onClick(View v) {
        if (v == buttonAddGroup) {

            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference();

            ArrayList<String> dummy = new ArrayList<>();
            MeetingClass dummymeeting = new MeetingClass("12:00", "name", "location" );
            ArrayList<AgendaItemsClass>agenda = new ArrayList<>();
            AgendaItemsClass dummyagenda = new AgendaItemsClass("notesl", "descriptionl");
            AgendaItemsClass dummyagenda2 = new AgendaItemsClass("notes2", "description2");
            AgendaItemsClass dummyagenda3 = new AgendaItemsClass("notes3", "description3");
            agenda.add(dummyagenda);
            agenda.add(dummyagenda2);
            agenda.add(dummyagenda3);




            String groupname = "TO426";
            String meetingname = "MeetingNow";
            String agendaname = "Agenda For Meeting";

            dummy.add("bob1@bob.com");
            dummy.add("bob2@bob.com");
            dummy.add("bob3@bob.com");

            myRef.child("Groups").setValue(new GroupClass(dummy, groupname));
            myRef.child("Groups").child(groupname).setValue(dummymeeting);
            myRef.child("Groups").child(groupname).child(meetingname).child(agendaname).setValue(agenda);




            startActivity(new Intent(GroupOverview.this, MainActivity.class));
        }
    }
}
