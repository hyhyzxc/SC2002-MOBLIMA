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
     * This Seat's Price.
     */
    private double price;
    /**
     * This Seat's type.
     */
    protected SeatType type;

    /**
     * Creates new Seat with given ID and price.
     * @param seatID This Seat's ID.
     * @param price This Seat's price.
     */
    public Seat(int seatID, double price) {
        this.occupied = false;
        this.seatID = seatID;
        this.price = price;
    }

    /**
     * Gets whether this seat has been occupied.
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
     * @return This Seat's ID.
     */
    public int getSeatID() {
        return this.seatID;
    }
    
    /**
     * Gets this Seat's type.
     * @return This Seat's type.
     */
    public SeatType getSeatType() {
    	return this.type;
    }
    
    /**
     * Gets this Seat's price.
     * @return This Seat's price.
     */
    public double getPriceProportion() {
    	return this.price;
    }

}
