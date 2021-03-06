package com.sourcey.TeamUp;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseObject;
import com.parse.ParseUser;

/**
 * Created by Michelle on 11/24/15.
 */
public class TeamUp extends Application {

    public void onCreate() {
        super.onCreate();
        // Enable Local Datastore.
        Parse.enableLocalDatastore(this);

        ParseObject.registerSubclass(Student.class);
        ParseObject.registerSubclass(Post.class);
        //ParseObject.registerSubclass(Course.class);

        // Add your initialization code here;
        Parse.initialize(this, "5yIzH6JECOzZRz2tucTKis5keB8LHWxLZDl6Zcce", "CdgOb83Qc3UlpWGnFJdyHuHf19CC8ktPeQ3VfOmK");


        ParseUser.enableAutomaticUser();
        ParseACL defaultACL = new ParseACL();
        ParseACL.setDefaultACL(defaultACL, true);
        defaultACL.setPublicReadAccess(true);

    }
}
