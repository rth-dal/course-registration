package com.dal_csci3130.course_registration;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class profile extends AppCompatActivity {

    public String Faculty;
    public String Major;
    public String Minor;
    public User user;

    ListView classList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Intent i = getIntent();
        user = (User) i.getSerializableExtra("user");


        TextView welcomeMessage = (TextView)findViewById(R.id.welcome);




        if (user != null) {

            welcomeMessage.setText("Welcome, " + user.getFirst_name());

            classList = (ListView)findViewById(R.id.classList);

            ArrayList<Course> courseList = user.getCurrent();

            ArrayList<String> test = new ArrayList<String>();
            for(int j=0; j<courseList.size(); j++)  {
                test.add(courseList.get(j).getTitle());
            }

            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, test);

            classList.setAdapter(arrayAdapter);

        }


        Button classSearch = (Button) findViewById(R.id.classSearch);
        Spinner facultySpinner = (Spinner) findViewById(R.id.facultyspinner);
        Spinner majorSpinner = (Spinner) findViewById(R.id.majorspinner);
        Spinner minorSpinner = (Spinner) findViewById(R.id.minorspinner);

        ArrayAdapter<CharSequence> facultyAdapter = ArrayAdapter.createFromResource(this, R.array.faculty_array2, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> majorAdapter = ArrayAdapter.createFromResource(this, R.array.major_array, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> minorAdapter = ArrayAdapter.createFromResource(this, R.array.minor_array, android.R.layout.simple_spinner_item);

        facultyAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        majorAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        minorAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        facultySpinner.setAdapter(facultyAdapter);
        majorSpinner.setAdapter(majorAdapter);
        minorSpinner.setAdapter(minorAdapter);

        Faculty = facultySpinner.getSelectedItem().toString();
        Major = majorSpinner.getSelectedItem().toString();
        Minor = minorSpinner.getSelectedItem().toString();


        classSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(profile.this, Main2Activity.class);
                intent.putExtra("user", user);
                startActivityForResult(intent,0);



            }
        });

        facultySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        Faculty = "";
                        break;
                    case 1:
                        Faculty = "BCS";
                        break;
                    case 2:
                        Faculty = "BACS";
                        break;
                    case 3:
                        Faculty = "BSC";
                        break;
                    case 4:
                        Faculty = "BCOMM";
                        break;
                    case 5:
                        Faculty = "BA";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        majorSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        Major = "";
                        break;
                    case 1:
                        Major = "Computer Science";
                        break;
                    case 2:
                        Major = "Mathematics";
                        break;
                    case 3:
                        Major = "Management";
                        break;
                    case 4:
                        Major = "Biology";
                        break;
                    case 5:
                        Major = "Political Science";
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        minorSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        Minor = "";
                        break;
                    case 1:
                        Minor = "Computer Science";
                        break;
                    case 2:
                        Minor = "Math";
                        break;
                    case 3:
                        Minor = "Management";
                        break;
                    case 4:
                        Minor = "Biology";
                        break;
                    case 5:
                        Minor = "Political Science";
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }


    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        user = (User) data.getSerializableExtra("user");
    }
}
