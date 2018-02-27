package com.dal_csci3130.course_registration;

/**
 * Created by padraecrobinson on 2018-02-18.
 * This class is used to neatly package a single search together.
 *
 */

public class filtered_search {

    private String m_faculty="NULL";
    private int m_year=0;
    private int m_open_spots=0;


    /**

     This method will make an API call to the database.
     We need an onclick action in the UI to trigger this method.
     Elementary error checking implemented, UI needs to catch a "NULL" return.



                           ------ UNFINISHED ------



     */
    public String[] QUERY_DB(String faculty, int year, int open_spots) {


        String[] search_results;

        if (faculty.equals("NULL")) {
            m_faculty = faculty;
        }

        if (year > 0 && year < 10) {
            m_year = year;
        }

        if( m_open_spots >= 0 && m_open_spots < 600){
            m_year = open_spots;
        }

        else {

            search_results = new String[1];
            search_results[1] = "NULL";
            return search_results;
        }

    }


    /** GETTERS FOR FILTERED_SEARCH. */
    public String getm_faculty(){ return this.m_faculty;}
    public int getm_year(){return this.m_year;}
    public int getm_open_spots(){return this.m_open_spots;}

    /** SETTERS FOR FILTERED_SEARCH */
    public void setm_faculty(String set_fac){ this.m_faculty = set_fac;}
    public void setm_year(int set_year){this.m_year = set_year;}
    public void setm_open_spots(int set_open_spots){this.m_open_spots = set_open_spots;}

    public void send_error(int err) {

        //this method needs to evoke a UI change to the following string:

        String error_message="NULL";

        if(err==1) { //


        }

        if (err==2) {

        }


        if (err==3) {

        }


    }

}
