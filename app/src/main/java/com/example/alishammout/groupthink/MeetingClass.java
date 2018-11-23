package com.example.alishammout.groupthink;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class MeetingClass {

    public String starttimeL, locationL;
    public AgendaItemsClass[] agendaL;
    public UserClass[] meetingattendeesL;


    public MeetingClass(){

    }

    public MeetingClass(AgendaItemsClass[] agenda, String starttime, String location, UserClass[]
            meetingattendees) {

        agendaL = agenda;
        starttimeL = starttime;
        locationL = location;
        meetingattendeesL = meetingattendees;



    }


    public String getStarttimeL(){
        return starttimeL;

    }

    public String getLocationL() {
        return locationL;
    }

    public AgendaItemsClass[] getAgendaL(){
        return agendaL;
    }

    public UserClass[] getMeetingattendeesL() {
        return meetingattendeesL;
    }


    public void setStarttimeL(String starttime){
        starttimeL = starttime;

    }

    public void setLocationL(String location) {
        locationL = location;

    }

    public void setAgendaL(AgendaItemsClass[] agenda) {
        agendaL = agenda;
    }

    public void setMeetingattendeesL(UserClass[] meetingattendees) {
        meetingattendeesL = meetingattendees;
    }




}
