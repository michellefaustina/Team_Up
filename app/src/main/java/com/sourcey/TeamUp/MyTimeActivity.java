package com.sourcey.TeamUp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseRelation;
import com.parse.ParseUser;

import java.util.ArrayList;
import java.util.List;

import butterknife.InjectView;
import butterknife.ButterKnife;

//Created by Michelle on 10/30/15.

public class MyTimeActivity extends AppCompatActivity {
    // Open when called
    public static final String TAG = "MyTimeActivity";
    //
    ListView listView;
    List<ParseObject> ob;
    ProgressDialog mProgressDialog;
    ListViewAdapter adapter;
    private List<AvailableTimePost> posts;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mytime);
        // Execute RemoteDataTask AsyncTask
//        new RemoteDataTask().execute();

        ImageButton backBtn = (ImageButton)findViewById(R.id.backBtn);
        Button quitBtn = (Button)findViewById(R.id.quitButton);

        // Back
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        //quit button

    }

    // RemoteDataTask AsyncTask
    private class RemoteDataTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Create a progressdialog
            mProgressDialog = new ProgressDialog(MyTimeActivity.this);
            //Set progressdialog title
            mProgressDialog.setTitle(null);
            // Set progressdialog message
            mProgressDialog.setMessage("Loading...");
            mProgressDialog.setIndeterminate(false);
            // Show progressdialog
            mProgressDialog.show();
        }
        @Override
        protected Void doInBackground(Void... params) {
            // Create the array
            Log.d(TAG, "async do in bg");
            posts = new ArrayList<AvailableTimePost>();
            try {
                // Locate the class table named "Country" in Parse.com
                ParseObject user = ParseUser.getCurrentUser();
                ParseRelation relation = user.getRelation("Post");
                ParseQuery<ParseObject> q = relation.getQuery();
                ob = q.find();
                Log.d(TAG,"before loop");
                for (ParseObject country : ob) {
                    // Locate images in flag column
                    AvailableTimePost map = new AvailableTimePost();
                    map.setClassName(country.fetchIfNeeded().getString("Course"));
                    map.setClassTime(country.getString("Timedate"));
                    map.setLocation(country.getString("Location"));
                    map.setGroupSize(country.getString("Groupsize"));
                    posts.add(map);
                }
            } catch (ParseException e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            // Locate the listview in listview_main.xml
            listView = (ListView) findViewById(R.id.listv);
            // Pass the results into ListViewAdapter.java
            adapter = new ListViewAdapter(MyTimeActivity.this, posts);
            // Binds the Adapter to the ListView
            listView.setAdapter(adapter);
            // Close the progressdialog
            mProgressDialog.dismiss();
        }
    }
}

