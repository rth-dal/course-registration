package com.dal_csci3130.course_registration;


import com.google.firebase.database.Exclude;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Course implements Serializable {

	private String WL_Act;
	private String WL_Cap;
	private String WL_Rem;
	private String act;
	private String cap;
	private String cred;
	private String days;
	private String description;
	private String enddate;
	private String faculty;
	private String location;
	private String prereq;
	private String professor;
	private String rem;
	private String section;
	private String startdate;
	private String subject;
	private String term;
	private  String time;
	private  String title;
	private String year;


	public Course() {
		// Default constructor required for calls to DataSnapshot.getValue
	}

	public Course(String WL_Act, String WL_Cap, String WL_Rem, String act,
				  String cap, String cred, String days, String description, String enddate,
				  String faculty, String location, String prereq, String professor,
				  String rem, String section, String startdate, String subject, String term,
				  String time, String title, String year){
		this.WL_Act = WL_Act;
		this.WL_Cap = WL_Cap;
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
		this.professor = professor;
		this.rem = rem;
		this.section = section;
		this.startdate = startdate;
		this.subject = subject;
		this.term = term;
		this.time = time;
		this.title = title;
		this.year = year;
	}


	public String getYear() {
		return year;
	}
	public String getTitle() {
		return title;
	}
	public String getTime() {
		return time;
	}
	public String getTerm() {
		return term;
	}
	public String getSubject() {
		return subject;
	}
	public String getStartdate() {
		return startdate;
	}
	public String getSection() {
		return section;
	}
	public String getRem() {
		return rem;
	}
	public String getProfessor() {
		return professor;
	}
	public String getPrereq() {
		return prereq;
	}
	public String getLocation() {
		return location;
	}
	public String getFaculty() {
		return faculty;
	}
	public String getEnddate() {
		return enddate;
	}
	public String getDescription() {
		return description;
	}
	public String getDays() {
		return days;
	}
	public String getCred() {
		return cred;
	}
	public String getCap() {
		return cap;
	}
	public String getAct() {
		return act;
	}
	public String getWL_Rem() {
		return this.WL_Rem;
	}
	public String getWL_Cap() {
		return this.WL_Cap;
	}
	public String getWL_Act() {
		return this.WL_Act;
	}

	boolean stringify() {

		System.out.println(this.subject+"\n"+this.title+"\n"+this.year+"\n"+this.time+"\n"+this.term+"\n"+this.startdate+"\n"+this.section+"\n"+this.rem+"\n"+this.professor+"\n"+this.prereq+"\n"+this.location+"\n"+this.faculty+"\n"+this.enddate+"\n"+this.description+"\n"+this.days+"\n"+this.cred+"\n"+this.cap+"\n"+this.act+"\n"+this.WL_Rem+"\n"+this.WL_Act+"\n"+this.WL_Cap);

		return true;
	}

	boolean exists() {
		return true;
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