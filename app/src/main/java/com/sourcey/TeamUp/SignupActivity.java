package com.sourcey.TeamUp;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;
import com.parse.Parse;
import com.parse.ParseUser;


import com.parse.SignUpCallback;
import com.parse.ParseUser;

import java.text.ParseException;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class SignupActivity extends AppCompatActivity {
    private static final String TAG = "SignupActivity";
    @InjectView(R.id.input_password1)
    EditText _passwordText;
    @InjectView(R.id.retype_password1)
    EditText _retypeText;
    @InjectView(R.id.input_name1)
    EditText _nameText;
    @InjectView(R.id.input_email1)
    EditText _emailText;
    @InjectView(R.id.btn_signup)
    Button _signupButton;
    @InjectView(R.id.link_login)
    TextView _loginLink;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        ButterKnife.inject(this);

        _signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup();
            }
        });

        _loginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Finish the registration screen and return to the Login activity
                finish();
            }
        });
    }

    public void signup() {
        Log.d(TAG, "Signup");

//        if (!validate()) {
//            onSignupFailed();
//            return;
//        }
//
//        _signupButton.setEnabled(false);



        //validate the signup data
        boolean validationError = false;
        StringBuilder validationErrorMessage = new StringBuilder("Please ");
        if (ifempty(_nameText)) {
            validationError = true;
            validationErrorMessage.append("enter your name");
        }
        if (ifempty(_emailText)) {
            if(validationError) {
                validationErrorMessage.append(", and ");
            }
            validationError = true;
            validationErrorMessage.append("enter a UCSD email");
        }
        if (ifempty(_passwordText)) {
            if(validationError) {
                validationErrorMessage.append(", and ");
            }
            validationError = true;
            validationErrorMessage.append("enter a password");
        }
        if(!isMatching(_passwordText,_retypeText)) {
            if(validationError) {
                validationErrorMessage.append(", and ");

                }
                validationError = true;
                validationErrorMessage. append("enter a same password");
            }
        validationErrorMessage.append(".");

        if(validationError){
            Toast.makeText(SignupActivity.this, validationErrorMessage.toString(),Toast.LENGTH_LONG).show();
            _signupButton.setEnabled(true);
            return;
        }

//        final ProgressDialog progressDialog = new ProgressDialog(SignupActivity.this,
//                R.style.AppTheme_Dark_Dialog);
//        progressDialog.setIndeterminate(true);
//        progressDialog.setMessage("Creating Account...");
//        progressDialog.show();


            //set up parse user
        ParseUser user = new ParseUser();
        user.setUsername(_nameText.getText().toString());
        user.setPassword(_passwordText.getText().toString());
        user.setEmail(_emailText.getText().toString() + "@ucsd.edu");

        user.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(com.parse.ParseException e) {
                if (e != null) {
                    //error
                    _signupButton.setEnabled(false);
                    Toast.makeText(SignupActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();



                } else {
                    onSignupSuccess();

                }
            }
        });
//        if(tag == 0) {
//                            Log.d(TAG, "about to go to onsignupsuccess");
//                                    onSignupSuccess();}

//        new android.os.Handler().postDelayed(
//                new Runnable() {
//                    public void run() {
//                        // On complete call either onSignupSuccess or onSignupFailed
//                        // depending on success
//                        if(tag == 0) {
//                            Log.d(TAG, "about to go to onsignupsuccess");
//                                    onSignupSuccess();
//
//                        }
//                        // onSignupFailed();
//                        progressDialog.dismiss();
//                    }
//                }, 30);
    }


    public void onSignupSuccess() {
        _signupButton.setEnabled(true);
        setResult(RESULT_OK, null);
        Intent intent = new Intent(this, EmailVerifyActivity.class);
        startActivity(intent);
        finish();
    }

    public void onSignupFailed() {
        Toast.makeText(getBaseContext(), "Signup failed", Toast.LENGTH_LONG).show();

        _signupButton.setEnabled(true);
    }

//    public boolean validate() {
//        boolean valid = true;
//
//        String email = _emailText.getText().toString();
//
//
//        if (email.isEmpty()) {
//            _emailText.setError(null);
//            valid = false;
//        }
//
//
//        return valid;
//    }


    private boolean ifempty(EditText eText) {
        String enterSubject = eText.getText().toString();
        if (enterSubject.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isMatching(EditText t1, EditText t2) {
        if(t1.getText().toString().equals(t2.getText().toString())) {
            return true;
        }
        else {
            return false;
        }
    }
}