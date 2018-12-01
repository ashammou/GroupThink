package com.example.alishammout.groupthink;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class AddPeople extends Activity implements View.OnClickListener {

    private Button doneButton;
    private Button cancelButton;
    private ArrayList<UserClass> groupMembers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_people);

        doneButton = findViewById(R.id.doneButton);
        cancelButton = findViewById(R.id.cancelButton);

        doneButton.setOnClickListener(this);
        cancelButton.setOnClickListener(this);
    }

    private void initializeGroupMembers() {
        groupMembers = new ArrayList<>();
        ArrayList<String> groupsUserIsIn = new ArrayList<>();
        groupMembers.add(new UserClass("test","SampleUsername", "SamplePassword", groupsUserIsIn));
    }

    private void initRecyclerView() {
        RecyclerView recyclerViewAddPeople = findViewById(R.id.recyclerAddPeople);
        RecyclerViewAdapterAddPeople recyclerViewAdapterAddPeople = new RecyclerViewAdapterAddPeople(groupMembers, this);
        recyclerViewAddPeople.setAdapter(recyclerViewAdapterAddPeople);
        recyclerViewAddPeople.setLayoutManager(new LinearLayoutManager(this));

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
