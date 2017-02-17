package com.mike.domain;

import java.util.Date;

/**
 * Created by mike on 15.02.2017.
 */
public class Library {
    private BaseBook[] listOfAllBaseBooks;
    private LibraryClient[] listOfAllClients;

    public BaseBook[] checkAllBaseBooksAtClient(String name, Date dateOfBirth) {
        for (int i = 0; i < listOfAllClients.length; i++) {
            if (listOfAllClients[i].getName().equals(name) && listOfAllClients[i].getDateOfBirth().equals(dateOfBirth)) {
                return listOfAllClients[i].getCurrentBookList();
            }
        }
        return null;
    }

    //- вывести кто больше всего книг(газет) прочел
    public String checkTheMostReadingClient() {
        int temp = 0;
        for (int i = 0; i < listOfAllClients.length; i++) {
            if (listOfAllClients[i].getCountOfHistoryBooks() > temp) {
                temp = listOfAllClients[i].getCountOfHistoryBooks();
                if (listOfAllClients[i].getCountOfHistoryBooks() == temp) { // to check
                    return listOfAllClients[i].getName();
                }
            }
        }
        return null;
    }

//    public BookType checkTheMostReadingBaseBooks() { TODO
//        for (int i = 0; i < listOfAllBaseBooks.length; i++) {
//            if (listOfAllBaseBooks[i] instanceof Journal) {
//                return BookType.Journal;
//            } else
//                return BookType.Book;
//
//        }
}
