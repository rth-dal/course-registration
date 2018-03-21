package com.dal_csci3130.course_registration;

import com.google.firebase.database.Exclude;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class User implements Serializable {

	private String email;
	private String first_name;
	private ArrayList<Course> completed;
	private ArrayList<Course> current;
	private String last_name;
	private String password;
	private String bannerID;


	public User() {
		// Default constructor required for calls to DataSnapshot.getValue
	}

	public User(String email, String first_name,
				String last_name, String password, String bannerID) {
		this.email = email;
		this.first_name = first_name;
		this.last_name = last_name;
		this.password = password;
		this.bannerID = bannerID;
	}

	public ArrayList<Course> getCompleted() { return completed;}
	public void setCompleted(ArrayList<Course> completed) {this.completed=completed;}
	public ArrayList<Course> getCurrent() { return completed;}
	public void setCurrent(ArrayList<Course> current) {this.current=current;}
	public ArrayList<Course> getRemaining() { return completed;}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String Password) {
		this.password = password;
	}
	public String getBannerID() {
		return bannerID;
	}
	public void setBannerID(String bannerID) {
		this.bannerID = bannerID;
	}


	@Exclude
	public Map<String, Object> toMap(){
		HashMap<String, Object> result = new HashMap<>();
		result.put("e-mail", email);
		result.put("first_name", first_name);
		result.put("last_name", last_name);
		result.put("password", password);
		result.put("bannerID", bannerID);

		return result;
	}
}