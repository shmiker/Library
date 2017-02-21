package com.mike.domain;

import java.util.Date;

/**
 * Created by mike on 26.01.2017.
 */
public class Book extends BaseBook {
    private String id;
    private int validAge;

    public Book(String title, Date dateOfIssue, int validAge){
        this.title = title;
        this.dateOfIssue = dateOfIssue;
        this.validAge = validAge;
    }
}
