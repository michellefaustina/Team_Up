package com.sourcey.TeamUp;

import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;

public class AvailableTimeActivity extends Activity {
    private static final String TAG = "AvailableTimeActivity";
    // Declare Variables
    ListView listview;
    List<ParseObject> ob;
    ProgressDialog mProgressDialog;
    ListViewAdapter adapter;
    private List<Post> posts = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the view from listview_main.xml
        setContentView(R.layout.activity_availabletime);
        // Execute RemoteDataTask AsyncTask
        new RemoteDataTask().execute();


        ImageButton backBtn = (ImageButton) findViewById(R.id.backBtn);
        ImageButton userBtn = (ImageButton) findViewById(R.id.userButton);

        // Back
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        //create button
        userBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(getApplicationContext(), PopupActivity.class);
                startActivity(intent);
            }
        });
    }

    // RemoteDataTask AsyncTask
    private class RemoteDataTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Create a progressdialog
            mProgressDialog = new ProgressDialog(AvailableTimeActivity.this);
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
            Log.d(TAG,"in background");
            // Create the array
            posts = new ArrayList<Post>();
            // Locate the class table named "Post" in Parse.com
            ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("Post");
            query.findInBackground(new FindCallback<ParseObject>() {
                @Override
                public void done(List<ParseObject> objects, ParseException e) {
                    if (e == null) {
                        for (ParseObject country : objects) {
                            Post map = new Post();
                            map.setClassName(country.getString("ClassName"));
                            map.setClassTimeDate(country.getString("TimeNDate"));
                            map.setLocation(country.getString("Location"));
                            map.setGroupSize(country.getString("GroupSize"));
                            posts.add(map);
                        }
                    } else {
                        Log.e("Error", e.getMessage());
                        e.printStackTrace();
                    }
                }
            });
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            // Locate the listview in listview_main.xml
            listview = (ListView) findViewById(R.id.listv);
            // Pass the results into ListViewAdapter.java
            adapter = new ListViewAdapter(AvailableTimeActivity.this, posts);
            // Binds the Adapter to the ListView
            listview.setAdapter(adapter);
            // Close the progressdialog
            mProgressDialog.dismiss();
        }
    }
}

