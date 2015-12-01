package com.sourcey.TeamUp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.media.Image;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.Spinner;
import android.widget.ArrayAdapter;

import java.util.logging.*;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.RequestPasswordResetCallback;

import butterknife.InjectView;
        import butterknife.ButterKnife;

//Created by Michelle on 10/30/15.

public class ProfileActivity extends AppCompatActivity {
    // Open when called
    public static final String TAG = "ProfileActivity";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        ImageButton backBtn = (ImageButton) findViewById(R.id.backBtn);
        Button logoutBtn = (Button) findViewById(R.id.btn_logout);
        Button resetBtn = (Button) findViewById(R.id.btn_reset);
        ImageButton saveBtn = (ImageButton) findViewById(R.id.saveButton);

        // Back
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        //logout
        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                ParseUser.logOut();
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });

        // Save
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // set backend implementation here

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // set backend implementation here
                ParseUser.requestPasswordResetInBackground(ParseUser.getCurrentUser().getEmail(),
                        new RequestPasswordResetCallback() {
                            public void done(ParseException e) {

                                if (e == null) {
                                    // An email was successfully sent with reset
                                    // instructions.
                                    Toast.makeText(getApplicationContext(), "A reset instruction has been send to your email", Toast.LENGTH_LONG).show();
                                } else {
                                    // Something went wrong. Look at the ParseException
                                    // to see what's up.
                                    Toast.makeText(getApplicationContext(), "reset password fail", Toast.LENGTH_LONG).show();
                                }
                            }
                        });
            }
        });

        // Drop down menu for class selection
        Spinner dropdown = (Spinner)findViewById(R.id.classSelection);
        String[] items = new String[]{"CSE 110", "CSE 100", "CSE 101"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);
//
//                Intent intent = new Intent(getApplicationContext(), .class);
//                startActivity(intent);

    }
}