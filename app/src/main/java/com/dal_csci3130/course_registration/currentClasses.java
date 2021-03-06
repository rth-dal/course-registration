package com.dal_csci3130.course_registration;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class currentClasses extends AppCompatActivity {

    private User user;

    private ArrayList<Course> courseList = new ArrayList<Course>();
    private ListView results_List;

    public ArrayAdapter<Course> results_Adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_classes);
        Intent i = getIntent();
        user = (User) i.getSerializableExtra("user");
        courseList = user.getCurrent();


        //drop_Button = this.findViewById(R.id.dropButton);
        //Gets filter conditions





        results_List = this.findViewById(R.id.resultsList);
        results_Adapter = new ArrayAdapter<Course>(this, android.R.layout.simple_list_item_1, courseList);
        results_List.setAdapter(results_Adapter);
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        Intent intent = new Intent();
        intent.putExtra("user", user);
        setResult(0, intent);
        finish();
    }
}

