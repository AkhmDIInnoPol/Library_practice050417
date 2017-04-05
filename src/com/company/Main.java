package com.company;

import library.Library;
import library.models.Book;
import library.models.Reader;
import library.utils.DataManager;

import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Library library = new Library();

        for (Book book:DataManager.deserializeFromFile()
                ) {
            library.buyBook(book.getTitle(), book.getAuthor(), book.getISBN(), 1, book.getYear());
        }

        Reader reader = new Reader(97094325, "John", "Ivanovich", "Conor");
        Reader reade2 = new Reader(97092389, "Sara", "Petrovich", "Conor");

//        library.buyBook("Intro to Java", "Petrov", "124587ps", 5, 1987);
//        library.buyBook("Intro to C", "Stepanov", "234162ps", 2, 1999);

        library.takeBook("John", "Ivanovich", "Conor", 97094325, "Intro to Java");
        library.takeBook("Sara", "Petrovich", "Conor", 97092389, "Intro to C");

        library.returnBook("John", "Ivanovich", "Conor", 97094325, "Intro to Java");

        library.showAllData();


//        DataManager.serializeToFile(library.getCatalog());





    }
}
