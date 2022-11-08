package moblima.Entity;

/**
 * Represents a CoupleSeat.
 * Concrete base class that extends Seat.
 */
public class CoupleSeat extends Seat {
    /**
     * The price of this CoupleSeat.
     */
    private double price;

    /**
     * Creates a new CoupleSeat with the given seatID and price.
     * @param seatID This CoupleSeat's seatID.
     * @param price This coupleSeat's price.
     */
    public CoupleSeat(int seatID, double price) {
        super(seatID);
        this.price = price;
    }

    /**
     * Gets the type of Seat.
     * @return this Seat's seatType.
     */
    public SeatType getSeatType() {
        return SeatType.COUPLE;
    }

    /**
     * Gets the price proportion constant for CoupleSeat. 
     * @return this CoupleSeat's price.
     */
    public double getPriceProportion() {
        return price;
    }
}
