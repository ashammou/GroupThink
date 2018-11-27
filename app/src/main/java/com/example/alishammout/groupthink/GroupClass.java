package com.example.alishammout.groupthink;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import java.util.*;
//comment


public class GroupClass extends Activity{

    public List<UserClass> usersinGroupL;
    public List<MeetingClass> meetingsinGroupL;

    public GroupClass() {

        usersinGroupL = new ArrayList<>();
        meetingsinGroupL = new ArrayList<>();

    }

    public GroupClass(List<UserClass> usersinGroup, List<MeetingClass> meetingsinGroup) {

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
