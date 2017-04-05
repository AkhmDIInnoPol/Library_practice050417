package library.models;

import java.util.Date;

/**
 * Created by admin on 05.04.2017.
 */
public class Booking {

    private BookInstance bookInstance;
    private Reader reader;
    private Date startDate;
    private Date finishDate;
    private Date returnDate;


    public Booking(BookInstance bookInstance, Reader reader, Date startDate, Date finishDate) {
        this.bookInstance = bookInstance;
        this.reader = reader;
        this.startDate = startDate;
        this.finishDate = finishDate;
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
                '}';
    }

    public BookInstance getBookInstance() {
        return bookInstance;
    }


    public Reader getReader() {
        return reader;
    }
}
