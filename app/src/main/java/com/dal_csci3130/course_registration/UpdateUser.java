package com.dal_csci3130.course_registration;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;

public class UpdateUser extends Activity {

    private EditText bannerIDField, firstNameField,lastNameField, passwordField, emailField;
    private AppData appState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_user);
        //Get the app wide shared variables
        appState = (AppData) getApplicationContext();

        bannerIDField = (EditText) findViewById(R.id.bannerID);
        firstNameField= (EditText) findViewById(R.id.firstName);
        lastNameField = (EditText) findViewById(R.id.lastName);
        passwordField=(EditText) findViewById(R.id.password);
        emailField =(EditText) findViewById(R.id.email);


    }

    public void submitInfoButton(View v) {
        //each entry needs a unique ID

        String bannerID = bannerIDField.getText().toString();
        String firstName = firstNameField.getText().toString();
        String lastName = lastNameField.getText().toString();
        String password=passwordField.getText().toString();
        String email= emailField.getText().toString();


        User user = new User(email, firstName, lastName, password, bannerID );

        appState.firebaseReference.child(bannerID).setValue(user);

        finish();

    }
}
