package com.example.alishammout.groupthink;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class AgendaItemsClass extends Activity{

    String descriptionL, timeL, notesL, speakerL;

    public AgendaItemsClass() {

    }

    public AgendaItemsClass(String description, String time, String notes, String speaker) {

        descriptionL = description;
        timeL = time;
        notesL = notes;
        speakerL = speaker;


    }




}
