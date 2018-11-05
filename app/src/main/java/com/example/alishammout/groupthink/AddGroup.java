package com.example.alishammout.groupthink;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;

public class AddGroup extends Activity implements View.OnClickListener {

    private EditText addGroup;
    private EditText addPeople;

    private EditText person1;
    private EditText person2;
    private EditText person3;

    private Button addPersonB;
    private ScrollView scrollBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_group);

        addGroup = findViewById(R.id.addGroupName);
        addPeople = findViewById(R.id.addPeople);
        person1 = findViewById(R.id.addedPerson1);
        person2 = findViewById(R.id.addedPerson2);
        person3 = findViewById(R.id.addedPerson3);

        addPersonB = findViewById(R.id.button2);
        scrollBar = findViewById(R.id.scrollPeopleAdded);

        addPersonB.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {

    }
}
