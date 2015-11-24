package com.sourcey.TeamUp;

import com.parse.ParseClassName;
import com.parse.ParseObject;

@ParseClassName("Group")
public class Group extends ParseObject{
	/*
	Fields for Group: Counter, Group Name, Location, Time, Description
	*/

	public String getGroupName(){
		return getString("GroupName");
	}

	public void setGroupName(String groupName){
		put("GroupName",groupName);
	}

	public String getLocation(){
		return getString("Location");
	}

	public void setLocation(String location){
		put("Location",location);
	}

	public String getTime(){
		return getString("Time");
	}

	public void setTime(String groupTime){
		put("Time",groupTime);
	}

	public String getDescription(){
		return getString("Description");
	}

	public void setDescription(String description){
		put("Description",description);
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