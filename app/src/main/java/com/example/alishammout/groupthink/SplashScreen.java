package com.example.alishammout.groupthink;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class SplashScreen extends Activity implements View.OnClickListener {

    private Button enterApp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        enterApp = findViewById(R.id.button3);
        enterApp.setOnClickListener(this);

        ImageView myImageView = findViewById(R.id.logo1);
        myImageView.setImageResource(R.drawable.groupthinklogo);


    }

    @Override
    public void onClick(View v) {
        if (v==enterApp) {

            startActivity(new Intent(SplashScreen.this, MainActivity.class));

        }
    }
}
