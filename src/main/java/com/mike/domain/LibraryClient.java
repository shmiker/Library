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

    public static void main(String[] args) {
        LibraryClient client = new LibraryClient();
        BaseBook book1 = new BaseBook("book#1", null);
        BaseBook book2 = new BaseBook("book#1", null);
        BaseBook book3 = new BaseBook("book#4", null);
        BaseBook book4 = new BaseBook("book#4", null);
        BaseBook book5 = new BaseBook("book#4", null);

        client.currentBookList[0] = book1;
        client.currentBookList[1] = book2;
        client.currentBookList[2] = book3;
        client.currentBookList[3] = book4;
        client.currentBookList[4] = book5;

        client.countTitlesInCurrentBookist();

    }

    public void addBook(BaseBook b) {
        // проверить есть ли книга с названием уже в currentBookList и если есть, то можно добавлять
        //if (){}


        if (countTitlesInCurrentBookist() < 3) {
            currentBookList[countOfBooks] = b;
            countOfBooks++;
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
