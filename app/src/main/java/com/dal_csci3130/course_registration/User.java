package com.dal_csci3130.course_registration;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class User implements Serializable {
	
	public String email;
	public String first_name;
	public ArrayList<String> info;
	public String last_name;
	public String password;
	public String username;
	
    public User() {
    // Default constructor required for calls to DataSnapshot.getValue
    }
	
	public User(String email, String first_name, ArrayList<String> info,
	String last_name, String password, String username) {
		this.email = email;
		this.first_name = first_name;
		this.info = info;
		this.last_name = last_name;
		this.password = password;
		this.username = username;
	}

	@Exclude
    public Map<String, Object> toMap(){
        HashMap<String, Object> result = new HashMap<>();
        result.put("e-mail", email);
        result.put("first_name", first_name);
        result.put("info", info);
		result.put("last_name", last_name);
		result.put("password", password);
		result.put("username", username);
		
        return result;
    }
}