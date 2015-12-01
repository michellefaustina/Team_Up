package com.sourcey.TeamUp;

/**
 * Created by zhangyilun on 11/30/15.
 */
public class Mytimepost {
    private String className;
    private String timeNdate;
    private String location;
    private String groupSize;

    public String getClassName(){
        return className;
    }

    public void setClassName(String className){
        this.className = className;
    }

    public String getLocation(){
        return location;
    }

    public void setLocation(String location){
        this.location = location;
    }

    public String getClassTimeNDate(){
        return timeNdate;
    }

    public void setClassTime(String timedate){
        this.timeNdate = timedate;
    }


    public String getGroupSize(){
        return groupSize;
    }

    public void setGroupSize(String groupSize){
        this.groupSize = groupSize;
    }
}


