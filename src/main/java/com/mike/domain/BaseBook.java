package com.mike.domain;

import java.util.Date;

/**
 * Created by mike on 26.01.2017.
 */
public class BaseBook {
    private String title;
    private Date dateOfIssue;
    private int countOfReaders;
    private int validAge;
    private int id;

    public void addCountOfReaders(){
        countOfReaders++;
    }
    BaseBook(String title, Date date, int validAge){
        this.title = title;
        dateOfIssue = date;
        this.validAge = validAge;
    }

    public int getValidAge(){
        return validAge;
    }
    BaseBook(){

    }
    public String getTitle(){
        return title;
    }
}
