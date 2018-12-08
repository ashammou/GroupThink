package com.example.alishammout.groupthink;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MeetingSelection extends Activity implements View.OnClickListener {

    private Button backButton, buttonAddMeeting, buttonMM;
    private ArrayList<String> meetingsIngroup= new ArrayList<>();
    private String passedGroup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meeting_selection);
        passedGroup = getIntent().getStringExtra("passed_group");

        Toast.makeText(this, passedGroup, Toast.LENGTH_SHORT).show();

        backButton = findViewById(R.id.backButton);
        buttonAddMeeting = findViewById(R.id.buttonAddMeeting);

        backButton.setOnClickListener(this);
        buttonAddMeeting.setOnClickListener(this);

        buttonMM = findViewById(R.id.buttonMM);
        buttonMM.setOnClickListener(this);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference(passedGroup).child("meetings");

        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren()) {

                    meetingsIngroup.add(dataSnapshot1.getKey());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }


    private void initializeRecyclerView() {
        RecyclerView recyclerViewMeetingSelection = findViewById(R.id.meetingRecyclerView);
        RecyclerViewAdapterMeetingSelection recyclerViewAdapterMeetingSelection = new RecyclerViewAdapterMeetingSelection(meetingsIngroup, this);
        recyclerViewMeetingSelection.setAdapter(recyclerViewAdapterMeetingSelection);
        recyclerViewMeetingSelection.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onClick(View view) {
        if (view == backButton) {
            Intent intent  = new Intent(MeetingSelection.this, GroupOverview.class);
            startActivity(intent);
        }
        
        if (view == buttonAddMeeting) {
            Intent intent  = new Intent(MeetingSelection.this, MeetingCreation.class);
            intent.putExtra("passed_group1", passedGroup);
            startActivity(intent);
        }

        if (view == buttonMM) {
            initializeRecyclerView();
        }
    }
}
