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
    private TextView meetingNameText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meeting_layout);
        currentMeeting = getIntent().getStringExtra("passed_meeting");
        meetingNameText.setText(currentMeeting);

        meetingNameText = findViewById(R.id.meetingNameText);

    }

    @Override
    public void onClick(View view) {

    }
}
