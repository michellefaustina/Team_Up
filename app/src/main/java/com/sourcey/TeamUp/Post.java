package com.sourcey.TeamUp;

import com.parse.ParseClassName;
import com.parse.ParseException;
import com.parse.ParseObject;

@ParseClassName("Post")
public class Post extends ParseObject{


	public Post(){

	}

	public String getCourse(){
//        try {
//            return fetchIfNeeded().getString("ClassName");
//        } catch (ParseException e) {
//            e.printStackTrace();
//            return "";
//        }
 return getString("Course");

    }

	public void setClassName(String course){
		put("Course",course);
	}

	public String getLocation(){
		return getString("Location");
	}

	public void setLocation(String location){
		put("Location",location);
	}

	public String getClassTimeDate(){
		return getString("Timedate");
	}

	public void setClassTimeDate(String timeNdate){
		put("Timedate",timeNdate);
	}




	public String getGroupSize(){
		return getString("Groupsize");
	}

	public void setGroupSize(String groupSize){
		put("Groupsize",groupSize);
	}

 public String getCurrentGroupSize(){
    return getString("Current Group Size");
 }

 public void setCurrentGroupSize(String currentGroupSize){
    put("Groupsize",currentGroupSize);
 }


 public int getCounter(){
    String toParse = getString("Counter");
    int toReturn = Integer.parseInt(toParse);
    return toReturn;
 }

 public void incrementCounter(String toParse){
    int toReturn = Integer.parseInt(toParse);
    toReturn++;
    toParse = Integer.toString(toReturn);
    put("Counter",toParse);
 }

 public void decrementCoutner(String toParse){
    int toReturn = Integer.parseInt(toParse);
    toReturn--;
    toParse = Integer.toString(toReturn);
    put("Counter",toParse);
 }

 public void resetCounter(){
    int toReturn = 0;
    String toParse = Integer.toString(toReturn);
    put("Counter",toParse);
 }

}