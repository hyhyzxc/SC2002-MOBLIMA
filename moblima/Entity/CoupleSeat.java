package moblima.Entity;

/**
 * Represents a CoupleSeat.
 * Subclass of Seat superclass.
 * @author Amabel Lim
 * @version 1.0
 * @since 2022-11-13
 */
public class CoupleSeat extends Seat {
    /**
	 * Creates new CoupleSeat.
	 * @param seatID This CoupleSeat's ID.
	 * @param price This CoupleSeat's price.
	 */
    public CoupleSeat(int seatID, double price) {
        super(seatID, price);
        type = SeatType.ELITE;
    }
}
