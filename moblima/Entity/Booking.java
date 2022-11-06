package moblima.Entity;

import java.io.Serializable;

public class Booking implements Serializable {
    private String transactionID;
    private CustomerAccount booker;
    private Session sessionBooked;
    private Cineplex cineplexBooked;
    private Seat seatBooked;
    private static final long serialVersionUID = 3258651340543939867L;

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
        /* TODO: Add price print statement as well */
        System.out.printf("--------------------------------%n");
        System.out.printf("            Receipt      %n");
        System.out.printf("--------------------------------%n");
        System.out.printf("| %-20s | %-20s |%n", "TransactionID:", transactionID);
        System.out.printf("| %-20s | %-20s |%n", "Customer: ", booker.getUsername());
        System.out.printf("| %-20s | %-20s |%n", "Movie Title:", sessionBooked.getMovie().getTitle());
        System.out.printf("| %-20s | %-20s |%n", "Cineplex: ", cineplexBooked.getLocation());
        System.out.printf("| %-20s | %-20s |%n", "Seat No: ", seatBooked.getSeatID());
        System.out.printf("| %-20s | %-20s |%n", "Seat Type: ", seatBooked.getSeatType().getName());
    }
}
