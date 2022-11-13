package moblima.Entity;

/**
 * Represents an Regular Seat.
 * Subclass of Seat superclass.
 * @author Isaac Wong
 * @version 1.0
 * @since 2022-11-13
 */
public class RegularSeat extends Seat {
	/**
	 * Creates new RegularSeat.
	 * @param seatID This RegularSeat's ID.
	 * @param price This RegularSeat's price.
	 */
    public RegularSeat(int seatID, double price) {
        super(seatID, price);
        type = SeatType.REGULAR;
    }
}
