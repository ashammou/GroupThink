package com.example.alishammout.groupthink;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;


public class GroupMemberClass extends Activity{

    UserClass[] usersinGroupL;
    MeetingClass[] meetingsinGroupL;

    public GroupMemberClass() {

    }

    public GroupMemberClass(UserClass[] usersinGroup, MeetingClass[] meetingsinGroup) {

        usersinGroupL = usersinGroup;
        meetingsinGroupL = meetingsinGroup;

    }






}
