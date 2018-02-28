package com.dal_csci3130.course_registration;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ArrayAdapter;

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
    TextView text,text2,text3;
    Button Apply_Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Creates the view
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_view_results);
        //Creation of the spinners used to display the string array filters
        Spinner spinner = (Spinner) findViewById(R.id.spinner2);
        Spinner spinner2 = (Spinner) findViewById(R.id.spinner3);
        Spinner spinner3 = (Spinner) findViewById(R.id.spinner4);
        //Calls the array to be displayed
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.faculty_array, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,R.array.year_array, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this,R.array.seat_array, android.R.layout.simple_spinner_item);
        //Sets the adapters view from resource
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Sets the spinner
        spinner.setAdapter(adapter);
        spinner2.setAdapter(adapter2);
        spinner3.setAdapter(adapter3);
        //Creation of button
        Apply_Button = (Button) this.findViewById(R.id.applyButton);
        //Gets filter conditions
        Filter1=spinner.getSelectedItem().toString();
        Filter2=spinner2.getSelectedItem().toString();
        Filter3=spinner3.getSelectedItem().toString();
        //Creates text
        text = (TextView) this.findViewById(R.id.textView6);
        text2 = (TextView) this.findViewById(R.id.textView7);
        text3 = (TextView) this.findViewById(R.id.textView8);
    }

    public void filterApply(View v){

        text.setText(Filter1);
        year=Integer.parseInt(Filter2);
        seats=Integer.parseInt(Filter3);

        filtered_search search_instance = new filtered_search();

        results = search_instance.QUERY_DB(Filter1, year, seats);
    }
}
