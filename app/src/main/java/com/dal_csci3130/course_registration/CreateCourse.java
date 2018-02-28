package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.dal_csci3130.course_registration.Course;
import com.dal_csci3130.course_registration.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class CreateCourseActivity extends Activity {

	private Button submitButton;
    private EditText facultyField, yearField;
    private MyApplicationData appState;
	
	private DatabaseReference courselistReference;
	ArrayList<Course> courselist = new ArrayList<>();
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_contact_acitivity);
        //Get the app wide shared variables
        appState = ((MyApplicationData) getApplicationContext());

        submitButton = (Button) findViewById(R.id.submitButton);
        facultyField = (EditText) findViewById(R.id.faculty);
        yearField = (EditText) findViewById(R.id.year);
		
		courselistReference = FirebaseDatabase.getInstance().getReference().child("courses");
		courselistReference.addValueEventListener(new ValueEventListener() {
			@Override
			public void onDataChange(DataSnapshot dataSnapshot) {
				//get all courses in datasnap
				Course course = dataSnapshot.getValue(Post.class);
				System.out.println(course);
			}
				
			@Override
			public void onCancelled(DatabaseError databaseError) {
				//handle databaseError
				System.out.println("The read failed: "+databaseError.getCode());
			}
		});
	}

    public void infoButton(View v) {
        //each entry needs a unique ID
        String faculty = facultyField.getText().toString();
        String year = yearField.getText().toString();

		// to-do:
		//create new object for all cids		
		//get cid somehow of all faculty+year
        for (all cids of given faculty+year) {
			String courseID = appState.firebaseReference.push().getKey();
			Course course = new Course(faculty, year, courseID);
			course.generate();
		}
        
		appState.firebaseReference.child(personID).setValue(course);
    }
}