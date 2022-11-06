package moblima.Entity;

import java.io.Serializable;

public abstract class Seat implements Serializable {
    private boolean occupied;
    private int seatID;

    public Seat(int seatID) {
        this.occupied = false;
        this.seatID = seatID;

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

    public int getSeatID() {
        return this.seatID;
    }

    public abstract SeatType getSeatType();

    public abstract double getPriceProportion();

}
