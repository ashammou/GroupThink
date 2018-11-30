package com.example.alishammout.groupthink;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;


public class GroupOverview extends Activity implements View.OnClickListener {

    private Button buttonAddGroup;
    private UserClass user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_overview);
        buttonAddGroup = findViewById(R.id.buttonAddGroup);

        buttonAddGroup.setOnClickListener(this);

        //manually displaying several groups without firebase connection
        initGroups();
    }

    private void initGroups() {
        //will be replaced by Firebase code
        ArrayList<String> groupsUser1 = new ArrayList<>();
        groupsUser1.add("TO426");
        groupsUser1.add("TO414");
        user = new UserClass("Marius", "password", groupsUser1);
    }

    private void initRecyclerView () {
        RecyclerView recyclerView = findViewById(R.id.recyclerGroupOverview);
        RecyclerViewAdapterGroupOverview recyclerViewAdapterGroupOverview =
                new RecyclerViewAdapterGroupOverview(user, this);
        recyclerView.setAdapter(recyclerViewAdapterGroupOverview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    public void onClick(View v) {
        if (v == buttonAddGroup) {
            startActivity(new Intent(GroupOverview.this, AddGroup.class));
        }
    }
}
