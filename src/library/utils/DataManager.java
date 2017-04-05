package library.utils;

import library.models.*;
import library.models.Reader;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by admin on 05.04.2017.
 */
public class DataManager {

    public static void serializeToFileBooks(Set<Book> books)
    {
        try(FileOutputStream fos = new FileOutputStream("books.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            for (Book book: books)
            {
                oos.writeObject(book);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }




    public static Set<Book> deserializeFromFileBooks()
    {
        Set<Book> books = new HashSet<>();
        try(FileInputStream fis = new FileInputStream("books.txt");
            ObjectInputStream ois = new ObjectInputStream(fis)) {
            Book book = null;
            while ( (book = (Book) ois.readObject()) != null)
            {
                books.add(book);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
       finally {
            return books;
        }


    }



    public static void serializeToFileReaders(Set<Reader> readers)
    {
        try(FileOutputStream fos = new FileOutputStream("readers.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            for (Reader reader: readers)
            {
                oos.writeObject(reader);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }




    public static Set<Reader> deserializeFromFileReaders()
    {
        Set<Reader> readers = new HashSet<>();
        try(FileInputStream fis = new FileInputStream("readers.txt");
            ObjectInputStream ois = new ObjectInputStream(fis)) {
            Reader reader = null;
            while ( (reader = (Reader) ois.readObject()) != null)
            {
                readers.add(reader);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        finally {
            return readers;
        }


    }





    public static void serializeToFileBooking(Set<Booking> bookings)
    {
        try(FileOutputStream fos = new FileOutputStream("bookings.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            for (Booking booking: bookings)
            {
                oos.writeObject(booking);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }




    public static Set<Booking> deserializeFromFileBookings()
    {
        Set<Booking> bookings = new HashSet<>();
        try(FileInputStream fis = new FileInputStream("bookings.txt");
            ObjectInputStream ois = new ObjectInputStream(fis)) {
            Booking booking = null;
            while ( (booking = (Booking) ois.readObject()) != null)
            {
                bookings.add(booking);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        finally {
            return bookings;
        }


    }






}
