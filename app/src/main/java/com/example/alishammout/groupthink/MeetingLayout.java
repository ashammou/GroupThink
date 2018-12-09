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
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MeetingLayout extends Activity implements View.OnClickListener {

    private String currentMeeting, currentGroup;
    private TextView meetingNameText, textViewShowTime,textViewShowLoction, textViewShowMember;
    private RecyclerViewAdapterMeetingLayout recyclerViewAdapterMeetingLayout;
    private ArrayList<AgendaItemsClass> wholeAgenda = new ArrayList<>();
    private ArrayList<String> Members = new ArrayList<>();
    private MeetingClass currentMeetingClass = new MeetingClass();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meeting_layout);
        currentMeeting = getIntent().getStringExtra("passed_meeting");
        currentGroup = getIntent().getStringExtra("passed_group");

        meetingNameText = findViewById(R.id.meetingNameText);
        textViewShowTime = findViewById(R.id.textViewShowTime);
        textViewShowLoction = findViewById(R.id.textViewShowLoction);
        textViewShowMember = findViewById(R.id.textViewShowMember);
        meetingNameText.setText(currentMeeting);

        getAgenda();
        setMeetingInfo();
        initRecyclerView ();
    }

    public void setMeetingInfo() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference(currentGroup);

        //updates Time and Location
        myRef.child("meetings").child(currentMeeting).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                currentMeetingClass = dataSnapshot.getValue(MeetingClass.class);
                textViewShowTime.setText(currentMeetingClass.getStarttimeL());
                textViewShowLoction.setText(currentMeetingClass.getLocationL());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        //updates Member List
        //still needs to display the Array
        //maybe a single textViewShowMember isn't the best solution? (also in terms of looks)
        myRef.child("usersInGroup").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for(DataSnapshot child : dataSnapshot.getChildren()) {
                    String member = child.getValue(String.class);
                    Members.add(member);
                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void getAgenda() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference(currentGroup);
        myRef.child("meetings").child(currentMeeting).child("AgendaItems").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for(DataSnapshot child : dataSnapshot.getChildren()) {
                    AgendaItemsClass agendaItem = child.getValue(AgendaItemsClass.class);
                    wholeAgenda.add(agendaItem);
                }
                recyclerViewAdapterMeetingLayout.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void initRecyclerView () {
        RecyclerView recyclerView = findViewById(R.id.recyclerViewMeetingLayout);
        recyclerViewAdapterMeetingLayout = new RecyclerViewAdapterMeetingLayout(wholeAgenda, this);
        recyclerView.setAdapter(recyclerViewAdapterMeetingLayout);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
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
                Intent intent1 = new Intent(MeetingLayout.this, GroupOverview.class);
                startActivity(intent1);
                return true;
            case R.id.menuitemLogout:
                Intent intent2 = new Intent(MeetingLayout.this, MainActivity.class);
                FirebaseAuth.getInstance().signOut();
                startActivity(intent2);
                return true;

            default:
                return false;
        }
    }

    @Override
    public void onClick(View view) {

    }
}
