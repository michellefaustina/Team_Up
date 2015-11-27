package com.sourcey.TeamUp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.parse.ParseUser;

/**
 * Created by zhangyilun on 11/26/15.
 */

public class DispatchActivity extends Activity{
    private static final String TAG = "DispatchActivity";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(ParseUser.getCurrentUser()!= null) {
            startActivity(new Intent(this, MainActivity.class));
            Log.d(TAG, "current user is not null");
        }
        else {
            startActivity(new Intent(this, LoginActivity.class));
            Log.d(TAG, "current user is null");
        }

    }
}
