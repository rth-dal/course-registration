package com.dal_csci3130.course_registration;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * Created by AJM-D on 2018-02-22.
 * This class is used to search for and show class information using filters.
 */

public class Main2Activity extends AppCompatActivity {

    //myApplication myapp = (myApplication)getApplication();
    //User user = myapp.getUser();

    public String Filter1, Filter2, Filter3, results;
    public User user;
    public int year, seats;
    ArrayList<Course> courseList = new ArrayList<Course>();
    ArrayList<Course> database_results = new ArrayList<Course>();
    TextView text2, text3, text4, text5;
    ListView results_List;
    Button Apply_Button;
    Course CSCI3130 = new Course();
    Course CSCI3160 = new Course();
    public ArrayAdapter results_Adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Creates the view
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_view_results);

        Intent i = getIntent();
        user = (User) i.getSerializableExtra("user");


        //Creation of the spinners used to display the string array filters.
        Spinner spinner = findViewById(R.id.spinner2);
        Spinner spinner2 = findViewById(R.id.spinner3);
        Spinner spinner3 = findViewById(R.id.spinner4);
        //Calls the array to be displayed
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.faculty_array, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.year_array, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this, R.array.seat_array, android.R.layout.simple_spinner_item);
        //Sets the adapters view from resource
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Sets the spinner
        spinner.setAdapter(adapter);
        spinner2.setAdapter(adapter2);
        spinner3.setAdapter(adapter3);
        //Creation of button
        Apply_Button = this.findViewById(R.id.applyButton);
        //Gets filter conditions
        Filter1 = spinner.getSelectedItem().toString();
        Filter2 = spinner2.getSelectedItem().toString();
        Filter3 = spinner3.getSelectedItem().toString();
        //Creates text
        text2 = this.findViewById(R.id.textView2);
        text3 = this.findViewById(R.id.textView3);
        text4 = this.findViewById(R.id.textView4);
        text5 = this.findViewById(R.id.textView5);


        results_List = this.findViewById(R.id.resultsList);
        results_Adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, database_results);
        results_List.setAdapter(results_Adapter);


        //Adapter of faculty
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        Filter1 = "CSCI";
                        break;
                    case 1:
                        Filter1 = "MATH";
                        break;
                    case 2:
                        Filter1 = "MGMT";
                        break;
                    case 3:
                        Filter1 = "POLI";
                        break;
                    case 4:
                        Filter1 = "BIOL";
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        //Adapter of year
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        Filter2 = "1";
                        break;
                    case 1:
                        Filter2 = "2";
                        break;
                    case 2:
                        Filter2 = "3";
                        break;
                    case 3:
                        Filter2 = "4";
                        break;
                    case 4:
                        Filter2 = "6";
                        break;
                    case 5:
                        Filter2 = "8";
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        //Adapter for seat capacity
        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        Filter3 = "50";
                        break;
                    case 1:
                        Filter3 = "100";
                        break;
                    case 2:
                        Filter3 = "150";
                        break;
                    case 3:
                        Filter3 = "200";
                        break;
                    case 4:
                        Filter3 = "300";
                        break;
                    case 5:
                        Filter3 = "400";
                        break;
                    case 6:
                        Filter3 = "500";
                        break;
                    case 7:
                        Filter3 = "600";
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void filterApply(View v) {
        //results of query
        String tmp_string = "";

        //parses string input to int
        String year = (Filter2);
        String seats = (Filter3);
        String faculty = (Filter1);
        results_Adapter.clear();
        ArrayList<Course> tmp_results = new ArrayList<Course>();
        filtered_search search_instance = new filtered_search();

        //((myApplication) this.getApplication()).setCourses(db.getCourselist());

        tmp_results = search_instance.QUERY_COURSES_DB(faculty, year, seats);

        results_Adapter.addAll(tmp_results);

    }
    //This method determines if the user's database profile already has the selected course.

    /**
     * Method is used to compare completed list with inputted parameter.
     *
     * @param filterSelection
     * @return
     */
    public boolean notCompleted(String filterSelection) {
        CSCI3130.setTitle("CSCI3130");
        CSCI3160.setTitle("CSCI3160");
        courseList.add(CSCI3130);
        courseList.add(CSCI3160);
        User ul = new User("aj.mantolino@dal.ca", "AJ", courseList, null, null, "Mantolino", "pA$$w0rD", "theMan");
        boolean notCompleted = true;
        //loops through to compare if there's a match.
        for (int i = 0; i < ul.getCompleted().size(); i++) {
            //If there's a match with the registered course and selected filter
            if (filterSelection.equalsIgnoreCase(ul.getCompleted().get(i).getTitle()))
                notCompleted = false;

        }
        return notCompleted;
    }

    /**
     * Method tests to see the type of access.
     *
     * @param filterSelection
     * @return
     */
    //This method looks at if the student has completed a class already and makes the appropriate action.
    public boolean denyAccess(String filterSelection) {
        boolean noAccess = true;
        noAccess = this.notCompleted(filterSelection);
        return noAccess;
    }

    /**
     * Method tests if error is correctly given.
     *
     * @param filterSelection
     * @return
     */
    //This method determines if the user was given access or not and gives the appropriate error.
    public boolean throwError(String filterSelection) {
        boolean noError = true;
        noError = this.denyAccess(filterSelection);
        return noError;

    }

    /**
     * This method is used to compare all times of the courses with the selected registered time.
     *
     * @param time
     * @return
     */
    public boolean timeError(String time) {
        courseList.add(CSCI3130);
        courseList.add(CSCI3160);
        User ul = new User("aj.mantolino@dal.ca", "AJ", courseList, null, null, "Mantolino", "pA$$w0rD", "theMan");
        CSCI3130.setTime("1100");
        CSCI3160.setTime("1200");
        boolean Error = false;
        for (int i = 0; i < ul.getCompleted().size(); i++) {
            if (time.equalsIgnoreCase(ul.getCompleted().get(i).getTime()))
                Error = true;
        }
        return Error;
    }

    /**
     * Checks time error.
     *
     * @param time
     * @return
     */
    public boolean deniedTime(String time) {
        boolean noAccess = true;
        noAccess = this.timeError(time);
        return noAccess;
    }

    /**
     * This method checks if there is an error and gives proper error.
     *
     * @param time
     * @return
     */

    public boolean timeErrorThrown(String time) {
        boolean noError = false;
        noError = this.deniedTime(time);
        return noError;
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
