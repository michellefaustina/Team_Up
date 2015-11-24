package com.sourcey.TeamUp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.parse.Parse;
import com.parse.ParseObject;

import butterknife.InjectView;


public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.myTimeButton) Button _myTimeButton;
    @InjectView(R.id.availableTimeButton) Button _availableTimeBtn;
    @InjectView(R.id.userButton) Button _userBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Intent intent = new Intent(getBaseContext(),LoginActivity.class);
        startActivity(intent);
        finishActivity(0);*/

        ImageButton myTimebutton = (ImageButton)findViewById(R.id.myTimeButton);
        ImageButton availableTimeBtn = (ImageButton)findViewById(R.id.availableTimeButton);
        ImageButton userBtn = (ImageButton)findViewById(R.id.userButton);

        // Open MY TIME
        myTimebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(getApplicationContext(), MyTimeActivity.class);
                startActivity(intent);
            }
        });

        // Open Available Time
        availableTimeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getBaseContext(), AvailableTimeActivity.class);
                startActivityForResult(intent2, 0);
            }
        });

        // Open Profile Activity
        userBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getBaseContext(), ProfileActivity.class);
                startActivityForResult(intent2, 0);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
