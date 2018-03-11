package com.dal_csci3130.course_registration;


import android.content.Context;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;

public class DataBase implements Serializable {

	private ArrayList<Course> courselist;
	private ArrayList<User> userlist;

	public DataBase() {
		courselist = new ArrayList<Course>();
		userlist = new ArrayList<User>();
	}

	public DataBase(ArrayList<Course> courselist, ArrayList<User> userlist) {
		this.courselist = courselist;
		this.userlist = userlist;
	}



	public String ReadFromfile(String fileName, Context context) {
		StringBuilder returnString = new StringBuilder();
		InputStream fIn = null;
		InputStreamReader isr = null;
		BufferedReader input = null;
		try {
			fIn = context.getResources().getAssets()
					.open(fileName, Context.MODE_WORLD_READABLE);
			isr = new InputStreamReader(fIn);
			input = new BufferedReader(isr);
			String line = "";
			while ((line = input.readLine()) != null) {
				returnString.append(line);
			}
		} catch (Exception e) {
			e.getMessage();
		} finally {
			try {
				if (isr != null)
					isr.close();
				if (fIn != null)
					fIn.close();
				if (input != null)
					input.close();
			} catch (Exception e2) {
				e2.getMessage();
			}
		}
		return returnString.toString();
	}


	public void initialize() {
		////GET ALL DB OBJECTS

		Course course1 = new Course("0","20","20","91","115","3.000","TR","Implementing Agile workstyle as a team","04/06","CSCI","Psychology building","{CSCI2110 : C|CSCI2111 : C}","Juliano Franz","24","01","01/08/2018","CSCI","winter","14:35-15:55","Software Engineering","3130");
		Course course2 = new Course("0","20","20","91","100","3.000","MWF","Introduction to Cryptography","04/06","CSCI","LSC","{CSCI2110 : C|CSCI2111 : C}","Peter Selinger","9","01","01/08/2018","CSCI","winter","14:35-15:25","Cryptography","4116");

		courselist.add(course1);
		courselist.add(course2);


		// email, String first_name, String completed, String current, String remaining, String last_name, String password, String username
		User user1 = new User("admin@dal.ca", "john", "classes-completed", "classes-current", "classes-remaining", "doe", "admin", "admin");
		userlist.add(user1);

		//String file = ReadFromfile("coursefile",null);
            /*
            while ((line = bufferedReader.readLine())!= null) {
                stringBuffer.append(line);
                String[] splitArray = line.split(";+");
                Course course = new Course(splitArray[0],splitArray[1],splitArray[2],splitArray[3],splitArray[4],splitArray[5],splitArray[6],splitArray[7],splitArray[8],
                        splitArray[9],splitArray[10],splitArray[11],splitArray[12],splitArray[13],splitArray[14],splitArray[15],splitArray[16],splitArray[17],splitArray[18],splitArray[19],splitArray[20]);
                addCourse(course);
            }
            fileReader.close();
            */
	}

	public void addCourse(Course course) {
		courselist.add(course);
	}

	public Course getCourse(Course course) {
		return courselist.get(courselist.indexOf(course));
	}

	public void addUser(User user) {
		userlist.add(user);
	}

	public User getUser(User user) {
		return userlist.get(userlist.indexOf(user));
	}

	public ArrayList<User> getUserlist() {
		return userlist;
	}

	public ArrayList<Course> getCourselist() {
		return courselist;
	}

	public boolean exists() {
		return true;
	}
}