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
    private ArrayList<AgendaItemsClass> agenda;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda_creation);

        agendaB = findViewById(R.id.agendaB);
        donebuttonAC = findViewById(R.id.donebuttonAC);

        agendaB.setOnClickListener(this);
        donebuttonAC.setOnClickListener(this);



    }


    private void initaddGUsers() {

        //Receive object data from firebase below are just a text

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

    }
}
