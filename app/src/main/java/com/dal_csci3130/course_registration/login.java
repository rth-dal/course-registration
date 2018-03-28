package com.dal_csci3130.course_registration;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class login extends Activity {
    private User user;
    private static boolean enabled;
    int attempt_counter = 5;

    public static void setEnabled(boolean enabled) {
        login.enabled = enabled;
    }



    //TODO REFACTOR validUser so that it is more coherent (just checks the uname/pass)
    //the counter stuff should be implemented in a separate method

    public boolean validUser(String uName, String pass) {

        boolean flag;

        if(uName.equals("admin") && pass.equals("admin"))   {
            flag = true;
        }   else  {
            flag = false;
        }

        return flag;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final DataBase db = new DataBase();
        db.initialize();

        final EditText username = (EditText) findViewById(R.id.userName);
        final EditText password = (EditText) findViewById(R.id.password);
        Button register = (Button) findViewById(R.id.register);
        final Button login = (Button) findViewById(R.id.login);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(login.this, registration.class));

            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //validUser(username.getText().toString(), password.getText().toString());
                TextView attempts = (TextView) findViewById(R.id.attempts);

                attempts.setText(Integer.toString(attempt_counter));



                for (int i=0; i<db.getUserlist().size(); i++) {
                    if (username.getText().toString().equals(db.getUserlist().get(i).getUsername()) && password.getText().toString().equals(db.getUserlist().get(i).getPassword())) {
                        user = db.getUserlist().get(i);
                        Intent intent = new Intent(login.this, profile.class);
                        intent.putExtra("user", user);
                        startActivity(intent);
                    } else {

                        Toast.makeText(login.this, "User and Password is not correct",
                                Toast.LENGTH_SHORT).show();
                        attempt_counter--;
                        attempts.setText(Integer.toString(attempt_counter));
                        if (attempt_counter == 0) {
                            login.setEnabled(false);
                        }
                    }

                }
            }
        });
    }
}
