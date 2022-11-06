package moblima.Entity;

public class EliteSeat extends Seat {
    private double price;

    public EliteSeat(int seatID, double price) {
        super(seatID);
        this.price = price;
    }

    public SeatType getSeatType() {
        return SeatType.ELITE;
    }

    public double getPriceProportion() {
        return price;
    }
}
