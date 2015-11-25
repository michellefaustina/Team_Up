package com.sourcey.TeamUp;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.text.TextUtils;
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
        final EditText className = (EditText)findViewById(R.id.className);
        final EditText time = (EditText)findViewById(R.id.time);
        final EditText location = (EditText)findViewById(R.id.location);
        final EditText groupSize = (EditText)findViewById(R.id.groupSize);

        final Button doneBtn = (Button)findViewById(R.id.doneBtn);

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
                if (ifempty(className) && ifempty(time) &&ifempty(location) && ifempty(groupSize)) {
                    doneBtn.setEnabled(false);
                    createFailed();
                    return;
                }

                Intent intent = new Intent(getApplicationContext(), AvailableTimeActivity.class);
                startActivity(intent);
            }
        });


    }


    public void createFailed() {
        Toast.makeText(this, "You did not complete the required fields", Toast.LENGTH_SHORT).show();

    }

    private boolean ifempty(EditText eText) {
        String enterSubject = eText.getText().toString();
        if ( enterSubject.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

}




