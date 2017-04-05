package com.company;

import library.Library;
import library.models.Book;
import library.models.Reader;
import library.utils.DataManager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        Library library = new Library();
        //testBookSerialization();
        testReaderSerialization(library);

    }




    public static void testBookingSerialization(Library library)
    {

    }







    public static void testReaderSerialization(Library library)
    {


        Reader reader = new Reader(97094325, "John", "Ivanovich", "Conor");
        Reader reader2 = new Reader(97092389, "Sara", "Petrovich", "Conor");

        library.registerReader(reader);
        library.registerReader(reader2);

        Set<Reader> readers = library.getReaders();

        DataManager.serializeToFileReaders(readers);






        Library library2 = new Library();

        Set<Reader> readers2 = DataManager.deserializeFromFileReaders();


        for (Reader readerDes:readers2
             ) {
            library2.registerReader(readerDes);
        }

        library2.showAllData();
    }






    public static void testBookSerialization() throws ParseException
    {
        Library library = new Library();



        Reader reader = new Reader(97094325, "John", "Ivanovich", "Conor");
        Reader reade2 = new Reader(97092389, "Sara", "Petrovich", "Conor");

        library.buyBook("Intro to Java", "Petrov", "124587ps", 5, 1987);
        library.buyBook("Intro to C", "Stepanov", "234162ps", 2, 1999);

        Date startDate1 =new SimpleDateFormat().parse("2017-04-05");
        Date finishDate1 =new SimpleDateFormat().parse("2017-05-05");
        library.takeBook("John", "Ivanovich",
                            "Conor", 97094325, "Intro to Java",
                                startDate1, finishDate1);


        Date startDate2 =new SimpleDateFormat().parse("2017-04-01");
        Date finishDate2 =new SimpleDateFormat().parse("2017-06-14");
        library.takeBook("Sara", "Petrovich", "Conor",
                            97092389, "Intro to C",
                                startDate2, finishDate2);

        library.returnBook("John", "Ivanovich", "Conor", 97094325, "Intro to Java");



        DataManager.serializeToFileBooks(library.getCatalog());






        //=========================== Show data ======================================



        Library library2 = new Library();

        for (Book book:DataManager.deserializeFromFileBooks()
                ) {
            library2.buyBook(book.getTitle(), book.getAuthor(), book.getISBN(), 1, book.getYear());
        }


        library2.takeBook("John", "Ivanovich", "Conor",
                97094325, "Intro to Java",
                startDate1, finishDate1);
        library2.takeBook("Sara", "Petrovich", "Conor",
                             97092389, "Intro to C",
                                startDate2, finishDate2);

        library2.returnBook("John", "Ivanovich", "Conor", 97094325, "Intro to Java");

        library2.showAllData();
    }
}
