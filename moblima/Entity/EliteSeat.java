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
     * Gets type of Seat
     * @return type of Seat
     */
    public SeatType getSeatType() {
        return SeatType.ELITE;
    }
    /**
     * Gets price proportion constant for EliteSeat
     * @return price of EliteSeat
     */
    public double getPriceProportion() {
        return price;
    }
}
