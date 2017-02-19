package com.mike.domain;

import java.util.Date;

/**
 * Created by mike on 26.01.2017.
 */
public class Journal extends BaseBook {
    private int id;

    public Journal(String title, Date dateOfIssue){
        this.title = title;
        this.dateOfIssue = dateOfIssue;
    }
}
