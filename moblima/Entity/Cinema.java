package moblima.Entity;

import java.io.Serializable;
import java.util.*;

/**
 * Represents a Cinema.
 * Concrete base class that implements the Serializable interface.
 * All cinema types extend this class.
 * @author Yap Shen Hwei
 * @version 1.0
 * @since 2022-11-13
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
     * 
     * @param cinemaID
     */
    public Cinema(String cinemaID, double priceProportion) {
        this.cinemaID = cinemaID;
        this.priceProportion = priceProportion;
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
     * Accessor method to gets this Cinema's ID.
     * 
     * @return this Cinema's cinemaID.
     */
    public String getCinemaID() {
        return cinemaID;
    }

    /**
     * Accessor method to get this Cinema's seats.
     * 
     * @return this Cinema's seats.
     */
    public ArrayList<Seat> getSeats() {
        return seats;
    }

    /**
     * Accessor method to gets Cinema type's price.
     * 
     * @return this Cinema's price.
     */
    public double getPriceProportion() {
        return priceProportion;
    }

    /**
     * Accessor method to gets Cinema's type.
     * 
     * @return this Cinema's type.
     */
    public CinemaType getCinemaType() {
        return type;
    }

    /**
     * Mutator method to change price proportion of the cinema.
     * 
     * @param the new price.
     */
    public void setPriceProportion(double newPrice) {
        this.priceProportion = newPrice;
        return;
    }
}
