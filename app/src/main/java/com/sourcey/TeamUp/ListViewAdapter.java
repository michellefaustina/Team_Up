package com.sourcey.TeamUp;

import java.util.ArrayList;
import java.util.List;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.ParseObject;
import com.sourcey.TeamUp.Post;

public class ListViewAdapter extends BaseAdapter {

    // Declare Variables
    Context context;
    LayoutInflater inflater;
    private List<AvailableTimePost> postList = null;
    private ArrayList<AvailableTimePost> arraylist;
    customButtonListener customListner;
    int layout;

    public interface customButtonListener {
        public void onButtonClickListner(int position,Object value);
    }
    public void setCustomButtonListner(customButtonListener listener) {
        this.customListner = listener;
    }

    public ListViewAdapter(Context context,int resource,
                           List<AvailableTimePost> list) {
        this.context = context;
        this.postList = list;
        inflater = LayoutInflater.from(context);
        this.arraylist = new ArrayList<AvailableTimePost>();
        this.arraylist.addAll(postList);
        this.layout = resource;
    }

    public class ViewHolder {
        TextView classname;
        TextView datetime;
        TextView location;
        TextView groupsize;
        Button signup;
    }

    @Override
    public int getCount() {
        return postList.size();
    }

    @Override
    public Object getItem(int position) {
        return postList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(final int position, View view, ViewGroup parent) {
//        final View viewClick = view;
        final ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(this.layout, parent, false);
            // Locate the TextViews in listview_item.xml
            holder.classname = (TextView) view.findViewById(R.id.className);
            holder.datetime = (TextView) view.findViewById(R.id.time);
            holder.location = (TextView) view.findViewById(R.id.location);
            // Locate the ImageView in listview_item.xml
            holder.groupsize = (TextView) view.findViewById(R.id.groupSize);
            holder.signup = (Button)view.findViewById(R.id.signUpButton);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        // Set the results into TextViews
        holder.classname.setText(postList.get(position).getClassName());
        holder.datetime.setText(postList.get(position).getClassTimeNDate());
        holder.location.setText(postList.get(position)
                .getLocation());
        holder.groupsize.setText(postList.get(position).getGroupSize());
        // Listen for ListView Item Click
//        view.setOnClickListener(new OnClickListener() {
//
//            @Override
//            public void onClick(View arg0) {
//                // Send single item click data to SingleItemView Class
//                Intent intent = new Intent(context, AvailableTimeActivity.class);
//                // Pass all data rank
//                intent.putExtra("ClassName",
//                        (postList.get(position).getClassName()));
//                // Pass all data country
//                intent.putExtra("Time",
//                        (postList.get(position).getClassTimeNDate()));
//                // Pass all data population
//                intent.putExtra("Location",
//                        (postList.get(position).getLocation()));
//                // Pass all data flag
//                intent.putExtra("GroupSize",
//                        (postList.get(position).getGroupSize()));
//                // Start SingleItemView Class
//                context.startActivity(intent);
//
//                //change color of signup buttom
//                holder.signup.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View arg0) {
//                        btn.setBackgroundColor(Color.argb(25, 0, 0, 1));
//                    }
//                });
//            }
//        });

        holder.signup.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                if (customListner != null) {
                    customListner.onButtonClickListner(position, getItem(position));
                    holder.signup.setBackgroundColor(Color.argb(25, 0, 0, 1));
                } else {
                    return;
                }

            }
        });


        return view;
    }




}

