package library.utils;

import library.models.Book;

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









}
