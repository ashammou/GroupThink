package com.example.alishammout.groupthink;

import android.app.Activity;

import java.util.*;



public class UserClass extends Activity  {


        public String usernameL,passwordL;
        public List<GroupClass> groupsInL = new ArrayList<>();

        public UserClass()  {

                usernameL = "";
                passwordL = "";
                groupsInL = new ArrayList<>();



        }

        public UserClass (String username,String password,List<GroupClass> groupsIn) {
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

        public List<GroupClass> getGroupsInL() {
                return groupsInL;
        }

        public void setUsername(String username){

                usernameL = username;

        }

        public void setPasswordL(String password){
                passwordL = password;
        }

        public void setGroupsInL(List<GroupClass> groupsIn) {
                groupsInL = new ArrayList<>(groupsIn);
        }








}