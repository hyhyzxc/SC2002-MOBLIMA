package moblima.Entity;

import java.util.*;

public abstract class Cinema {
    private int cinemaID;
    private ArrayList<Seat> seats;

    public Cinema(int cinemaID, ArrayList<Seat> seats) {
        this.cinemaID = cinemaID;
        this.seats = seats;
    }

    public int getCinemaID() {
        return cinemaID;
    }

    public ArrayList<Seat> getSeats() {
        return seats;
    }

    public abstract double getPriceProportion();
}
