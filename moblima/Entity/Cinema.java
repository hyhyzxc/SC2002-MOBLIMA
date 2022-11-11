package moblima.Entity;

import java.io.Serializable;
import java.util.*;

/**
 * Represents a Cinema.
 * Concrete base class that implements the Serializable interface.
 * All cinema types extend this class.
 */
public class Cinema implements Serializable {
    /**
     * The cinema ID of this cinema.
     */
    private String cinemaID;
    /**
     * The arrayList of Seat class that represents the cinema. 
     */
    private ArrayList<Seat> seats;
    /**
     * The price proportionality constant for the cinema.
     */
    private double priceProportion;
    /**
     * The type of the Cinema
     */
    protected CinemaType type;

    /**
     * Creates a Cinema with given cinemaID.
     * Cinema consist of RegularSeat, CoupleSeat,EliteSeat and UltimaSeat.
     * @param cinemaID
     */
    public Cinema(String cinemaID, double priceProportion, CinemaType type) {
        this.cinemaID = cinemaID;
        this.priceProportion = priceProportion;
        this.seats = new ArrayList<Seat>();
        this.type = type;
        for (int i = 0; i < 20; i++) {
            seats.add(new Seat(i + 1, SeatType.REGULAR, 2));
        }
        for (int i = 20; i < 30; i++) {
            seats.add(new Seat(i + 1, SeatType.COUPLE, 8));
        }
        for (int i = 30; i < 40; i++) {
            seats.add(new Seat(i + 1, SeatType.ELITE, 4));
        }
        for (int i = 40; i < 50; i++) {
            seats.add(new Seat(i + 1, SeatType.ULTIMA, 6));
        }
    }

    /**
     * Accessor method to gets this Cinema's ID.
     * @return this Cinema's cinemaID.
     */
    public String getCinemaID() {
        return cinemaID;
    }

    /**
     * Accessor method to get this Cinema's seats.
     * @return this Cinema's seats. 
     */
    public ArrayList<Seat> getSeats() {
        return seats;
    }

    /**
     * Accessor method to gets Cinema type's price. 
     * @return this Cinema's price. 
     */
    public double getPriceProportion() {
        return priceProportion;
    }
    /**
     * Accessor method to gets Cinema's type. 
     * @return this Cinema's type. 
     */
    public CinemaType getCinemaType() {
    	return type;
    }
}
