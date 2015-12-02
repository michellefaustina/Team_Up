package com.sourcey.TeamUp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;


/**
 * Created by user on 2015/11/30.
*/

public class ElementmytimesActivity extends Activity {
    // Declare Variables
    String classname;
    String time;
    String date;
    String location;
    String groupsize;
    String position;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the view
        setContentView(R.layout.activity_elementmytimes);

        Intent i = getIntent();
        // Get the result of name
        classname = i.getStringExtra("ClassName");
        // Get the result of time
        time = i.getStringExtra("Time");
        // Get the result of location
        location = i.getStringExtra("Location");
        // Get the result of groupsize
        groupsize = i.getStringExtra("GroupSize");
        //get the result of data
        date = i.getStringExtra("Date");

        // Locate the TextViews in singleitemview.xml
        TextView _className = (TextView) findViewById(R.id.classNameLabel1);
        TextView _time = (TextView) findViewById(R.id.timeLabel1);
        TextView _location = (TextView) findViewById(R.id.locationLabel1);

        // Locate the ImageView in singleitemview.xml
        TextView _groupsize = (TextView) findViewById(R.id.groupSizeLabel1);

        // Set results to the TextViews
        _className.setText(classname);
        _time.setText(time);
        _location.setText(location);
        _groupsize.setText(groupsize);
    }
}