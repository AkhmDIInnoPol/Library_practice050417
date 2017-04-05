package com.company;

import library.Library;
import library.models.Book;
import library.models.BookInstance;
import library.models.Booking;
import library.models.Reader;
import library.utils.DataManager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Main {


    private static String SIGNATURE = "Dinar";


    public static void main(String[] args) {

        Library library = new Library();









        //  ============= Test1 ==============
//        try {
//            testBookInstanceExternalizationUniversClass(library);
//        }
//        catch (ParseException e)
//        {
//            e.printStackTrace();
//        }






        //  ============= Test2 ==============
        try {
            testBookExternalizationUniversClass(library);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }


    }





    public static void testBookExternalizationUniversClass(Library library)
            throws ParseException
    {

        library.buyBook("Intro to Java", "Petrov",
                "124587ps", 5, 1987, SIGNATURE);
        library.buyBook("Intro to C", "Stepanov",
                "234162ps", 2, 1999, SIGNATURE);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Date startDate1 = simpleDateFormat.parse("2017-04-05");
        Date finishDate1 = simpleDateFormat.parse("2017-05-05");
        library.takeBook("John", "Ivanovich",
                "Conor", 97094325, "Intro to Java",
                startDate1, finishDate1, SIGNATURE);


        Date startDate2 = simpleDateFormat.parse("2017-04-01");
        Date finishDate2 = simpleDateFormat.parse("2017-06-14");
        library.takeBook("Sara", "Petrovich", "Conor",
                97092389, "Intro to C",
                startDate2, finishDate2, SIGNATURE);

        library.returnBook("John", "Ivanovich", "Conor",
                97094325, "Intro to Java", SIGNATURE);



        DataManager.externalizeObj(library.getCatalog(), Book.class);



        //=========================== Show data ======================================



        Library library2 = new Library();

        Set<Book> emptyCollection = new HashSet<>();
        Set<Book> objCollection =
                (Set<Book>) DataManager.unexternalizeFromFileObject(emptyCollection, Book.class);
        for (Object obj:objCollection
                ) {
            Book book = (Book) obj;
            library2.buyBook(book.getTitle(), book.getAuthor(),
                    book.getISBN(), 1, book.getYear(), SIGNATURE);
        }


        library2.takeBook("John", "Ivanovich", "Conor",
                97094325, "Intro to Java",
                startDate1, finishDate1, SIGNATURE);
        library2.takeBook("Sara", "Petrovich", "Conor",
                97092389, "Intro to C",
                startDate2, finishDate2, SIGNATURE);

        library2.returnBook("John", "Ivanovich",
                "Conor", 97094325, "Intro to Java", SIGNATURE);

        library2.showAllData();




    }







    public static void testBookInstanceExternalizationUniversClass(Library library)
            throws ParseException
    {
        library.buyBook("Intro to Java", "Petrov",
                "124587ps", 5, 1987, SIGNATURE);
        library.buyBook("Intro to C", "Stepanov",
                "234162ps", 2, 1999, SIGNATURE);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Date startDate1 = simpleDateFormat.parse("2017-04-05");
        Date finishDate1 = simpleDateFormat.parse("2017-05-05");
        library.takeBook("John", "Ivanovich",
                "Conor", 97094325, "Intro to Java",
                startDate1, finishDate1, SIGNATURE);


        Date startDate2 = simpleDateFormat.parse("2017-04-01");
        Date finishDate2 = simpleDateFormat.parse("2017-06-14");
        library.takeBook("Sara", "Petrovich", "Conor",
                97092389, "Intro to C",
                startDate2, finishDate2, SIGNATURE);

        library.returnBook("John", "Ivanovich",
                "Conor", 97094325,
                "Intro to Java", SIGNATURE);


        DataManager.externalizeObj(library.getStore(), BookInstance.class);



        // ============================= Show data =======================

        Library library2 = new Library();
        Set<BookInstance> emptyCollection = new HashSet<>();
        Set<BookInstance> store = (Set<BookInstance>)
                DataManager.unexternalizeFromFileObject(emptyCollection, BookInstance.class);
        library2.setStore(store);

        library2.showAllData();
    }
















}
