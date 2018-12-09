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
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class AgendaCreation extends Activity implements View.OnClickListener{

    private Button buttonAddAgendaItem, donebuttonAC;
    private EditText descriptionACreation, notesACreation, editTextTimeACreation;
    private TextView textViewCreatedMeetingName;
    private AgendaItemsClass agendaItem = new AgendaItemsClass();
    private ArrayList<AgendaItemsClass> wholeAgenda = new ArrayList<>();
    private RecyclerViewAdapterAC recyclerViewAdapterAC;

    //If this is false, the agenda is freshly created and does not need to be updated
    // If true, the RecyclerViewAdapter needs to be updated with already existing Agenda Items
    private Boolean editOrCreate = false;

    private String passedGroup, createdmeeting, agendaTitle, agendaDescription, agendaTime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda_creation);

        buttonAddAgendaItem = findViewById(R.id.buttonAddAgendaItem);
        donebuttonAC = findViewById(R.id.donebuttonAC);
        descriptionACreation = findViewById(R.id.descriptionACreation);
        notesACreation = findViewById(R.id.notesACreation);
        editTextTimeACreation = findViewById(R.id.editTextTimeACreation);
        textViewCreatedMeetingName = findViewById(R.id.textViewCreatedMeetingName);

        buttonAddAgendaItem.setOnClickListener(this);
        donebuttonAC.setOnClickListener(this);

        passedGroup = getIntent().getStringExtra("passed_group");
        createdmeeting = getIntent().getStringExtra("createdMeeting");
        textViewCreatedMeetingName.setText(createdmeeting);

        getAgenda();
        recyclerviewadapter();


    }


    private void getAgenda(){


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference agendaRef = database.getReference().child("AgendaItems");

        agendaRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for(DataSnapshot child: dataSnapshot.getChildren()) {

                    AgendaItemsClass agenda1 = child.getValue(AgendaItemsClass.class);
                    //agendaItem.add(agenda1);


                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });





    }

    private void recyclerviewadapter() {

        RecyclerView recyclerViewAC = findViewById(R.id.recyclerVAC);
        recyclerViewAdapterAC = new RecyclerViewAdapterAC(
                wholeAgenda, this);
        //add adapter and LAYOUT MANAGER
        recyclerViewAC.setAdapter(recyclerViewAdapterAC);
        recyclerViewAC.setLayoutManager(new LinearLayoutManager(this));


    }

    @Override
    public void onClick(View v) {

        if (v == donebuttonAC) {
            startActivity(new Intent(AgendaCreation.this, MeetingCreation.class));
        }

        if (v == buttonAddAgendaItem) {

            agendaTitle = descriptionACreation.getText().toString();
            agendaDescription = notesACreation.getText().toString();
            agendaTime = editTextTimeACreation.getText().toString();
            agendaItem = new AgendaItemsClass(agendaTitle, agendaTime, agendaDescription);
            wholeAgenda.add(agendaItem);
            descriptionACreation.setText("");
            notesACreation.setText("");
            editTextTimeACreation.setText("");
            recyclerviewadapter();
        }

    }
}
