package com.sourcey.TeamUp;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import butterknife.InjectView;
import butterknife.ButterKnife;

/**
 * Created by Michelle on 10/30/15.
 */
public class AvailableTimeActivity extends AppCompatActivity {
    // Open when called
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_availabletime);
    }
}
