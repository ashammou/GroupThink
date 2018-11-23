package com.example.alishammout.groupthink;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import java.util.*;

public class MeetingClass {

    public String starttimeL, locationL;
    public List<AgendaItemsClass> agendaL = new ArrayList<>();
    public List<UserClass> meetingattendeesL = new ArrayList<>();


    public MeetingClass(){

        starttimeL = "";
        locationL = "";
        agendaL = new ArrayList<>();
        meetingattendeesL = new ArrayList<>();


    }

    public MeetingClass(List<AgendaItemsClass> agenda, String starttime, String location, List<UserClass>
            meetingattendees) {

        agendaL = agenda;
        starttimeL = starttime;
        locationL = location;
        meetingattendeesL = new ArrayList<>(meetingattendees);
        agendaL = new ArrayList<>(agenda);



    }


    public String getStarttimeL(){
        return starttimeL;

    }

    public String getLocationL() {
        return locationL;
    }

    public List<AgendaItemsClass> getAgendaL(){
        return agendaL;
    }

    public List<UserClass> getMeetingattendeesL() {
        return meetingattendeesL;
    }


    public void setStarttimeL(String starttime){
        starttimeL = starttime;

    }

    public void setLocationL(String location) {
        locationL = location;

    }

    public void setAgendaL(List<AgendaItemsClass> agenda) {
        agendaL = new ArrayList<>(agenda);
    }

    public void setMeetingattendeesL(List<UserClass> meetingattendees) {
        meetingattendeesL = new ArrayList<>(meetingattendees);
    }




}
