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
     * The price for the regular cinema.
     */
    private static double priceR = 2;
    /**
     * The price for the Gold Class cinema.
     */
    private static double priceG = 4;
    /**
     * The price for the Platinum Movie Suites.
     */
    private static double priceP = 6;

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
    public Cinema(String cinemaID, CinemaType type) {
        this.cinemaID = cinemaID;
        this.seats = new ArrayList<Seat>();
        this.type = type;
        for (int i = 0; i < 20; i++) {
            seats.add(new Seat(i + 1, SeatType.REGULAR));
        }
        for (int i = 20; i < 30; i++) {
            seats.add(new Seat(i + 1, SeatType.COUPLE));
        }
        for (int i = 30; i < 40; i++) {
            seats.add(new Seat(i + 1, SeatType.ELITE));
        }
        for (int i = 40; i < 50; i++) {
            seats.add(new Seat(i + 1, SeatType.ULTIMA));
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
        switch(this.getCinemaType()) {
        case REGULAR:
        	return priceR;
        case GOLD_CLASS:
        	return priceG;
        case PLATINUM_MOVIE_SUITES:
        	return priceP;
        default:
        	return 0;
        }
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
     * Static Mutator method to change price proportion of the cinema.
     * @param type CinemaType to be changed.
     * @param newPrice the new price.
     */
    public static void setPriceProportion(CinemaType type, double newPrice) {
    	switch(type){
        case REGULAR:
        	priceR = newPrice;
        case GOLD_CLASS:
        	priceG = newPrice;
        case PLATINUM_MOVIE_SUITES:
        	priceP = newPrice;
        }
    }
}
