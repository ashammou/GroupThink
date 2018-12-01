package com.example.alishammout.groupthink;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MeetingInformation extends Activity implements View.OnClickListener{

    private EditText locationE, timeE, person1, person2, person3;
    private Button doneButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meeting_information);

        locationE = findViewById(R.id.editText2);
        timeE = findViewById(R.id.editText4);
        person1 = findViewById(R.id.editText5);
        person2 = findViewById(R.id.editText6);
        person3 = findViewById(R.id.editText7);

        doneButton =findViewById(R.id.button3);
        doneButton.setOnClickListener(this);




    }

    @Override
    public void onClick(View v) {

        if (v == doneButton){
            Intent intent = new Intent(MeetingInformation.this, MeetingLayout.class);
            startActivity(intent);
        }
    }
}
