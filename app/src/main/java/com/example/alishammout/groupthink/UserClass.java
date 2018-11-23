package com.example.alishammout.groupthink;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import java.util.*;



public class UserClass extends Activity  {


        public String usernameL,passwordL;
        public List<GroupMemberClass> groupsInL = new ArrayList<>();

        public UserClass()  {

                usernameL = "";
                passwordL = "";
                groupsInL = new ArrayList<>();



        }

        public UserClass (String username,String password,List<GroupMemberClass> groupsIn) {
                usernameL=username;
                passwordL= password;
                groupsInL = new ArrayList<>(groupsIn);

        }


        public String getUsernameL(){

                return usernameL;

        }

        public String getPasswordL(){
                return passwordL;
        }

        public List<GroupMemberClass> getGroupsInL() {
                return groupsInL;
        }

        public void setUsername(String username){

                usernameL = username;

        }

        public void setPasswordL(String password){
                passwordL = password;
        }

        public void setGroupsInL(List<GroupMemberClass> groupsIn) {
                groupsInL = new ArrayList<>(groupsIn);
        }








}