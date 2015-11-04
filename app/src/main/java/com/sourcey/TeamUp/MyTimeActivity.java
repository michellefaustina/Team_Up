package com.sourcey.TeamUp;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import butterknife.InjectView;
import butterknife.ButterKnife;

//Created by Michelle on 10/30/15.

public class MyTimeActivity extends AppCompatActivity {
    // Open when called
    public static final String TAG = "MyTimeActivity";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mytime);

        ImageButton backBtn = (ImageButton)findViewById(R.id.backBtn);

        // Back
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
