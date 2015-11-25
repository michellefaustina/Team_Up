package com.sourcey.TeamUp;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Button;
import android.app.ProgressDialog;
import android.widget.TextView;
import android.widget.Toast;
import android.app.AlertDialog;
import java.text.ParseException;
import butterknife.InjectView;
import com.parse.ParseObject;


public class PopupActivity extends Activity{

    @InjectView(R.id.className) EditText _className;
    @InjectView(R.id.time) EditText _time;
    @InjectView(R.id.location) EditText _location;
    @InjectView(R.id.groupSize) EditText _groupSize;
    @InjectView(R.id.doneBtn) Button _done;

    private EditText className, time, location, size;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width * 0.85), (int) (height * 0.7));

        ImageButton backBtn = (ImageButton)findViewById(R.id.backBtn);
        Button doneBtn = (Button)findViewById(R.id.doneBtn);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AvailableTimeActivity.class);
                startActivity(intent);
            }
        });

        doneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //createTime();


                //boolean textToString = false;
                /*
                className = (EditText) _className.getText();
                time = (EditText) _time.getText();
                location = (EditText)_location.getText();
                size =(EditText) _groupSize.getText();
                /*
                if (isEmpty(className) || isEmpty(time) || isEmpty(location) || isEmpty(size)) {
                    textToString = false;
                }
                else{
                    ParseObject groupObject = new ParseObject("Group");
                    groupObject.put("GroupName", className.toString());
                    groupObject.put("Time", time.toString());
                    groupObject.put("Location", location.toString());
                    groupObject.put("Counter", (size.toString()));
                    groupObject.saveInBackground();
                }
                */

                //setCourseName(className);

                Intent intent = new Intent(getApplicationContext(), AvailableTimeActivity.class);
                startActivity(intent);
            }
        });
    }

    /*public void createTime() {
        if (!validate()) {
            onFailed();
            return;
        }

        _done.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(PopupActivity.this,
                R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Creating...");
        progressDialog.show();



        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        // On complete call either onLoginSuccess or onLoginFailed
                        onSuccess();
                        // onLoginFailed();
                        progressDialog.dismiss();
                    }
                }, 3000);
    }

    public void onSuccess() {
        _done.setEnabled(true);

        String className = _className.getText().toString();
        String time = _time.getText().toString();
        String location = _location.getText().toString();
        String size = _groupSize.getText().toString();

        // create schedule with the above info

        // this is temporary
        Intent intent = new Intent(getApplicationContext(), AvailableTimeActivity.class);
        startActivity(intent);
    }

    public void onFailed() {
        //Toast.makeText(getBaseContext(), "Create failed", Toast.LENGTH_LONG).show();

        // this is temporary
        Intent intent = new Intent(getApplicationContext(), AvailableTimeActivity.class);
        startActivity(intent);

        _done.setEnabled(true);
    }

    public boolean validate() {
        boolean valid = true;

        String className = _className.getText().toString();
        String time = _time.getText().toString();
        String location = _location.getText().toString();
        String size = _groupSize.getText().toString();

        if (className.isEmpty()) {
            _className.setError("*");
            valid = false;
        }

        if (time.isEmpty()) {
            _time.setError("*");
            valid = false;
        }

        if (location.isEmpty()) {
            _location.setError("*");
            valid = false;
        }

        if (size.isEmpty()) {
            _groupSize.setError("*");
            valid = false;
        }

        return valid;
    }*/
    private boolean isEmpty(EditText eText){
        return (eText.getText().toString().trim().length() >0);
    }
}




