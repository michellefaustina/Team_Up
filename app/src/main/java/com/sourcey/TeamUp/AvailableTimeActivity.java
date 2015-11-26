package com.sourcey.TeamUp;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageButton;
import android.graphics.Color;
import android.widget.Button;
import android.widget.LinearLayout;

//Created by Michelle on 10/30/15.

public class AvailableTimeActivity extends AppCompatActivity {
    // Open when called
    public static final String TAG = "AvailableTimeActivity";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_availabletime);

        ImageButton backBtn = (ImageButton)findViewById(R.id.backBtn);
        ImageButton userBtn = (ImageButton)findViewById(R.id.userButton);
        Button detailBtn = (Button)findViewById(R.id.detailButton);
        final Button signupBtn = (Button)findViewById(R.id.signUpButton);
        Button editBtn = (Button)findViewById(R.id.editButton);

        // Back
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        //create button
        userBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                //Intent intent = new Intent(getApplicationContext(), PopupActivity.class);
                //startActivity(intent);
                addTime();
            }
        });


        //edit button
        editBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(getApplicationContext(), PopupActivity.class);
                startActivity(intent);
            }
        });


        // Details button
        detailBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(getApplicationContext(), DetailsATActivity.class);
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

    public void addTime(){
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.activity_elementtimes, null);
        LinearLayout viewGroup = (LinearLayout)findViewById(R.id.ListOfTimes1);
        viewGroup.addView(view);
    }


}



