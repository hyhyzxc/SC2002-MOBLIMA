package moblima.Entity;

import java.util.*;

public class RegularCinema extends Cinema {
    private int cinemaID;
    private ArrayList<Seat> seats;
    private double priceProportion;

    public RegularCinema(String cinemaID, double price) {
        super(cinemaID);
        priceProportion = price;
    }

    public double getPriceProportion() {
        return priceProportion;
    }

    public CinemaType getCinemaType() {
        return CinemaType.REGULAR;
    }
}
