package com.dal_csci3130.course_registration;

/**
 * Created by padraecrobinson on 2018-02-18.
 * This class is used to neatly package a single search together.
 *
 */

public class filtered_search {

    String m_faculty;
    int m_year;
    int m_open_spots;


    public filtered_search(String faculty, int year, int open_spots){
        m_faculty = faculty;
        m_year = year;
        m_open_spots = open_spots;
    }


    /** GETTERS FOR FILTERED_SEARCH. */
    public String getm_faculty(){ return this.m_faculty;}
    public int getm_year(){return this.m_year;}
    public int getm_open_spots(){return this.m_open_spots;}

    /** SETTERS FOR FILTERED_SEARCH */
    public void setm_faculty(String set_fac){ this.m_faculty = set_fac;}
    public void setm_year(int set_year){this.m_year = set_year;}
    public void setm_open_spots(int set_open_spots){this.m_open_spots = set_open_spots;}



}
