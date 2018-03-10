package com.dal_csci3130.course_registration;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * Created by AJM-D on 2018-02-22.
 * This class is used to search for information using filters.
 *
 */

public class Main2Activity extends AppCompatActivity {

    public String Filter1;
    public String Filter2;
    public String Filter3;
    public int year;
    public int seats;
    public String results;
    TextView text2, text3, text4, text5, text6;
    Button Apply_Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Creates the view
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_view_results);
        //Creation of the spinners used to display the string array filters
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
        text6 = this.findViewById(R.id.textView6);


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
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
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
                        Filter2 = "5";
                        break;
                    case 5:
                        Filter2 = "6";
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
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



    public void filterApply(View v){

        //results of query
        ArrayList<Course> results = new ArrayList<Course>();
        String tmp_string = "";

        //parses string input to int
        String year = (Filter2);
        String seats = (Filter3);
        String faculty = "CSCI";

        filtered_search search_instance = new filtered_search();
        results = search_instance.QUERY_COURSES_DB(faculty,year, seats);

        //temporary string conversion of output
        for (int i = 0; i<results.size();i++) {
            tmp_string += results.get(i).getFaculty()+results.get(i).getYear()+" "+results.get(i).getRem()+" seats remaining\n";
        }

        text6.setText(tmp_string);

    }
}
