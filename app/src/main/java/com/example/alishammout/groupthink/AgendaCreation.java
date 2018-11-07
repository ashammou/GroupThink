package com.example.alishammout.groupthink;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AgendaCreation extends Activity implements View.OnClickListener{

    private Button agendaB;
    private EditText newTopic1, newTopic2, newTopic3;
    private EditText newTime1, newTime2, newTime3;
    private EditText newTopicNotes1, newTopicNotes2, newTopicNotes3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda_creation);

        agendaB = findViewById(R.id.agendaB);

        newTopic1 = findViewById(R.id.newTopic1);
        newTopic2 = findViewById(R.id.newTopic2);
        newTopic3 = findViewById(R.id.newTopic3);

        newTopicNotes1 = findViewById(R.id.newTopicNotes1);
        newTopicNotes2 = findViewById(R.id.newTopicNotes2);
        newTopicNotes3 = findViewById(R.id.newTopicNotes3);



        agendaB.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {

    }
}
