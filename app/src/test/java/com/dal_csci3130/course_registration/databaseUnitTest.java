package com.dal_csci3130.course_registration;

import org.junit.Test;

import java.util.ArrayList;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

public class databaseUnitTest {

    ArrayList<String> prereq = new ArrayList<String>();


    DataBase db = new DataBase();

    @Test
    public void init() throws Exception{
        System.out.println("db initializer test");
        db.initialize();
        System.out.println(db.getCourselist().size());
        System.out.println(db.getCourselist().get(0).getDescription());
    }

    @Test
    public void coursesearch() throws Exception{
        System.out.println("filtered_search course test");

        filtered_search search = new filtered_search();
        ArrayList<Course> result = search.QUERY_COURSES_DB("CSCI","3","0");
        for (int i = 0; i< result.size();i++) {
            System.out.println(result.get(i).stringify());
        }
    }

    @Test
    public void usersearch() throws Exception {
        System.out.println("filtered_search user test");

        filtered_search search = new filtered_search();
        User result = search.QUERY_USERS_DB("admin", "admin");
        System.out.println(result.stringify());
    }
}