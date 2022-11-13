package moblima.Entity;

import java.io.Serializable;

/**
 * Represents a Booking.
 * Class that implements the Serializable interface.
 * @author Isaac Wong
 * @version 1.0
 * @since 2022-11-13
 */
public class Booking implements Serializable {
    /**
     * The transactionID of this Booking.
     */
    private String transactionID;
    /**
     * The booker of this Booking.
     */
    private CustomerAccount booker;
    /**
     * The session booked by this Booking.
     */
    private Session sessionBooked;
    /**
     * The cineplex booked by this Booking.
     */
    private Cineplex cineplexBooked;
    /**
     * The seat booked by this Booking.
     */
    private Seat seatBooked;
    /**
     * The status of the ticket owner.
     */
    private String status;
    /**
     * The status of the ticket owner.
     */
    private Cinema cinemaBooked;
    /**
     * The serialVersionUID of this Booking.
     */
    private static final long serialVersionUID = 3258651340543939867L;

    /**
     * Creates a new Booking with the given TID, owner, session, cineplex, seat.
     * 
     * @param TID      This Booking's TID.
     * @param owner    This Booking's owner.
     * @param session  This Booking's session.
     * @param cineplex This Booking's cineplex.
     * @param seat     This Booking's seat.
     * @param cinema   This Booking's cinema.
     */
    public Booking(String TID, CustomerAccount ownerAccount, Session session, Cineplex cineplex, Seat seat,
            Cinema cinema) {
        this.transactionID = TID;
        this.booker = ownerAccount;
        this.sessionBooked = session;
        this.cineplexBooked = cineplex;
        this.cinemaBooked = cinema;
        this.seatBooked = seat;
        this.status = ((Customer) booker.getOwner()).getStatus();

    }

    /**
     * Gets the transaction ID of this Booking.
     * 
     * @return This Booking's transactionID.
     */
    public String getTID() {
        return transactionID;
    }

    /**
     * Gets the booker of this Booking.
     * 
     * @return This Booking's booker.
     */
    public CustomerAccount getBooker() {
        return booker;
    }

    /**
     * Gets the session booked by this Booking.
     * 
     * @return This Booking's sessionBooked.
     */
    public Session getSessionBooked() {
        return sessionBooked;
    }

    /**
     * Gets the cineplex booked by this Booking.
     * 
     * @return This Booking's cineplexBooked.
     */
    public Cineplex getCineplexBooked() {
        return cineplexBooked;
    }

    /**
     * Gets the cinema booked by this Booking.
     * 
     * @return This Booking's cinemaBooked.
     */
    public Cinema getCinemaBooked() {
        return cinemaBooked;
    }

    /**
     * Gets the seat booked by this Booking.
     * 
     * @return This Booking's seatBooked.
     */
    public Seat getSeatBooked() {
        return seatBooked;
    }

    /**
     * Gets the customer's status, which is a Status enum
     * 
     * @return an enum of type Status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Prints a ticket to the user with the following details:
     * TransactionID, customer name, movie title, cineplex, seat number, and seat
     * type.
     */
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
