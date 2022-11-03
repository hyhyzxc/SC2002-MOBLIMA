public class Seat {
    private boolean occupied;
    private int seatID;
    private SeatType seatType;

    public Seat(int seatID, SeatType seatType) {
        this.occupied = false;
        this.seatID = seatID;
        this.seatType = seatType;
    }

    public boolean isOccupied() {
        return this.occupied;
    }

    public void setOccupied() {
        if (!occupied) {
            this.occupied = true;
        } else {
            System.out.println("Seat is now occupied");
        }
    }

    public void setEmpty() {
        if (occupied) {
            this.occupied = false;
        } else {
            System.out.println("Seat is now empty");
        }
    }

    public SeatType getST() {
        return this.seatType;
    }

    public int getSeatID() {
        return this.seatID;
    }

}
