package com.example.alishammout.groupthink;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MeetingSelection extends Activity implements View.OnClickListener {

    private Button backButton, buttonAddMeeting;
    private ArrayList<MeetingClass> groupMeetings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meeting_selection);

        backButton = findViewById(R.id.backButton);
        buttonAddMeeting = findViewById(R.id.buttonAddMeeting);

        backButton.setOnClickListener(this);
        buttonAddMeeting.setOnClickListener(this);
        initializeGroupMeetings();
        initializeRecyclerView();
    }

    private void initializeGroupMeetings() {
        groupMeetings = new ArrayList<>();
        ArrayList<AgendaItemsClass> agendaItems = new ArrayList<>();
        ArrayList<UserClass> meetingAttendees = new ArrayList<>();
        groupMeetings.add(new MeetingClass(agendaItems, "startTime", "meetingName", "location"));
    }

    private void initializeRecyclerView() {
        RecyclerView recyclerViewMeetingSelection = findViewById(R.id.meetingRecyclerView);
        RecyclerViewAdapterMeetingSelection recyclerViewAdapterMeetingSelection = new RecyclerViewAdapterMeetingSelection(groupMeetings, this);
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
            startActivity(intent);
        }
    }
}
