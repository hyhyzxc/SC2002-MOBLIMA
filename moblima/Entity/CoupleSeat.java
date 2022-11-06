package moblima.Entity;

public class CoupleSeat extends Seat {
    private double price;

    public CoupleSeat(int seatID, double price) {
        super(seatID);
        this.price = price;
    }

    public SeatType getSeatType() {
        return SeatType.COUPLE;
    }

    public double getPriceProportion() {
        return price;
    }
}
