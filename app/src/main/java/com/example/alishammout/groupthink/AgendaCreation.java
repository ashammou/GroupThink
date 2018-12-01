package com.example.alishammout.groupthink;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class AgendaCreation extends Activity implements View.OnClickListener{

    private Button agendaB, donebuttonAC;
    private EditText acedit1, acedit2;
    private ArrayList<AgendaItemsClass> agenda;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda_creation);

        agendaB = findViewById(R.id.agendaB);
        donebuttonAC = findViewById(R.id.donebuttonAC);
        acedit1 = findViewById(R.id.acedit1);
        acedit2 = findViewById(R.id.acedit2);

        agendaB.setOnClickListener(this);
        donebuttonAC.setOnClickListener(this);



    }


    private void initaddagendas(String acedit1, String acedit2) {

        //Receive object data from firebase below are just a text

        agenda.add(new AgendaItemsClass(acedit1, acedit2));

        recyclerviewadapter();
    }

    private void recyclerviewadapter() {

        RecyclerView recyclerViewAC = findViewById(R.id.recyclerVAC);
        RecyclerViewAdapterAC recyclerViewAdapterAC = new RecyclerViewAdapterAC(
                agenda, this);
        //add adapter and LAYOUT MANAGER
        recyclerViewAC.setAdapter(recyclerViewAdapterAC);
        recyclerViewAC.setLayoutManager(new LinearLayoutManager(this));


    }

    @Override
    public void onClick(View v) {

        if (v == donebuttonAC) {
            startActivity(new Intent(AgendaCreation.this, MeetingCreation.class));
        }

        if (v == agendaB) {

            String acedit1local = acedit1.getText().toString();
            String acedit2local = acedit2.getText().toString();
            initaddagendas(acedit1local, acedit2local);

        }

    }
}
