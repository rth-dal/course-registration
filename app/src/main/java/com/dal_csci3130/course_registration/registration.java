package com.dal_csci3130.course_registration;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class registration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        final EditText password = (EditText) findViewById(R.id.password);
        EditText username = (EditText) findViewById(R.id.userName);
        EditText firstName = (EditText) findViewById(R.id.firstName);
        EditText lastName = (EditText) findViewById(R.id.lastName);
        EditText email = (EditText) findViewById(R.id.email);
        Button register = (Button) findViewById(R.id.register);
        final TextView passConfirm = (TextView) findViewById(R.id.passConfirm);
        final TextView emailConfirm = (TextView) findViewById(R.id.emailConfirm);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!checkPassword(password.getText().toString()))   {
                    passConfirm.setText("Password must not be password");
                } else if(!checkLength(password.getText().toString())) {
                    passConfirm.setText("Password must be at least 8 characters");
                } else if(!checkSpecialChar(password.getText().toString())) {
                    passConfirm.setText("Password must contain a special character");
                } else if(!checkDigit(password.getText().toString())) {
                    passConfirm.setText("Password must contain a number");
                } else if(!checkUpperCase(password.getText().toString())) {
                    passConfirm.setText("Password must contain uppercase character");
                } else  {
                    passConfirm.setText("Password validated!");
                    startActivity(new Intent(registration.this, ProfileView.class));
                }
            }
        });
    }

    public boolean checkPassword(String pass)   {

        boolean flag;

        //since case insensitve, make lowercase to test

        if(pass!=null && pass.toLowerCase().equals("password")) {
            flag = false;
        } else {
            flag = true;
        }
        return flag;
    }

    public boolean checkLength(String pass) {

        boolean flag;

        //ensure greater or equal to 8
        if(pass!=null && pass.length()>=8)  {
            flag = true;
        } else  {
            flag = false;
        }
        return flag;
    }

    public boolean checkSpecialChar(String pass)    {

        boolean flag;

        //create a pattern of the regex
        //match input to this pattern
        Pattern pattern = Pattern.compile("[^A-Za-z0-9]");
        Matcher matcher = pattern.matcher(pass);

        boolean check = matcher.find();

        //if input matches the pattern then passes rule
        if (check == true) {
            flag = true;
        } else  {
            flag = false;
        }
        return flag;
    }

    public boolean checkDigit(String pass)  {

        boolean flag;

        Pattern pattern = Pattern.compile("[0-9]");
        Matcher matcher = pattern.matcher(pass);

        boolean check = matcher.find();

        //test for input containing number pattern
        if (check == true) {
            flag = true;
        } else  {
            flag = false;
        }
        return flag;
    }

    public boolean checkUpperCase(String pass)  {

        boolean flag;

        Pattern pattern = Pattern.compile("[A-Z]");
        Matcher matcher = pattern.matcher(pass);

        boolean check = matcher.find();

        //check for input in uppercase pattern
        if (check == true) {
            flag = true;
        } else  {
            flag = false;
        }
        return flag;
    }
}
