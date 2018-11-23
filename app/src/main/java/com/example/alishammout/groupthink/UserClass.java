package com.example.alishammout.groupthink;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;


public class UserClass extends Activity  {


        public String usernameL,passwordL;
        public GroupMemberClass[] groupsInL;

        public UserClass()  {

                usernameL = "";
                passwordL = "";



        }

        public UserClass (String username,String password,GroupMemberClass[] groupsIn) {
                usernameL=username;
                passwordL= password;
                groupsInL = groupsIn;

        }


        public String getUsernameL(){

                return usernameL;

        }

        public String getPasswordL(){
                return passwordL;
        }

        public GroupMemberClass[] getGroupsInL() {
                return groupsInL;
        }

        public void setUsername(String username){

                usernameL = username;

        }

        public void setPasswordL(String password){
                passwordL = password;
        }

        public void setGroupsInL(GroupMemberClass[] groupsIn) {
                groupsInL = groupsIn;
        }








}