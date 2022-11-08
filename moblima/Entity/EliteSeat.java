package moblima.Entity;

/**
 * Represents an Elite Seat
 * Concrete class that extends Seat
 */
public class EliteSeat extends Seat {
	/**
	 * The price of this EliteSeat
	 */
    private double price;
    
    /**
     * Creates a new EliteSeat with a seatID and price
     * @param seatID ID of the EliteSeat
     * @param price Price of the EliteSeat
     */
    public EliteSeat(int seatID, double price) {
        super(seatID);
        this.price = price;
    }
    /**
     * Gets the type of Seat.
     * @return this Seat's seatType.
     */
    public SeatType getSeatType() {
        return SeatType.ELITE;
    }
    /**
     * Gets the price proportion constant for EliteSeat
     * @return this eliteSeat's price. 
     */
    public double getPriceProportion() {
        return price;
    }
}
