package com.dal_csci3130.course_registration;

import com.google.firebase.database.Exclude;

import java.io.Serializable;
import java.util.ArrayList;
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
	public  String enddate;
	public  String faculty;
	public  String location;
	public ArrayList<String> prereq;
	public  String professor;
	public  String rem;
	public  String section;
	public  String startdate;
	public  String subject;
	public  String term;
	public  String time;
	public  String title;
	public  String year;
	
	
	
    public Course() {
        // Default constructor required for calls to DataSnapshot.getValue
    }

    public Course(String WL_Act, String WL_Cap, String WL_Rem, String act,
	String cap, String cred, String days, String description, String enddate,
	String faculty, String location, ArrayList<String> prereq, String professor,
	String rem, String section, String startdate, String subject, String term,
	String time, String title, String year){
        this.WL_Act = WL_Act;
		this. WL_Cap = WL_Cap;
		this.WL_Rem = WL_Rem;
		this.act = act;
		this.cap = cap;
		this.cred = cred;
		this.days = days;
		this.description = description;
		this.enddate = enddate;
		this.faculty = faculty;
		this.location = location;
		this.prereq = prereq;
		this. professor = professor;
		this.rem = rem;
		this.section = section;
		this.startdate = startdate;
		this.subject = subject;
		this.term = term;
		this.time = time;
		this.title = title;
		this.year = year;
	}
	
    @Exclude
    public Map<String, Object> toMap(){
        HashMap<String, Object> result = new HashMap<>();
        result.put("WL_Act", WL_Act);
		result.put("WL_Cap", WL_Cap);
		result.put("WL_Rem", WL_Rem);
		result.put("act", act);
		result.put("cap", cap);
		result.put("cred", cred);
		result.put("days", days);
		result.put("description", description);
		result.put("enddate", enddate);
        result.put("faculty", faculty);
        result.put("location", location);
        result.put("prereq", prereq);
        result.put("professor", professor);
        result.put("rem", rem);
        result.put("section", section);
        result.put("startdate", startdate);
        result.put("subject", subject);
        result.put("term", term);
        result.put("time", time);
        result.put("title", year);

        return result;
    }
}