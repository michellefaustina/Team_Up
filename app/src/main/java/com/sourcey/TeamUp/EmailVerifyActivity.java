package com.sourcey.TeamUp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import com.parse.ParseUser;
/**
 * Created by user on 2015/11/27.
 */
public class EmailVerifyActivity extends Activity{
    private static final String TAG = "EmailVerifyActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emailverify);

        Button verify = (Button)findViewById(R.id.btn_verify);

        verify.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
            }

        });

    }
}