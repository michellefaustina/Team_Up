package com.sourcey.TeamUp;

import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;

public class AvailableTimeActivity extends Activity {
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
    }

    // RemoteDataTask AsyncTask
    private class RemoteDataTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Create a progressdialog
            mProgressDialog = new ProgressDialog(AvailableTimeActivity.this);
            // Set progressdialog title
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
            posts = new ArrayList<Post>();
            try {
                // Locate the class table named "Post" in Parse.com
                ParseQuery<ParseObject> query = new ParseQuery<ParseObject>(
                        "Post");
                // Locate the column named "Counter" in Parse.com and order list
                // by ascending
                query.orderByAscending("Counter");
                ob = query.find();
                for (ParseObject country : ob) {
                    Post map = new Post();
                    map.setClassName((String) country.get("ClassName"));
                    map.setDate((String) country.get("Date"));
                    map.setLocation((String) country.get("Location"));
                    map.setGroupSize((String) country.get("GroupSize"));
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
