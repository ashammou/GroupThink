package com.example.alishammout.groupthink;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;


public class UserClass extends Activity  {


        String usernameL,passwordL;
        String[] groupsInL;

public UserClass()  {

        }

public UserClass (String username,String password,String[] groupsIn) {
        usernameL=username;
        passwordL= password;
        groupsInL = groupsIn;

        }




}