package com.example.alishammout.groupthink;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MeetingSelection extends Activity implements View.OnClickListener {

    private TextView groupNameText;

    private Button buttonAddMeeting;
    private ArrayList<String> meetingsIngroup= new ArrayList<>();
    private String passedGroup;
    private RecyclerViewAdapterMeetingSelection recyclerViewAdapterMeetingSelection;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meeting_selection);
        groupNameText = findViewById(R.id.groupNameText);
        passedGroup = getIntent().getStringExtra("passed_group");
        groupNameText.setText(passedGroup);

        buttonAddMeeting = findViewById(R.id.AddMeeting);
        buttonAddMeeting.setOnClickListener(this);

        getMeetings();
        initializeRecyclerView();

    }

    public void getMeetings () {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference(passedGroup).child("meetings");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren()) {

                    meetingsIngroup.add(dataSnapshot1.getKey());
                }
                recyclerViewAdapterMeetingSelection.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
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
                Intent intent1 = new Intent(MeetingSelection.this, GroupOverview.class);
                startActivity(intent1);
                return true;
            case R.id.menuitemLogout:
                Intent intent2 = new Intent(MeetingSelection.this, MainActivity.class);
                FirebaseAuth.getInstance().signOut();
                startActivity(intent2);
                return true;

            default:
                return false;
        }
    }


    private void initializeRecyclerView() {
        RecyclerView recyclerViewMeetingSelection = findViewById(R.id.meetingRecyclerView);
        recyclerViewAdapterMeetingSelection = new RecyclerViewAdapterMeetingSelection(passedGroup ,meetingsIngroup, this);
        recyclerViewMeetingSelection.setAdapter(recyclerViewAdapterMeetingSelection);
        recyclerViewMeetingSelection.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onClick(View view) {

        if (view == buttonAddMeeting) {
            Intent intent  = new Intent(MeetingSelection.this, MeetingCreation.class);
            intent.putExtra("passed_group1", passedGroup);
            startActivity(intent);
        }

    }
}
