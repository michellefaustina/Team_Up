package com.sourcey.TeamUp;

import com.parse.ParseClassName;
import com.parse.ParseException;
import com.parse.ParseObject;

@ParseClassName("Post")
public class Post extends ParseObject{
	/*
	Fields for Post: Counter, Post Name, Location, Time, Description
	*/

	public String getClassName() {
		try {
			return this.fetchIfNeeded().getString("ClassName");
		} catch (ParseException e) {
			e.printStackTrace();
			return "";
		}
	}

	public void setClassName(String className){
		put("ClassName",className);
	}

	public String getLocation()  {
		try {
			return this.fetchIfNeeded().getString("Location");
		} catch (ParseException e) {
			e.printStackTrace();
			return "";
		}
	}

	public void setLocation(String location){
		put("Location",location);
	}

	public String getClassTime(){
		try {
			return this.fetchIfNeeded().getString("Time");
		} catch (ParseException e) {
			e.printStackTrace();
			return "";
		}
	}

	public void setClassTime(String time){
		put("Time",time);
	}

	public String getDate(){
		try {
			return this.fetchIfNeeded().getString("Date");
		} catch (ParseException e) {
			e.printStackTrace();
			return "";
		}
	}

	public void setDate(String Date){
		put("Date",Date);
	}


	public String getGroupSize() {
		try {
			return this.fetchIfNeeded().getString("Group Size");
		} catch (ParseException e) {
			e.printStackTrace();
			return "";
		}
	}

	public void setGroupSize(String groupSize){
		put("Date",groupSize);
	}

	public String getCurrentGroupSize() {
		try {
			return this.fetchIfNeeded().getString("Current Group Size");
		} catch (ParseException e) {
			e.printStackTrace();
			return "";
		}
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