package com.dal_csci3130.course_registration;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Course implements Serializable {

	public  String WL_Act;
	public  String WL_Cap;
	public  String WL_Rem;
	public  String act;
	public  String cap;
	public  String cred;
	public  String days;
	public  String description;
	public  String end_date;
	public  String faculty;
	public  String location;
	public  ArrayList<String> pre-req;
	public  String professor;
	public  String rem;
	public  String section;
	public  String start_date;
	public  String subject;
	public  String term;
	public  String time;
	public  String title;
	public  String year;
	
	
	
    public Course() {
        // Default constructor required for calls to DataSnapshot.getValue
    }

    public Course(String WL_Act, String WL_Cap, String WL_Rem, String act,
	String cap, String cred, String days, String description, String end_date, 
	String faculty, String location, ArrayList<String> pre-req, String professor,
	String rem, String section, String start_data, String subject, String term,
	String time, String title, String year){
        this.WL_Act = WL_Act;
		this. WL_Cap = WL_Cap;
		this.WL_Rem = WL_Rem;
		this.act = act;
		this.cap = cap;
		this.cred = cred;
		this.days = days;
		this.description = description;
		this.end_data = end_data;
		this faculty = faculty;
		this.location = location;
		this.pre-req = pre-req;
		this. professor = professor;
		this.rem = rem;
		this.section = section;
		this.start_data = start_data;
		this.subject = subject;
		this.term = term;
		this.time = time;
		this.title = title;
		this.year = year;
	}
	
    @Exclude
    public Map<String, Object> toMap(){
        HashMap<String, Object> result = new HashMap<>();
        result.put("faculty", faculty);
        result.put("year", year);
        result.put("cid", cid);

        return result;
    }
}