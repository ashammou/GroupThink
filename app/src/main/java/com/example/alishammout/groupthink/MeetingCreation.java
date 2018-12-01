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
    private Button buttonAddAgenda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meeting_creation);

        textViewTitle = findViewById(R.id.textViewTitle);
        editTextLocation = findViewById(R.id.editTextLocation);
        editTextMeetingName = findViewById(R.id.editTextMeetingName);
        editTextMeetingTime = findViewById(R.id.editTextMeetingTime);
        buttonAddAgenda = findViewById(R.id.buttonAddAgenda);

        buttonAddAgenda.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (v == buttonAddAgenda) {

            String meetingName = editTextMeetingName.getText().toString();

            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference(meetingName);
            myRef.addListenerForSingleValueEvent(postListener);

        }

    }

    ValueEventListener postListener = new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {

            String meetingName = editTextMeetingName.getText().toString();

            if (dataSnapshot.exists()) {
                //If the dataSnapshot already exists, the meeting should be edited, not created
                // Show message to stop user
                Toast.makeText(MeetingCreation.this, "This meeting already exists. Please go to \"edit\" or choose other meeting name.",
                        Toast.LENGTH_SHORT).show();

            } else {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference(meetingName);

                //This is where firebase item is updated.
                //has to save all entered data before switching
                Intent intent = new Intent(
                        MeetingCreation.this, AgendaCreation.class);
                startActivity(intent);
            }

        }

        @Override
        public void onCancelled(DatabaseError databaseError) {
            // Getting Post failed, log a message
            //Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
            // ...
        }
    };
}
