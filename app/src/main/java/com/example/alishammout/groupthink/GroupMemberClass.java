package com.example.alishammout.groupthink;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;


public class GroupMemberClass extends Activity{

    public UserClass[] usersinGroupL;
    public MeetingClass[] meetingsinGroupL;

    public GroupMemberClass() {

    }

    public GroupMemberClass(UserClass[] usersinGroup, MeetingClass[] meetingsinGroup) {

        usersinGroupL = usersinGroup;
        meetingsinGroupL = meetingsinGroup;

    }

    public UserClass[] getUsersinGroup() {
        return usersinGroupL;
    }

    public MeetingClass[] getMeetingsinGroup() {
        return meetingsinGroupL;
    }

    public void setUsersinGroup(UserClass[] usersinGroup) {
        usersinGroupL = usersinGroup;
    }

    public void setMeetingsinGroup(MeetingClass[] meetingsinGroup) {
        meetingsinGroupL = meetingsinGroup;
    }






}
