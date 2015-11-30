package com.sourcey.TeamUp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.InjectView;
import butterknife.ButterKnife;

//Created by Michelle on 10/30/15.

public class MyTimeActivity extends AppCompatActivity {
    // Open when called
    public static final String TAG = "MyTimeActivity";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mytime);

        ListView listView = (ListView)findViewById(R.id.myTimes);
        String[] counts ={"CLASS NAME"};
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(counts));
        ArrayAdapter<String> arrayAdapter = new CustomAdapter(this,R.layout.activity_elementmytime,arrayList);
        listView.setAdapter(arrayAdapter);

        ImageButton backBtn = (ImageButton)findViewById(R.id.backBtn);

        // Back
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private class CustomAdapter extends ArrayAdapter<String> {

        private int layout;
        private List<String> list;
        private int position;

        public CustomAdapter(Context context, int resource, List<String> objects) {
            super(context, resource, objects);
            layout = resource;
            list = objects;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            ViewHolder holder = null;
            this.position = position;
            if(convertView == null){
                LayoutInflater inflater = LayoutInflater.from(getContext());
                convertView = inflater.inflate(layout,parent,false);

                final ViewHolder view = new ViewHolder();
                view.title = (TextView)convertView.findViewById(R.id.textView33);
                view.btnDetail = (Button)convertView.findViewById(R.id.detailbutton);
                view.btnSignup = (Button)convertView.findViewById(R.id.quitButton);
                convertView.setTag(view);
                //view.btnSignup.setTag(position);
                view.btnDetail.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View arg0) {
                        Intent intent = new Intent(getApplicationContext(), DetailsMTActivity.class);
                        startActivity(intent);
                    }
                });

                //delete
                view.btnSignup.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View arg0) {
                        //remove(getItem(position));
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
