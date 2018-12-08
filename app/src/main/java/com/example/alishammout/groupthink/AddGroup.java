package com.example.alishammout.groupthink;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class   AddGroup extends Activity implements View.OnClickListener {

    private EditText addGroup, addPeopletoGroup;
    private Button addPersonB, buttonAddGroup;
    public GroupClass currentGroup = new GroupClass();
    private String groupName = "";
    public ArrayList<String> usersArray = new ArrayList<>();
    private String addedUser = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_group);

        addGroup = findViewById(R.id.addGroupName);
        addPeopletoGroup = findViewById(R.id.addPeopletoGroup);

        addPersonB = findViewById(R.id.button2);

        addPersonB.setOnClickListener(this);
        buttonAddGroup = findViewById(R.id.doneButton);
        buttonAddGroup.setOnClickListener(this);


    }

    private void recyclerviewadapter() {

        RecyclerView recyclerView = findViewById(R.id.addgRV);
        RecyclerViewAdapterAddGroup recyclerViewAdapterAddGroup = new RecyclerViewAdapterAddGroup(
                usersArray, this);
        recyclerView.setAdapter(recyclerViewAdapterAddGroup);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    public void onClick(View v) {

        groupName = addGroup.getText().toString();

        if (v == buttonAddGroup) {

            if (groupName.equals("") ) {

                Toast.makeText(AddGroup.this, "Please enter a group name",
                        Toast.LENGTH_SHORT).show();
            } else {
                currentGroup.setGroupname(groupName);
                currentGroup.setUsersInGroup(usersArray);


                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference(groupName);
                currentGroup.setGroupname(groupName);

                myRef.setValue(currentGroup);
            }

            currentGroup = new GroupClass();
        }

        else if (v == addPersonB) {

            addedUser = addPeopletoGroup.getText().toString();
            usersArray.add(addedUser);
            recyclerviewadapter();
            addPeopletoGroup.setText("");
        }

    }
}
