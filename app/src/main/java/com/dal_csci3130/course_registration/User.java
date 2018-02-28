package com.dal_csci3130.course_registration;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class User implements Serializable {
	
	public String e-mail;
	public String first_name;
	public String info;
	public String last_name;
	public String password;
	public String username;
	
    public User() {
    // Default constructor required for calls to DataSnapshot.getValue
    }
	
	public User(String e-mail, String first_name, ArrayList<String> info, 
	String last_name, String password, String username) {
		this.e-mail = e-mail;
		this.first_name = first_name;
		this.info = info;
		this.last_name = last_name;
		this.password = password;
		this.username = username;
	}

	@Exclude
    public Map<String, Object> toMap(){
        HashMap<String, Object> result = new HashMap<>();
        result.put("e-mail", e-mail);
        result.put("first_name", first_name);
        result.put("info", info);
		result.put("last_name", last_name);
		result.put("password", password);
		result.put("username", username);
		
        return result;
    }
}
