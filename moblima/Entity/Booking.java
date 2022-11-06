package moblima.Entity;

import java.io.Serializable;

public class Booking implements Serializable {
    private String transactionID;
    private CustomerAccount booker;
    private Session sessionBooked;
    private Cineplex cineplexBooked;
    private Seat seatBooked;

    public Booking(String TID, CustomerAccount owner, Session session, Cineplex cineplex, Seat seat) {
        this.transactionID = TID;
        this.booker = owner;
        this.sessionBooked = session;
        this.cineplexBooked = cineplex;
        this.seatBooked = seat;
    }

    public String getTID() {
        return transactionID;
    }

    public CustomerAccount getBooker() {
        return booker;
    }

    public Session getSessionBooked() {
        return sessionBooked;
    }

    public Cineplex getCineplexBooked() {
        return cineplexBooked;
    }

    public Seat getSeatBooked() {
        return seatBooked;
    }

    public void toTicket() {
        System.out.printf("--------------------------------%n");
        System.out.printf("            Receipt      %n");
        System.out.printf("--------------------------------%n");
        System.out.printf("| %-20s | %-20s |%n", "TransactionID", transactionID);
        System.out.printf("| %-20s | %-20s |%n", "", "Couple Seat");
        System.out.printf("| %-20s | %-20s |%n", "31-40: ", "Elite Seat");
        System.out.printf("| %-20s | %-20s |%n", "41-50: ", "Ultima Seat");
    }
}
