package moblima.Entity;

import java.io.Serializable;
import java.util.*;

/**
 * Represents a Cinema
 * Abstract class that implements the Serializable interface.
 */
public abstract class Cinema implements Serializable {
    /**
     * The cinema ID of this cinema.
     */
    private String cinemaID;
    /**
     * The arrayList of Seat class that represents the cinema. 
     */
    private ArrayList<Seat> seats;

    /**
     * Creates a Cinema with given cinemaID.
     * Cinema consist of RegularSeat, CoupleSeat,EliteSeat and UltimaSeat.
     * @param cinemaID
     */
    public Cinema(String cinemaID) {
        this.cinemaID = cinemaID;
        this.seats = new ArrayList<Seat>();
        for (int i = 0; i < 20; i++) {
            seats.add(new RegularSeat(i + 1, 2.0));
        }
        for (int i = 20; i < 30; i++) {
            seats.add(new CoupleSeat(i + 1, 8.0));
        }
        for (int i = 30; i < 40; i++) {
            seats.add(new EliteSeat(i + 1, 4.0));
        }
        for (int i = 40; i < 50; i++) {
            seats.add(new UltimaSeat(i + 1, 6.0));
        }
    }

    /**
     * Gets this Cinema's ID.
     * @return this Cinema's cinemaID.
     */
    public String getCinemaID() {
        return cinemaID;
    }

    /**
     * Gets this A
     * @return this Cinema's seats. 
     */
    public ArrayList<Seat> getSeats() {
        return seats;
    }

    /**
     * Abstract method to get Cinema's price. 
     * @return this Cinema's price. 
     */
    public abstract double getPriceProportion();
    /**
     * Abstract method to get Cinema's type. 
     * @return this Cinema's type. 
     */
    public abstract CinemaType getCinemaType();
}
