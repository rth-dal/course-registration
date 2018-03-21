package com.dal_csci3130.course_registration;


import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;


import com.google.firebase.database.FirebaseDatabase;
import com.firebase.ui.database.FirebaseListAdapter;



import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;

public class DataBase extends Activity implements Serializable {

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

	public void initialize() {
		////GET ALL DB OBJECTS

		AppData appData = (AppData) getApplication();

		//Get the app wide shared variables

		//Set-up Firebase
		appData.firebaseDBInstance = FirebaseDatabase.getInstance();
		appData.firebaseReference = appData.firebaseDBInstance.getReference("courses/");

		//Get the reference to the UI contents
		//courseListView = (ListView) findViewById(R.id.listView);
		//Set up the List View
		FirebaseListAdapter<Course> firebaseAdapterCourse = new FirebaseListAdapter<Course>(this, Course.class,
				android.R.layout.simple_list_item_1, appData.firebaseReference) {

			@Override
			protected void populateView(View v, Course model, int position) {
				courselist.add(model);
				System.out.println(courselist);
			}
		};

		/*Course course1 = new Course("0","20","20","91","115","3.000","TR","Implementing Agile workstyle as a team","04/06","CSCI","Psychology building","{CSCI2110 : C|CSCI2111 : C}","Juliano Franz","24","01","01/08/2018","CSCI","winter","14:35-15:55","Software Engineering","3130");
		Course course2 = new Course("0","20","20","91","100","3.000","MWF","Introduction to Cryptography","04/06","CSCI","LSC","{CSCI2110 : C|CSCI2111 : C}","Peter Selinger","9","01","01/08/2018","CSCI","winter","14:35-15:25","Cryptography","4116");

		courselist.add(course1);
		courselist.add(course2);

*/
		ArrayList<Course> current = new ArrayList<Course>();
		current.add(courselist.get(0));

		ArrayList<Course> remaining = new ArrayList<Course>();
		remaining.add(courselist.get(1));


		appData.firebaseReference = appData.firebaseDBInstance.getReference("users/");

		FirebaseListAdapter<User> firebaseAdapterUser = new FirebaseListAdapter<User>(this, User.class,
				android.R.layout.simple_list_item_1, appData.firebaseReference) {
			@Override
			protected void populateView(View v, User model, int position) {
				userlist.add(model);
				System.out.println(userlist);
			}
		};

		// email, String first_name, String completed, String current, String remaining, String last_name, String password, String username
		//User user1 = new User("admin@dal.ca", "john", null, current, remaining, "doe", "admin", "admin");
		//userlist.add(user1);

	}

	public void updateUser(User user) {
		//Given a user, change to given user
	}

	public void updateCourse(Course course) {
		//Given a course, change to given course
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