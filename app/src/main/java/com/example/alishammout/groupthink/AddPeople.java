package com.example.alishammout.groupthink;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AddPeople extends Activity implements View.OnClickListener {

    private Button doneButton;
    private Button cancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_people);

        doneButton = findViewById(R.id.doneButton);
        cancelButton = findViewById(R.id.cancelButton);

        doneButton.setOnClickListener(this);
        cancelButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == doneButton) {
            Intent intent = new Intent(AddPeople.this, MeetingSelection.class);
            startActivity(intent);
        }
        else if (view == cancelButton) {
            Intent intent = new Intent(AddPeople.this, GroupOverview.class);
            startActivity(intent);
        }
    }
}
