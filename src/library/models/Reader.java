package library.models;

import java.io.*;

/**
 * Created by admin on 05.04.2017.
 */
public class Reader implements Externalizable {

    private final int GOOD_DISTRIBUTION_NUMBER = 32;

    private long passportNumber;
    private String firstName;
    private String secondName;
    private String lastName;
    private static long serialVersionUID = 1L;
    private String signature;

    public Reader() {
    }

    public Reader(long passportNumber, String firstName, String secondName,
                        String lastName, String signature) {
        this.passportNumber = passportNumber;
        this.firstName = firstName;
        this.secondName = secondName;
        this.lastName = lastName;
        this.signature = signature;
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
                ", signature='" + signature + '\'' +
                '}';
    }


    public long getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(long passportNumber) {
        this.passportNumber = passportNumber;
    }


    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeLong(passportNumber);
        out.writeObject(firstName);
        out.writeObject(secondName);
        out.writeObject(lastName);
        out.writeObject(signature);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        passportNumber = in.readLong();
        firstName = (String) in.readObject();
        secondName = (String) in.readObject();
        lastName = (String) in.readObject();
        signature = (String) in.readObject();
    }
}
