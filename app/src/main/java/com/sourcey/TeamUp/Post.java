package com.sourcey.TeamUp;

import com.parse.ParseClassName;
import com.parse.ParseObject;

@ParseClassName("Post")
public class Post extends ParseObject{


    public Post(){

    }

	public String getClassName(){
		return getString("ClassName");
	}

	public void setClassName(String className){
		put("ClassName",className);
	}

	public String getLocation(){
		return getString("Location");
	}

	public void setLocation(String location){
		put("Location",location);
	}

	public String getClassTimeDate(){
		return getString("TimeNdate");
	}

	public void setClassTimeDate(String timeNdate){
		put("TimeNdate",timeNdate);
	}




	public String getGroupSize(){
		return getString("GroupSize");
	}

	public void setGroupSize(String groupSize){
		put("GroupSize",groupSize);
	}

//	public String getCurrentGroupSize(){
//		return getString("Current Group Size");
//	}
//
//	public void setCurrentGroupSize(String currentGroupSize){
//		put("Date",currentGroupSize);
//	}


//	public int getCounter(){
//		String toParse = getString("Counter");
//		int toReturn = Integer.parseInt(toParse);
//		return toReturn;
//	}
//
//	public void incrementCounter(String toParse){
//		int toReturn = Integer.parseInt(toParse);
//		toReturn++;
//		toParse = Integer.toString(toReturn);
//		put("Counter",toParse);
//	}
//
//	public void decrementCoutner(String toParse){
//		int toReturn = Integer.parseInt(toParse);
//		toReturn--;
//		toParse = Integer.toString(toReturn);
//		put("Counter",toParse);
//	}
//
//	public void resetCounter(){
//		int toReturn = 0;
//		String toParse = Integer.toString(toReturn);
//		put("Counter",toParse);
//	}

}
