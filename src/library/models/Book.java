package library.models;

import java.io.Serializable;

/**
 * Created by admin on 05.04.2017.
 */
public class Book implements Serializable {

    private String author;
    private String title;
    private int year;
    private String ISBN;
    private static long serialVersionUID = 2L;


    public Book(String author, String title, int year, String ISBN) {
        this.author = author;
        this.title = title;
        this.year = year;
        this.ISBN = ISBN;
    }

    @Override
    public int hashCode() {
        return ISBN.hashCode();
    }

    @Override
    public boolean equals(Object obj) {

        if (!(obj instanceof Book))
        {
            return false;
        }

        if (obj == null)
        {
            return false;
        }

        if (!this.ISBN.equals(((Book) obj).ISBN))
            return false;

        return true;
    }

    @Override
    public String toString() {
        return author + " @" + title + " @" + year + " @" + ISBN;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }
}
