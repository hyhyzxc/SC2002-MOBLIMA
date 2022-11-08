package moblima.Entity;

/**
 * Represents a CoupleSeat.
 * Subclass of Seat superclass.
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
