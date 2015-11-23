package com.sourcey.TeamUp;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.graphics.Color;
import android.widget.Button;

//Created by Michelle on 10/30/15.

public class AvailableTimeActivity extends AppCompatActivity {
    // Open when called
    public static final String TAG = "AvailableTimeActivity";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_availabletime);

        ImageButton backBtn = (ImageButton)findViewById(R.id.backBtn);
        ImageButton userBtn = (ImageButton)findViewById(R.id.userButton);
        final Button signupBtn = (Button)findViewById(R.id.signUpButton);

        // Back
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        //userBtn
        userBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(getApplicationContext(), PopupActivity.class);
                startActivity(intent);
            }
        });

        //change color of signup buttom
        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                signupBtn.setBackgroundColor(Color.argb(25, 0, 0, 1));
            }
        });
    }




}
