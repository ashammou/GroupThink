package com.example.alishammout.groupthink;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MeetingLayout extends Activity implements View.OnClickListener {

    private String currentMeeting, currentGroup;
    private TextView meetingNameText, textViewTTime, textViewTLocation,
            textViewTMembers, textViewShowTime,textViewShowLoction, textViewShowMember;
    private RecyclerViewAdapterMeetingLayout recyclerViewAdapterMeetingLayout;
    private ArrayList<AgendaItemsClass> wholeAgenda = new ArrayList<>();
    private DatabaseReference parentRef;
    private Button buttonTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meeting_layout);
        currentMeeting = getIntent().getStringExtra("passed_meeting");
        buttonTest = findViewById(R.id.buttonTest);
        buttonTest.setOnClickListener(this);

        // right now we cannot pass the group because this activity is started from a recycler view adapter (RCV)
        // the RCV does not store the current group and therefore we cannot read and save it for the intent
        // passedGroup = getIntent().getStringExtra("passed_group");
        // FIX: find group key that matches this meeting name (unique)
        // We need the group name to address as a reference when updating the RCV with the Agenda items for that meeting
        //The line of code below is just an easy fix to see if the rest works:
        // in this case, "passed_group" is hardcoded as "TO429" (in RCV meeting selection)
        currentGroup = getIntent().getStringExtra("passed_group");


        meetingNameText = findViewById(R.id.meetingNameText);
        textViewTTime = findViewById(R.id.textViewTTime);
        textViewTLocation = findViewById(R.id.textViewTLocation);
        textViewTMembers = findViewById(R.id.textViewTMembers);
        textViewShowTime = findViewById(R.id.textViewShowTime);
        textViewShowLoction = findViewById(R.id.textViewShowLoction);
        textViewShowMember = findViewById(R.id.textViewShowMember);
        meetingNameText.setText(currentMeeting);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();

        /*
        myRef.child("meetings").equalTo(currentMeeting).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                DatabaseReference ref = ;
                DatabaseReference parentRef = ref.getParent();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        */
        getAgenda();
        initRecyclerView ();
    }

    private void getAgenda() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference(currentGroup);
        myRef.child("meetings").child(currentMeeting).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for(DataSnapshot child : dataSnapshot.getChildren()) {
                    AgendaItemsClass agendaItem = child.getValue(AgendaItemsClass.class);
                    wholeAgenda.add(agendaItem);
                }
                recyclerViewAdapterMeetingLayout.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void initRecyclerView () {
        RecyclerView recyclerView = findViewById(R.id.recyclerViewMeetingLayout);
        recyclerViewAdapterMeetingLayout = new RecyclerViewAdapterMeetingLayout(wholeAgenda, this);
        recyclerView.setAdapter(recyclerViewAdapterMeetingLayout);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater optionsMenuInflater = getMenuInflater();
        optionsMenuInflater.inflate(R.menu.dropdown_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuitemGroupSelection:
                Intent intent1 = new Intent(MeetingLayout.this, GroupOverview.class);
                startActivity(intent1);
                return true;
            case R.id.menuitemLogout:
                Intent intent2 = new Intent(MeetingLayout.this, MainActivity.class);
                FirebaseAuth.getInstance().signOut();
                startActivity(intent2);
                return true;

            default:
                return false;
        }
    }

    @Override
    public void onClick(View view) {

        if (view == buttonTest) {
            getAgenda();
        }

    }
}
