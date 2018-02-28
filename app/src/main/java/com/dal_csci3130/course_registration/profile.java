package com.dal_csci3130.course_registration;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Button classSearch = (Button) findViewById(R.id.classSearch);

        classSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //this will not work yet
                //need to merge with search_view since Main2Activity doesnt exist in profile
                //startActivity(new Intent(profile.this, Main2Activity.class));
            }
        });
    }
}
