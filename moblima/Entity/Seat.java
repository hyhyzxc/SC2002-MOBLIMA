package moblima.Entity;

import java.io.Serializable;

/**
 * Represents a Seat in a Cinema.
 * Implements Serializable.
 */
public class Seat implements Serializable {
    /**
     * Whether this Seat has been occupied.
     */
    private boolean occupied;
    /**
     * This Seat's ID.
     */
    private int seatID;
    /**
     * The price of Regular Seat.
     */
    private static double priceR = 2;
    /**
     * The price of Elite Seat.
     */
    private static double priceE = 4;
    /**
     * The price of Ultima Seat.
     */
    private static double priceU = 6;
    /**
     * The price of Couple Seat.
     */
    private static double priceC = 8;
    /**
     * This Seat's type.
     */
    private SeatType type;

    /**
     * Creates new Seat with given ID and price.
     * 
     * @param seatID This Seat's ID.
     * @param price  This Seat's price.
     */
    public Seat(int seatID, SeatType type) {
        this.occupied = false;
        this.seatID = seatID;
        this.type = type;
    }

    /**
     * Gets whether this seat has been occupied.
     * 
     * @return This seat's occupancy.
     */
    public boolean isOccupied() {
        return this.occupied;
    }

    /**
     * Sets Occupied to True.
     */
    public void setOccupied() {
        if (!occupied) {
            this.occupied = true;
        } else {
            System.out.println("Seat is now occupied");
        }
    }

    /**
     * Sets Occupied to False.
     */
    public void setEmpty() {
        if (occupied) {
            this.occupied = false;
        } else {
            System.out.println("Seat is now empty");
        }
    }

    /**
     * Gets this Seat's ID.
     * 
     * @return This Seat's ID.
     */
    public int getSeatID() {
        return this.seatID;
    }

    /**
     * Gets this Seat's type.
     * 
     * @return This Seat's type.
     */
    public SeatType getSeatType() {
        return this.type;
    }

    /**
     * Gets this Seat's price.
     * 
     * @return This Seat's price.
     */
    public double getPriceProportion() {
        switch(this.getSeatType()) {
        case REGULAR:
        	return priceR;
        case ELITE:
        	return priceE;
        case ULTIMA:
        	return priceU;
        case COUPLE:
        	return priceC;
    	default:
    		return 0;
        }
    }

    /**
     * Static Mutator method to change price proportion of the seat.
     * @param type Type of Seat to be changed
     * @param newPrice the new price.
     */
    public static void setPriceProportion(SeatType type, double newPrice) {
    	switch(type) {
        case REGULAR:
        	priceR = newPrice;
        case ELITE:
        	priceE = newPrice;
        case ULTIMA:
        	priceU = newPrice;
        case COUPLE:
        	priceC = newPrice;
        }
    }

}
