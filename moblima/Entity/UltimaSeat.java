package moblima.Entity;

/**
 * Represents an Ultima Seat.
 * Subclass of Seat superclass.
 */
public class UltimaSeat extends Seat {
	/**
	 * Creates new UltimaSeat.
	 * @param seatID This UltimaSeat's ID.
	 * @param price This UltimaSeat's price.
	 */
    public UltimaSeat(int seatID, double price) {
        super(seatID, price);
        type = SeatType.ULTIMA;
    }
}
