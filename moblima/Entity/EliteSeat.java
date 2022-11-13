package moblima.Entity;

/**
 * Represents an Elite Seat.
 * Subclass of Seat superclass.
 * @author Goh Hong Yi
 * @version 1.0
 * @since 2022-11-13
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
