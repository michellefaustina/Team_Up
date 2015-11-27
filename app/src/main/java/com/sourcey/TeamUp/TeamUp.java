package com.sourcey.TeamUp;

import android.app.Application;
import android.os.Bundle;

import com.parse.Parse;
import com.parse.ParseObject;
import com.parse.ParseClassName;

/**
 * Created by Michelle on 11/24/15.
 */
public class TeamUp extends Application {

    public void onCreate() {
        super.onCreate();
        // Enable Local Datastore.
        Parse.enableLocalDatastore(this);

        ParseObject.registerSubclass(Student.class);
        ParseObject.registerSubclass(Group.class);
        //ParseObject.registerSubclass(Course.class);

        Parse.initialize(this, "5yIzH6JECOzZRz2tucTKis5keB8LHWxLZDl6Zcce", "CdgOb83Qc3UlpWGnFJdyHuHf19CC8ktPeQ3VfOmK");
    }
}
