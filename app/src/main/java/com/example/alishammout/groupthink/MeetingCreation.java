package com.example.alishammout.groupthink;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MeetingCreation extends Activity implements View.OnClickListener{

    private TextView textViewTitle;
    private EditText editTextMeetingName, editTextMeetingTime, editTextLocation;
    private Button buttonAddPeople;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meeting_creation);

        textViewTitle = findViewById(R.id.textViewTitle);
        editTextLocation = findViewById(R.id.editTextLocation);
        editTextMeetingName = findViewById(R.id.editTextMeetingName);
        editTextMeetingTime = findViewById(R.id.editTextMeetingTime);

        buttonAddPeople.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (v == buttonAddPeople) {



            //has to save all entered data before switching
            Intent intent = new Intent(
                    MeetingCreation.this, AddPeople.class);
            startActivity(intent);
        }

    }
}
