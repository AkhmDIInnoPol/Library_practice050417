package library.models;

/**
 * Created by admin on 05.04.2017.
 */
public class Reader {

    private final int GOOD_DISTRIBUTION_NUMBER = 32;

    private long passportNumber;
    private String firstName;
    private String secondName;
    private String lastName;


    public Reader(long passportNumber, String firstName, String secondName, String lastName) {
        this.passportNumber = passportNumber;
        this.firstName = firstName;
        this.secondName = secondName;
        this.lastName = lastName;
    }

    @Override
    public int hashCode() {
        return (int) passportNumber * GOOD_DISTRIBUTION_NUMBER;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Reader)) {
            return false;
        }

        if (obj == null) {
            return false;
        }

        if (passportNumber != ((Reader) obj).passportNumber)
            return false;

        return true;
    }

    @Override
    public String toString() {
        return "Reader{" +
                "GOOD_DISTRIBUTION_NUMBER=" + GOOD_DISTRIBUTION_NUMBER +
                ", passportNumber=" + passportNumber +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }


    public long getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(long passportNumber) {
        this.passportNumber = passportNumber;
    }
}
