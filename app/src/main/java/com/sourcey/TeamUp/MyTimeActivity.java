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

//Created by Michelle on 10/30/15.

public class MyTimeActivity extends AppCompatActivity {
    // Open when called
    public static final String TAG = "MyTimeActivity";
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_mytime);
//
//        ImageButton backBtn = (ImageButton)findViewById(R.id.backBtn);
//        Button detailBtn = (Button)findViewById(R.id.detailButton);
//        Button quitBtn = (Button)findViewById(R.id.quitButton);
//
//        // Back
//        backBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View arg0) {
//                Intent intent = new Intent(getBaseContext(), MainActivity.class);
//                startActivity(intent);
//            }
//        });
//
//        // Details button
//        detailBtn.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View arg0) {
//                Intent intent = new Intent(getApplicationContext(), DetailsMTActivity.class);
//                startActivity(intent);
//                finish();
//            }
//        });
//
//        //quit button
//
//    }


    // Declare Variables
    ListView listview;
    List<ParseObject> ob;
//    ProgressDialog mProgressDialog;
    ListViewAdapter adapter;
    private List<Mytimepost> postofmytimes = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the view from listview_main.xml
        setContentView(R.layout.activity_mytime);
        // Execute RemoteDataTask AsyncTask
        new RemoteDataTask().execute();
    }

    // RemoteDataTask AsyncTask
    private class RemoteDataTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Create a progressdialog
            mProgressDialog = new ProgressDialog(MyTimeActivity.this);
            // Set progressdialog title
            mProgressDialog.setTitle("My Times");
            // Set progressdialog message
            mProgressDialog.setMessage("Loading...");
            mProgressDialog.setIndeterminate(false);
            // Show progressdialog
            mProgressDialog.show();
        }

        @Override
        protected Void doInBackground(Void... params) {
            // Create the array
            postofmytimes = new ArrayList<Mytimepost>();
            try {
                // Locate the class table named "Country" in Parse.com
                ParseQuery<ParseObject> query = new ParseQuery<ParseObject>(
                        "ClassName");
                // Locate the column named "ranknum" in Parse.com and order list
                // by ascending
                query.orderByAscending("createdAt");
                ob = query.find();
                for (ParseObject country : ob) {
                    // Locate images in flag column
//                    ParseFile image = (ParseFile) country.get("flag");

                    Mytimepost map = new Mytimepost();
                    map.setClassName((String) country.get("rank"));
                    map.setCountry((String) country.get("country"));
                    map.setPopulation((String) country.get("population"));
                    map.setFlag(image.getUrl());
                    worldpopulationlist.add(map);
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
            listview = (ListView) findViewById(R.id.listview);
            // Pass the results into ListViewAdapter.java
            adapter = new ListViewAdapter(MainActivity.this,
                    worldpopulationlist);
            // Binds the Adapter to the ListView
            listview.setAdapter(adapter);
            // Close the progressdialog
            mProgressDialog.dismiss();
        }
    }
}
