package com.example.alishammout.groupthink;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class GroupOverview extends Activity implements View.OnClickListener {

    private Button buttonAddGroup, button;
    private UserClass user;
    private ArrayList<String> groupsForUser = new ArrayList<>();
    private FirebaseAuth mauth;
    private RecyclerViewAdapterGroupOverview recyclerViewAdapterGroupOverview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_overview);
        buttonAddGroup = findViewById(R.id.buttonAddGroup);
        mauth = FirebaseAuth.getInstance();


        buttonAddGroup.setOnClickListener(this);

        button = findViewById(R.id.button);
        button.setOnClickListener(this);


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();



        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                int num = 0;
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    for (DataSnapshot snapshot2 : snapshot.child("usersInGroup").getChildren()) {
                        String myUser = snapshot2.getValue(String.class);
                        //Toast.makeText(GroupOverview.this, "myUser: " + myUser, Toast.LENGTH_SHORT).show();
                        if (mauth.getCurrentUser().getEmail().equals(myUser)) {
                            num += 1;
                            groupsForUser.add(snapshot.getKey());
                            //Toast.makeText(GroupOverview.this, snapshot.getKey(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }
                Toast.makeText(GroupOverview.this, "Num: " + String.valueOf(num), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }

        });

    }


    private void initRecyclerView () {
        RecyclerView recyclerView = findViewById(R.id.recyclerGroupOverview);
        recyclerViewAdapterGroupOverview = new RecyclerViewAdapterGroupOverview(groupsForUser, this);
        recyclerView.setAdapter(recyclerViewAdapterGroupOverview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    public void onClick(View v) {
        if (v == buttonAddGroup) {

            startActivity(new Intent(GroupOverview.this, AddGroup.class));
        }

        if (v == button) {
            initRecyclerView();
        }
    }
}
