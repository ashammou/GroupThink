package com.example.alishammout.groupthink;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;

import java.util.ArrayList;

public class AddGroup extends Activity implements View.OnClickListener {

    private EditText addGroup;
    private EditText addPeople;
    private Button addPersonB, doneButton;
    private ArrayList<UserClass> addGUsers;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_group);

        addGroup = findViewById(R.id.addGroupName);
        addPeople = findViewById(R.id.addPeople);

        addPersonB = findViewById(R.id.button2);

        addPersonB.setOnClickListener(this);
        doneButton = findViewById(R.id.doneButton);
        doneButton.setOnClickListener(this);



    }

    private void initaddGUsers(String nameofuser) {

        //the below is an empty string since we should insert the user that the group is in
        ArrayList<String> groupsUserIsIn = new ArrayList<>();
        //Receive object data from firebase below are just a text
        // it should look to the database to find the user based off of username and retrieve object of user class
        addGUsers.add(new UserClass("1234", nameofuser, "bobcat123", groupsUserIsIn ));

        recyclerviewadapter();
    }

    private void recyclerviewadapter() {

        RecyclerView recyclerView = findViewById(R.id.addgRV);
        RecyclerViewAdapterAddGroup recyclerViewAdapterAddGroup = new RecyclerViewAdapterAddGroup(
                addGUsers, this);
        recyclerView.setAdapter(recyclerViewAdapterAddGroup);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    public void onClick(View v) {

        if (v == doneButton) {

            startActivity(new Intent(AddGroup.this, GroupOverview.class));
        }

        else if (v == addPersonB) {


            String addlocaluser = addPeople.getText().toString();
            initaddGUsers(addlocaluser);


        }

    }

}
