package com.example.alishammout.groupthink;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MeetingLayout extends Activity implements View.OnClickListener {

    private Button backButton;
    private Button imageButtonAgenda;
    private Button editButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meeting_layout);

        backButton = findViewById(R.id.backButton);

        backButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == backButton) {
            Intent intent  = new Intent(MeetingLayout.this, MeetingSelection.class);
            startActivity(intent);
        }

        if (view == imageButtonAgenda) {
            Intent intent2  = new Intent(MeetingLayout.this, MeetingInformation.class);
            startActivity(intent2);
        }
    }
}
