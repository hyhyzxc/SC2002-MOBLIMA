package moblima.Entity;

public class RegularSeat extends Seat {
    private double price;

    public RegularSeat(int seatID, double price) {
        super(seatID);
        this.price = price;
    }

    public SeatType getSeatType() {
        return SeatType.REGULAR;
    }

    public double getPriceProportion() {
        return price;
    }
}
