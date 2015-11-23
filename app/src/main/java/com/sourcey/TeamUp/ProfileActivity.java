package com.sourcey.TeamUp;

import android.content.Intent;
        import android.support.v7.app.ActionBarActivity;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.view.View;
        import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

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

        ImageButton backBtn = (ImageButton)findViewById(R.id.backBtn);
        Button logoutBtn = (Button)findViewById(R.id.btn_logout);

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
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}