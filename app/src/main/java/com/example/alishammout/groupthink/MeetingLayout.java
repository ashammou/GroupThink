package com.example.alishammout.groupthink;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MeetingLayout extends Activity implements View.OnClickListener {

    private String currentMeeting, passedGroup;
    private TextView meetingNameText, textViewTTime, textViewTLocation,
            textViewTMembers, textViewShowTime,textViewShowLoction, textViewShowMember;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meeting_layout);
        currentMeeting = getIntent().getStringExtra("passed_meeting");

        // right now we cannot pass the group because this activity is started from a recycler view adapter (RCV)
        // the RCV does not store the current group and therefore we cannot read and save it for the intent
        //passedGroup = getIntent().getStringExtra("passed_group");

        meetingNameText = findViewById(R.id.meetingNameText);
        textViewTTime = findViewById(R.id.textViewTTime);
        textViewTLocation = findViewById(R.id.textViewTLocation);
        textViewTMembers = findViewById(R.id.textViewTMembers);
        textViewShowTime = findViewById(R.id.textViewShowTime);
        textViewShowLoction = findViewById(R.id.textViewShowLoction);
        textViewShowMember = findViewById(R.id.textViewShowMember);
        meetingNameText.setText(currentMeeting);
    }

    @Override
    public void onClick(View view) {

    }
}
