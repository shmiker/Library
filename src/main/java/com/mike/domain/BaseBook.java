package com.mike.domain;

import java.util.Date;

/**
 * Created by mike on 26.01.2017.
 */
public class BaseBook {
    private String title;
    private Date dateOfIssue;
    private int countOfReaders;

    public void addCountOfReaders(){
        countOfReaders++;
    }
    BaseBook(String title, Date date){
        this.title = title;
        dateOfIssue = date;
    }

    BaseBook(){

    }
    public String getTitle(){
        return title;
    }
}
