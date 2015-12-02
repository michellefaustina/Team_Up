package com.sourcey.TeamUp;

import com.parse.ParseClassName;
import com.parse.ParseException;
import com.parse.ParseObject;

public class Group{

	private String classname;
	private String location;
	private String timedate;
	private String groupsize;


	public Group(){

	}

	public String getClassName(){
            return classname;
    }

	public void setClassName(String className){
		classname = className;
	}

	public String getLocation(){
		return location;
	}

	public void setLocation(String location){
		this.location = location;
	}

	public String getClassTimeDate(){
		return timedate;
	}

	public void setClassTimeDate(String timeNdate){
		timedate = timeNdate;
	}




	public String getGroupSize(){
		return groupsize;
	}

	public void setGroupSize(String groupSize){
		groupsize = groupSize;
	}

// public String getCurrentGroupSize(){
//    return getString("Current Group Size");
// }
//
// public void setCurrentGroupSize(String currentGroupSize){
//    put("Date",currentGroupSize);
// }
//
//
// public int getCounter(){
//    String toParse = getString("Counter");
//    int toReturn = Integer.parseInt(toParse);
//    return toReturn;
// }
//
// public void incrementCounter(String toParse){
//    int toReturn = Integer.parseInt(toParse);
//    toReturn++;
//    toParse = Integer.toString(toReturn);
//    put("Counter",toParse);
// }
//
// public void decrementCoutner(String toParse){
//    int toReturn = Integer.parseInt(toParse);
//    toReturn--;
//    toParse = Integer.toString(toReturn);
//    put("Counter",toParse);
// }
//
// public void resetCounter(){
//    int toReturn = 0;
//    String toParse = Integer.toString(toReturn);
//    put("Counter",toParse);
// }

}