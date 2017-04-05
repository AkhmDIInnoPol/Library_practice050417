package library.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by admin on 05.04.2017.
 */
public class BookInstance implements Serializable {

    private final int DEFAULT_NUMBER = 32;

    private Book book;
    private UUID number;
    private List<Booking> bookingHistory;
    private static long serialVersionUID = 1L;


    public BookInstance(Book book, UUID number) {
        this.book = book;
        this.number = number;

        bookingHistory = new ArrayList<>(DEFAULT_NUMBER);
    }

    @Override
    public int hashCode() {
        return number.hashCode() * 32;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof BookInstance))
        {
            return false;
        }

        if (obj == null)
        {
            return false;
        }

        if (this.number.equals(((BookInstance) obj).number))
            return false;

        return true;
    }

    @Override
    public String toString() {
        return book + " @number" + number;
    }


    public Book getBook() {
        return book;
    }
}
