package library;

import library.models.*;

import java.util.*;

/**
 * Created by admin on 05.04.2017.
 */
public class Library {


    private Set<Book> catalog;
    private Set<BookInstance> store;
    private Set<Reader> readers;
    private Set<Booking> bookings;


    public Library() {
        catalog = new HashSet<>(1024);
        store = new HashSet<>(4096);
        readers = new HashSet<>(512);
        bookings = new HashSet<>(2048);
    }


    public void buyBook(String title, String author,
                        String isbn, int quantity, int year) {
        Book newBook = new Book(author, title, year, isbn);
        catalog.add(newBook);

        for (int i = 0; i < quantity; i++) {
            BookInstance bookInstance = new BookInstance(newBook, UUID.randomUUID());
            store.add(bookInstance);
        }
    }


    public Set<Reader> getReaders() {
        return readers;
    }

    public void registerReader(Reader reader)
    {
        readers.add(reader);

    }




    public void takeBook(String firstName, String secondName,
                         String lastName, long pasportNumber,
                         String title)

    {
        Object[] reader = readers.stream()
                .filter((r)->(r.getPassportNumber() == pasportNumber)).toArray();

        Reader tempReader = null;

        if (reader.length != 0)
        {
           tempReader = (Reader) reader[0];
        }
        else
        {
            tempReader =  new Reader(pasportNumber,firstName,secondName,lastName);
            readers.add(tempReader);
        }

        BookInstance bookInstance = (BookInstance) store.stream().filter((s)->s.getBook().getTitle().equals(title)).toArray()[0];
        if (tempReader == null)
        {
            System.out.println("No such book");
            return;
        }

        if (bookInstance == null)
        {
            System.out.println("No such book");
            return;
        }
        Booking booking = new Booking(bookInstance, tempReader, new Date(), new Date());
        bookings.add(booking);

        store.remove(bookInstance);
    }



    public void returnBook(String firstName, String secondName,
                           String lastName, long pasportNumber,
                           String title)
    {
        Reader reader = new Reader(pasportNumber, firstName, secondName, lastName);
        Booking booking = (Booking) bookings.stream().filter((b)-> b.getBookInstance().getBook().getTitle().equals(title) && 
                                                    b.getReader().equals(reader)).toArray()[0];
        
        if(booking == null)
        {
            System.out.println("No such booking");
            return;
        }
        
        store.add(booking.getBookInstance());
        bookings.remove(booking);

    }
    
    
    public void showAllData()
    {
        for (Book book:catalog
             ) {
            System.out.println(book);
        }

        System.out.println();
        System.out.println();
        
        for (BookInstance bookInstance:store)
        {
            System.out.println(bookInstance);
        }

        System.out.println();
        System.out.println();

        for (Booking booking:bookings
             ) {
            System.out.println(booking);
        }

        System.out.println();
        System.out.println();


        for (Reader reader:readers
                ) {
            System.out.println(readers);
        }
        
    }

    public Set<Book> getCatalog() {
        return catalog;
    }


    public void setCatalog(Set<Book> catalog) {
        this.catalog = catalog;
    }
}
