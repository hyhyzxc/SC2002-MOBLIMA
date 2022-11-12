package moblima.Entity;

/**
 * Represents an Elite Seat.
 * Subclass of Seat superclass.
 */
public class EliteSeat extends Seat {
	/**
	 * Creates new EliteSeat.
	 * @param seatID This EliteSeat's ID.
	 * @param price This EliteSeat's price.
	 */
    public EliteSeat(int seatID, double price) {
        super(seatID, price);
        type = SeatType.ELITE;
    }
}
