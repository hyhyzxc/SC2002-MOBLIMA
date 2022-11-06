package moblima.Entity;

public class UltimaSeat extends Seat {
    private double price;

    public UltimaSeat(int seatID, double price) {
        super(seatID);
        this.price = price;
    }

    public SeatType getSeatType() {
        return SeatType.ULTIMA;
    }

    public double getPriceProportion() {
        return price;
    }
}
