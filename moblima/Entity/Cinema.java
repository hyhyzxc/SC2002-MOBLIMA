package moblima.Entity;

import java.io.Serializable;
import java.util.*;

public abstract class Cinema implements Serializable {
    private String cinemaID;
    private ArrayList<Seat> seats;

    public Cinema(String cinemaID) {
        this.cinemaID = cinemaID;
        this.seats = new ArrayList<Seat>();
        for (int i = 0; i < 20; i++) {
            seats.add(new RegularSeat(i + 1, 2.0));
        }
        for (int i = 20; i < 30; i++) {
            seats.add(new CoupleSeat(i + 1, 8.0));
        }
        for (int i = 30; i < 40; i++) {
            seats.add(new EliteSeat(i + 1, 4.0));
        }
        for (int i = 40; i < 50; i++) {
            seats.add(new UltimaSeat(i + 1, 6.0));
        }
    }

    public String getCinemaID() {
        return cinemaID;
    }

    public ArrayList<Seat> getSeats() {
        return seats;
    }

    public abstract double getPriceProportion();

    public abstract CinemaType getCinemaType();
}
