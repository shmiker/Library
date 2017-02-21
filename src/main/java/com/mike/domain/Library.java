package com.mike.domain;

/**
 * Created by mike on 15.02.2017.
 */
public class Library {
    private BaseBook[] listOfAllBaseBooks = new BaseBook[100];
    private LibraryClient[] listOfAllClients = new LibraryClient[100];

    public static void main(String[] args) {

        BaseBook book1 = new Book("book#1", null, 18);
        BaseBook book2 = new Book("book#2", null, 16);
        BaseBook book3 = new Book("book#2", null, 18);
        BaseBook book4 = new Book("book#4", null, 20);
        BaseBook book5 = new Book("book#3", null, 16);
        BaseBook journal1 = new Journal("journal #1", null, 16);
        BaseBook journal2 = new Journal("journal #2", null, 18);
        BaseBook journal3 = new Journal("journal #3", null, 15);

        LibraryClient petya = new LibraryClient("Petya", null, 13);
        petya.addBook(book2, petya);
        petya.addBook(journal1, petya);
        petya.addBook(journal2, petya);


        LibraryClient vasya = new LibraryClient("Vasya", null, 24);

        vasya.addBook(journal3, vasya);
        vasya.addBook(book3, vasya);

        Library library = new Library();
        library.listOfAllClients[0] = vasya;
        library.listOfAllClients[1] = petya;
        library.listOfAllBaseBooks[0] = book1;
        library.listOfAllBaseBooks[1] = book2;

        library.listOfAllBaseBooks[5] = journal1;
        library.listOfAllBaseBooks[6] = journal2;
        library.listOfAllBaseBooks[7] = journal3;

        library.checkTheMostReadingBaseBooks();
        library.checkAllBaseBooksAtClient("Vasya");

    }

    // проверка книг у клиента по имени
    public BaseBook[] checkAllBaseBooksAtClient(String name) {
        for (int i = 0; i < listOfAllClients.length; i++) {
            if (listOfAllClients[i].getName().equals(name) && listOfAllClients[i] != null) {
                listOfAllClients[i].printTitleFromCurrentBookList();
                return listOfAllClients[i].getCurrentBookList();
            }
        }
        return null;
    }

    // вывести кто больше всего книг(газет) прочел // TODO CHECK

//    public String maxcount() {
//        int maxcount = 0;
//        for (int i = 0; i < listOfAllClients.length; i++) {
//            if (listOfAllClients[i].getCountOfHistoryBooks() > maxcount) {
//                maxcount = listOfAllClients[i].getCountOfHistoryBooks();
//            }
//        } // почему прерывается и не заходит в следующий for?
//        for (int i = 0; i < listOfAllClients.length; i++) {
//            if (maxcount == listOfAllClients[i].getCountOfHistoryBooks()) {
//                System.out.println(listOfAllClients[i].getName());
//                return listOfAllClients[i].getName();
//            }
//        }
//        return null;
//    }


    // вывести что больше читают - книги или газеты
    public BookType checkTheMostReadingBaseBooks() {
        int journalCounter = 0;
        int bookCounter = 0;
        for (int i = 0; i < listOfAllBaseBooks.length; i++) {
            if (listOfAllBaseBooks[i] instanceof Journal) {
                journalCounter++;
            } else if (listOfAllBaseBooks[i] instanceof Book)
                bookCounter++;
        }
        if (journalCounter > bookCounter) {
            System.out.println("Journal");  // to check
            return BookType.Journal;
        } else ;
        System.out.println("Book");
        return BookType.Book;
    }
}
