package com.example.alishammout.groupthink;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MeetingSelection extends Activity implements View.OnClickListener {

    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meeting_selection);

        backButton = findViewById(R.id.backButton);

        backButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == backButton) {
            Intent intent  = new Intent(MeetingSelection.this, GroupOverview.class);
            startActivity(intent);
        }
    }
}
