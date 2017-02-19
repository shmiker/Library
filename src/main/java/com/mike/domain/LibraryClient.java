package com.mike.domain;

import java.util.Date;

/**
 * Created by mike on 26.01.2017.
 */
public class LibraryClient {
    public BaseBook[] currentBookList = new BaseBook[100];
    private int countOfBooks;
    private String name;
    private Date dateOfBirth;
    private int countOfHistoryBooks;
    private BaseBook[] historyBookList = new BaseBook[100];

    public LibraryClient(String name, Date dateOfBirth){
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public BaseBook[] getCurrentBookList() {
        return currentBookList;
    }

    public int getCountOfHistoryBooks(){
        return countOfHistoryBooks;
    }

    public void addBook(BaseBook b) {

        if (countTitlesInCurrentBookist() <= 3) {
            currentBookList[countOfBooks] = b;
            countOfBooks++;
            historyBookList[countOfHistoryBooks] = b;
            countOfHistoryBooks++;
            b.addCountOfReaders();

        } else
            System.out.println("Client already has 3 books/journals");
    }

    public int countTitlesInCurrentBookist() {

        String[] uniqueTitles = new String[currentBookList.length];
        int currentPositionInUniqueTitles = 0;
        for (BaseBook s : currentBookList) {
            if (s == null) {
                break;
            }
            boolean titleIsAlreadyInUniqueTitles = false;
            for (String u : uniqueTitles) {
                if (u != null && s.getTitle().equals(u)) {
                    titleIsAlreadyInUniqueTitles = true;
                    break;
                }
            }
            if (!titleIsAlreadyInUniqueTitles) {
                uniqueTitles[currentPositionInUniqueTitles] = s.getTitle();
                currentPositionInUniqueTitles++;
            }
        }
        return currentPositionInUniqueTitles;

    }
}
