package moblima.Entity;

/**
 * Represents an Ultima Seat.
 * Subclass of Seat superclass.
 * @author Goh Hong Yi
 * @version 1.0
 * @since 2022-11-13
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
