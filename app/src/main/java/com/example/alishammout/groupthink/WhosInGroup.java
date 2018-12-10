package com.example.alishammout.groupthink;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class WhosInGroup extends Activity implements View.OnClickListener{

    private String currentgroup;
    private EditText whoaddpeople;
    private Button whoaddPerson, whoisindone;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    private ArrayList<String> listofusers = new ArrayList<>();
    private RecyclerViewAdapterWIG recyclerViewAdapterWIG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whos_in_group);

        whoaddpeople = findViewById(R.id.whoaddPeople);
        whoaddPerson = findViewById(R.id.whoaddperson);
        whoisindone = findViewById(R.id.gobackdone);
        whoisindone.setOnClickListener(this);
        whoaddPerson.setOnClickListener(this);
        currentgroup = getIntent().getStringExtra("groupnameMT");

        DatabaseReference myRef = database.getReference();

        myRef.child(currentgroup).child("usersInGroup").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren()) {

                    String localuser = dataSnapshot1.getKey();
                    listofusers.add(localuser);

                }



            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }

        });


        initializeRecyclerView();

    }

    private void initializeRecyclerView() {
        RecyclerView recylerviewwhoisin = findViewById(R.id.recyclerviewWhosIn);
        recyclerViewAdapterWIG = new RecyclerViewAdapterWIG(listofusers, this);
        recylerviewwhoisin.setAdapter(recyclerViewAdapterWIG);
        recylerviewwhoisin.setLayoutManager(new LinearLayoutManager(this));

    }





    @Override
    public void onClick(View v) {

        if(v == whoaddPerson) {

            String localuser = whoaddpeople.getText().toString();
            listofusers.add(localuser);
            DatabaseReference addRef = database.getReference();

            addRef.child(currentgroup).child("usersInGroup").setValue(listofusers);

            initializeRecyclerView();


        }

        else if(v == whoisindone) {

            Intent intent = new Intent(WhosInGroup.this, MeetingLayout.class);
            startActivity(intent);

        }

    }
}
