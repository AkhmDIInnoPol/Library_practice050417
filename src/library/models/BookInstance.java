package library.models;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by admin on 05.04.2017.
 */
public class BookInstance implements Externalizable {

    private final int DEFAULT_NUMBER = 32;

    private Book book;
    private UUID number;
    private List<Booking> bookingHistory;
    private static long serialVersionUID = 1L;
    private String signature;

    public BookInstance() {
    }

    public BookInstance(Book book, UUID number, String signature) {
        this.book = book;
        this.number = number;
        bookingHistory = new ArrayList<>(DEFAULT_NUMBER);
        this.signature = signature;
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
        return book + " @number " + number +
                        " @signature " + signature;
    }


    public Book getBook() {
        return book;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(book);
        out.writeObject(number);
        out.writeObject(signature);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        book = (Book) in.readObject();
        number = (UUID) in.readObject();
        signature = (String) in.readObject();
    }
}
