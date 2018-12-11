package com.example.alishammout.groupthink;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

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
        buttonAddAgenda = findViewById(R.id.AddMeeting);

        buttonAddAgenda.setOnClickListener(this);


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
                Intent intent1 = new Intent(MeetingCreation.this, GroupOverview.class);
                startActivity(intent1);
            case R.id.menuitemLogout:
                Intent intent2 = new Intent(MeetingCreation.this, MainActivity.class);
                FirebaseAuth.getInstance().signOut();
                startActivity(intent2);
                return true;

            default:
                return false;
        }
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

            Intent intent = new Intent(MeetingCreation.this, AgendaCreation.class);
            intent.putExtra("createdMeeting", meetingname);
            intent.putExtra("passed_group", passedGroup);
            startActivity(intent);

        }

    }
}
