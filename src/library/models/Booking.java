package library.models;

import java.io.*;
import java.util.Date;

/**
 * Created by admin on 05.04.2017.
 */
public class Booking implements Externalizable {

    private BookInstance bookInstance;
    private Reader reader;
    private Date startDate;
    private Date finishDate;
    private Date returnDate;
    private static long serialVersionUID = 1L;

    private String signature;

    public Booking() {
    }

    public Booking(BookInstance bookInstance, Reader reader, Date startDate,
                   Date finishDate, String signature) {
        this.bookInstance = bookInstance;
        this.reader = reader;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.signature = signature;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public int hashCode() {



        return bookInstance.hashCode() + reader.hashCode() + startDate.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Booking)) {
            return false;
        }

        if (obj == null) {
            return false;
        }

        if (!(bookInstance.equals(((Booking) obj).bookInstance) &&
                reader.equals(((Booking) obj).reader) &&
                startDate.equals(((Booking) obj).startDate)))
            return false;

        return true;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookInstance=" + bookInstance +
                ", reader=" + reader +
                ", startDate=" + startDate +
                ", finishDate=" + finishDate +
                ", returnDate=" + returnDate +
                ", signature=" + signature +
                '}';
    }

    public BookInstance getBookInstance() {
        return bookInstance;
    }


    public Reader getReader() {
        return reader;
    }


    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(bookInstance);
        out.writeObject(reader);
        out.writeObject(startDate);
        out.writeObject(finishDate);
        out.writeObject(returnDate);
        out.writeObject(signature);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        bookInstance = (BookInstance) in.readObject();
        reader = (Reader) in.readObject();
        startDate = (Date) in.readObject();
        finishDate = (Date) in.readObject();
        returnDate = (Date) in.readObject();
        signature = (String) in.readObject();
    }
}
