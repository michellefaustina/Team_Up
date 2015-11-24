package com.sourcey.TeamUp;
import com.parse.ParseClassName;
import com.parse.ParseObject;

@ParseClassName("Student")
public class Student extends ParseObject{
	/*
	Fields for each Student: Email, Username, Password, Major, Course, Groups
	*/

	public String getEmail(){
		return getString("Email");
	}

	public void setEmail(String email){
		put("Email",email);
	}

	public String getUserName(){
		return getString("Username");
	}

	public void setUserName(String userName){
		put("Username",userName);
	}

	public String getPassword(){
		return getString("Password");
	}

	public void setPassword(String passWord){
		put("Password",passWord);
	}

	public String getMajor(){
		return getString("Major");
	}

	public void setMajor(String major){
		put("Major", major);
	}

	public String getCourseName(){
		return getString("Class");
	}

	public void setCourseName(String courseName){
		put("Class",courseName);
	}


}





