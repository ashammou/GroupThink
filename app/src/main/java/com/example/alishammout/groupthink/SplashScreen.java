package com.example.alishammout.groupthink;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class SplashScreen extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        ImageView myImageView = findViewById(R.id.logo1);
        myImageView.setImageResource(R.drawable.groupthinklogo);

        new java.util.Timer().schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {

                        startActivity(new Intent(SplashScreen.this,
                                MainActivity.class));

                    }
                },
                    6000
        );


    }

}
