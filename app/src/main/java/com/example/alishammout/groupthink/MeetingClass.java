package com.example.alishammout.groupthink;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class MeetingClass {

    String starttimeL, locationL;
    AgendaItemsClass[] agendaL;
    UserClass[] meetingattendeesL;


    public MeetingClass(){

    }

    public MeetingClass(AgendaItemsClass[] agenda, String starttime, String location, UserClass[]
            meetingattendees) {

        agendaL = agenda;
        starttimeL = starttime;
        locationL = location;
        meetingattendeesL = meetingattendees;



    }




}
