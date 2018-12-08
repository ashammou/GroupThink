package com.example.alishammout.groupthink;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MeetingCreation extends Activity implements View.OnClickListener{

    private TextView textViewTitle;
    private EditText editTextMeetingName, editTextMeetingTime, editTextLocation;
    public MeetingClass createMeeting = new MeetingClass();
    private String passedGroup, meetingname, meetingtime, meetinglocation;
    private Button buttonAddAgenda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meeting_creation);
        passedGroup = getIntent().getStringExtra("passed_group1");

        textViewTitle = findViewById(R.id.textViewTitle);
        editTextLocation = findViewById(R.id.editTextLocation);
        editTextMeetingName = findViewById(R.id.editTextMeetingName);
        editTextMeetingTime = findViewById(R.id.editTextMeetingTime);
        buttonAddAgenda = findViewById(R.id.buttonAddMeeting);

        buttonAddAgenda.setOnClickListener(this);

        Toast.makeText(MeetingCreation.this, passedGroup, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onClick(View v) {

        if (v == buttonAddAgenda) {

            meetingname = editTextMeetingName.getText().toString();
            meetingtime = editTextMeetingTime.getText().toString();
            meetinglocation= editTextLocation.getText().toString();
            createMeeting = new MeetingClass(meetingtime, meetingname, meetinglocation);

            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference(passedGroup);
            myRef.child("meetings").child(meetingname).setValue(createMeeting);

        }

    }
}
