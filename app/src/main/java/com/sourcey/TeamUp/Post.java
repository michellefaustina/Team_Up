package com.sourcey.TeamUp;

import com.parse.ParseClassName;
import com.parse.ParseObject;

@ParseClassName("Post")
public class Post extends ParseObject{
	/*
	Fields for Post: Counter, Post Name, Location, Time, Description
	*/

	public String getClassName(){
		return getString("Class Name");
	}

	public void setClassName(String className){
		put("Class Name",className);
	}

	public String getLocation(){
		return getString("Location");
	}

	public void setLocation(String location){
		put("Location",location);
	}

	public String getClassTime(){
		return getString("Time");
	}

	public void setClassTime(String time){
		put("Time",time);
	}

	public String getDate(){
		return getString("Date");
	}

	public void setDate(String Date){
		put("Date",Date);
	}


	public String getGroupSize(){
		return getString("Group Size");
	}

	public void setGroupSize(String groupSize){
		put("Date",groupSize);
	}

	public String getCurrentGroupSize(){
		return getString("Current Group Size");
	}

	public void setCurrentGroupSize(String currentGroupSize){
		put("Date",currentGroupSize);
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