package library.utils;

import library.models.*;
import library.models.Reader;

import java.io.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by admin on 05.04.2017.
 */
public class DataManager {




    public static <T> void externalizeObj(Collection<T> objects, Class className)
    {

        String classNameStr = className.getSimpleName();

        try(FileOutputStream fos = new FileOutputStream(classNameStr + ".txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            for (T object: objects)
            {
                oos.writeObject(object);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }


    public static <T> Collection<T> unexternalizeFromFileObject(Collection<T> emptyCollection)
    {
        Collection<T> objects = emptyCollection;
        try(FileInputStream fis = new FileInputStream("bookInstances.txt");
            ObjectInputStream ois = new ObjectInputStream(fis)) {
            T object = null;
            while ( (object = (T) ois.readObject()) != null)
            {
                objects.add(object);
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
            return objects;
        }

    }




    public static void externalizeToFileBookInstance(Set<BookInstance> bookInstances)
    {
        try(FileOutputStream fos = new FileOutputStream("bookInstances.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            for (BookInstance bookInstance: bookInstances)
            {
                oos.writeObject(bookInstance);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }







    public static Set<BookInstance> unexternalizeFromFileBookInstance()
    {
        Set<BookInstance> bookInstances = new HashSet<>();
        try(FileInputStream fis = new FileInputStream("bookInstances.txt");
            ObjectInputStream ois = new ObjectInputStream(fis)) {
            BookInstance bookInstance = null;
            while ( (bookInstance = (BookInstance) ois.readObject()) != null)
            {
                bookInstances.add(bookInstance);
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
            return bookInstances;
        }

    }




    public static void externalizeToFileBooking(Set<Booking> bookings)
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




    public static Set<Booking> unexternalizeFromFileBookings()
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






    public static void externalizeToFileBooks(Set<Book> books)
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



    public static Set<Book> unexternalizeFromFileBooks()
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




    public static void externalizeToFileReaders(Set<Reader> readers)
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




    public static Set<Reader> unexternalizeFromFileReaders()
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











}
