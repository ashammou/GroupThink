package com.example.alishammout.groupthink;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AgendaCreation extends Activity implements View.OnClickListener{

    private Button buttonAddAgendaItem, donebuttonAC;
    private EditText editTextTimeACreation, editTextItemTitle, editTextNotes;
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
        editTextItemTitle = findViewById(R.id.editTextItemTitle);
        editTextNotes = findViewById(R.id.editTextNotes);
        editTextTimeACreation = findViewById(R.id.editTextTime2);
        textViewCreatedMeetingName = findViewById(R.id.textViewCreatedMeetingName);

        buttonAddAgendaItem.setOnClickListener(this);
        donebuttonAC.setOnClickListener(this);

        passedGroup = getIntent().getStringExtra("passed_group");
        createdmeeting = getIntent().getStringExtra("createdMeeting");
        textViewCreatedMeetingName.setText(createdmeeting);

        //getAgenda();
        recyclerviewadapter();
    }

    private void recyclerviewadapter() {
        RecyclerView recyclerViewAC = findViewById(R.id.recyclerVAC);
        recyclerViewAdapterAC = new RecyclerViewAdapterAC(
                wholeAgenda, this);
        //add adapter and LAYOUT MANAGER
        recyclerViewAC.setAdapter(recyclerViewAdapterAC);
        recyclerViewAC.setLayoutManager(new LinearLayoutManager(this));
    }

    //method for checking valid time format
    public static boolean isValidTime (String time) {
        String tester = "[0-9]{2}+:+[0-9]{2}";
        Pattern pattern = Pattern.compile(tester, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(time);
        return matcher.matches();
    }

    public void resetText () {
        editTextItemTitle.setText("");
        editTextNotes.setText("");
        editTextTimeACreation.setText("");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater optionsMenuInflater = getMenuInflater();
        optionsMenuInflater.inflate(R.menu.dropdown_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuitemGroupSelection:
                Intent intent1 = new Intent(AgendaCreation.this, GroupOverview.class);
                startActivity(intent1);
            case R.id.menuitemLogout:
                Intent intent2 = new Intent(AgendaCreation.this, MainActivity.class);
                FirebaseAuth.getInstance().signOut();
                startActivity(intent2);
                return true;

            default:
                return false;
        }
    }

    @Override
    public void onClick(View v) {

        if (v == donebuttonAC) {
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference(passedGroup);
            myRef.child("meetings").child(createdmeeting).child("AgendaItems").setValue(wholeAgenda);
            Intent intent = new  Intent(AgendaCreation.this, MeetingLayout.class);
            intent.putExtra("passed_group", passedGroup);
            intent.putExtra("passed_meeting", createdmeeting);
            startActivity(intent);
        }

        if (v == buttonAddAgendaItem) {

            agendaTitle = editTextItemTitle.getText().toString();
            agendaDescription = editTextNotes.getText().toString();
            agendaTime = editTextTimeACreation.getText().toString();
            agendaItem = new AgendaItemsClass(agendaTitle, agendaTime, agendaDescription);

            wholeAgenda.add(agendaItem);


            resetText();
            recyclerviewadapter();
        }

    }
}
