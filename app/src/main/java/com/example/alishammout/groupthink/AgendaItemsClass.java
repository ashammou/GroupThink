package com.example.alishammout.groupthink;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import java.util.*;

public class AgendaItemsClass extends Activity{

    public String descriptionL, timeL, notesL, speakerL;

    public AgendaItemsClass() {

        descriptionL = "";
        timeL = "";
        notesL = "";
        speakerL = "";


    }

    public AgendaItemsClass(String description, String time, String notes, String speaker) {

        descriptionL = description;
        timeL = time;
        notesL = notes;
        speakerL = speaker;


    }

    public String getDescriptionL(){

        return descriptionL;

    }

    public String getTimeL() {
        return timeL;

    }

    public String getNotesL(){
        return notesL;
    }

    public String getSpeakerL(){
        return speakerL;
    }

    public void setDescriptionL(String description) {
        descriptionL = description;


    }

    public void setTimeL(String time){
        timeL = time;

    }

    public void setNotesL(String notes) {
        notesL = notes;
    }

    public void setSpeakerL(String speaker){
        speakerL = speaker;

    }


}
