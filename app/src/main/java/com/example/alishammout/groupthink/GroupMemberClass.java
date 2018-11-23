package com.example.alishammout.groupthink;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import java.util.*;


public class GroupMemberClass extends Activity{

    public List<UserClass> usersinGroupL = new ArrayList<>();
    public List<MeetingClass> meetingsinGroupL = new ArrayList<>();

    public GroupMemberClass() {

        usersinGroupL = new ArrayList<>();
        meetingsinGroupL = new ArrayList<>();

    }

    public GroupMemberClass(List<UserClass> usersinGroup, List<MeetingClass> meetingsinGroup) {

        usersinGroupL = new ArrayList<>(usersinGroup);
        meetingsinGroupL = new ArrayList<>(meetingsinGroup);

    }

    public List<UserClass> getUsersinGroup() {
        return usersinGroupL;
    }

    public List <MeetingClass> getMeetingsinGroup() {
        return meetingsinGroupL;
    }

    public void setUsersinGroup(List<UserClass> usersinGroup) {
        usersinGroupL = usersinGroup;
    }

    public void setMeetingsinGroup(List<MeetingClass> meetingsinGroup) {
        meetingsinGroupL = meetingsinGroup;
    }






}
