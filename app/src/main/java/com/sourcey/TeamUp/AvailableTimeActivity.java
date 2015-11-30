//package com.sourcey.TeamUp;
//
//import android.content.Intent;
//import android.media.Image;
//import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.view.Window;
//import android.widget.ImageButton;
//import android.graphics.Color;
//import android.widget.Button;
//import android.widget.LinearLayout;
//
////Created by Michelle on 10/30/15.
//
//public class AvailableTimeActivity extends AppCompatActivity {
//    // Open when called
//    public static final String TAG = "AvailableTimeActivity";
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        //this.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        setContentView(R.layout.activity_availabletime);
//
//        ImageButton backBtn = (ImageButton)findViewById(R.id.backBtn);
//        ImageButton userBtn = (ImageButton)findViewById(R.id.userButton);
//        Button detailBtn = (Button)findViewById(R.id.detailButton);
//        final Button signupBtn = (Button)findViewById(R.id.signUpButton);
//        Button editBtn = (Button)findViewById(R.id.editButton);
//
//        // Back
//        backBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View arg0) {
//                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//                startActivity(intent);
//            }
//        });
//
//        //create button
//        userBtn.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View arg0) {
//                //Intent intent = new Intent(getApplicationContext(), PopupActivity.class);
//                //startActivity(intent);
//                addTime();
//            }
//        });
//
//
//        //edit button
//        editBtn.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View arg0) {
//                Intent intent = new Intent(getApplicationContext(), PopupActivity.class);
//                startActivity(intent);
//            }
//        });
//
//
//        // Details button
//        detailBtn.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View arg0) {
//                Intent intent = new Intent(getApplicationContext(), DetailsATActivity.class);
//                startActivity(intent);
//            }
//        });
//
//
//
//        //change color of signup buttom
//        signupBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View arg0) {
//                signupBtn.setBackgroundColor(Color.argb(25, 0, 0, 1));
//            }
//        });
//    }
//
//    public void addTime(){
//        LayoutInflater inflater = getLayoutInflater();
//        View view = inflater.inflate(R.layout.activity_elementtimes, null);
//        LinearLayout viewGroup = (LinearLayout)findViewById(R.id.ListOfTimes1);
//        viewGroup.addView(view);
//    }
//
//
//}
package com.sourcey.TeamUp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.graphics.Color;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Created by Michelle on 10/30/15.

public class AvailableTimeActivity extends Activity {
    // Open when called
    public static final String TAG = "AvailableTimeActivity";
    //ArrayList<Post> groups = new ArrayList<Post>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_availabletime);

        //addTime();
        ListView listView = (ListView)findViewById(R.id.listv);
        String[] counts ={"CLASS NAME"};
//        for(int i = 0; i < 30; i++)
//        {
//            counts[i] = "CLASS NAME" + i;
//        }
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(counts));
        ArrayAdapter<String> arrayAdapter = new CustomAdapter(this,R.layout.activity_elementtimes,arrayList);
        listView.setAdapter(arrayAdapter);

//        ParseQuery<Post> query = new ParseQuery<Post> ("Post");
//        query.findInBackground(new FindCallback<Post>() {
//            @Override
//            public void done(List<Post> objects, com.parse.ParseException e) {
//                if (e != null)
//                    Toast.makeText(AvailableTimeActivity.this, "Error" + e, Toast.LENGTH_SHORT).show();
//                else {
//                    for (Post group : objects) {
//                        Post newgroup = new Post();
//                        newgroup.setGroupName(newgroup.getGroupName());
//                        newgroup.setDescription(newgroup.getDescription());
//                        newgroup.setLocation(newgroup.getLocation());
//                        newgroup.setTime(newgroup.getTime());
//                        groups.add(newgroup);
//                    }
//                }
//            }
//        });

        ImageButton backBtn = (ImageButton)findViewById(R.id.backBtn);
      ImageButton userBtn = (ImageButton)findViewById(R.id.userButton);


         //Back
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

       // create button
        userBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(getApplicationContext(), PopupActivity.class);
              startActivity(intent);
            }
        });


    }



    private class CustomAdapter extends ArrayAdapter<String>{

        private int layout;

        public CustomAdapter(Context context, int resource, List<String> objects) {
            super(context, resource, objects);
            layout = resource;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder = null;
            if(convertView == null){
                LayoutInflater inflater = LayoutInflater.from(getContext());
                convertView = inflater.inflate(layout,parent,false);

                ViewHolder view = new ViewHolder();
                view.title = (TextView)convertView.findViewById(R.id.textView32);
                view.btnDetail = (Button)convertView.findViewById(R.id.detailBtn);
                view.btnSignup = (Button)convertView.findViewById(R.id.signUpButton);
                final Button btn = view.btnSignup;
                convertView.setTag(view);
                view.btnDetail.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View arg0) {
                        Intent intent = new Intent(getApplicationContext(), DetailsATActivity.class);
                        startActivity(intent);
                    }
                });

                //change color of signup buttom
                view.btnSignup.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View arg0) {
                        btn.setBackgroundColor(Color.argb(25, 0, 0, 1));
                    }
                });
            }
            else
            {
                holder = (ViewHolder)convertView.getTag();
                holder.title.setText(getItem(position));
            }
            return convertView;
        }
    }

    public class ViewHolder{
        TextView title;
        Button btnDetail;
        Button btnSignup;
    }
}



