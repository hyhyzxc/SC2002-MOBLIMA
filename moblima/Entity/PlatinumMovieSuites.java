package moblima.Entity;

import java.util.ArrayList;

public class PlatinumMovieSuites extends Cinema {
    private int cinemaID;
    private ArrayList<Seat> seats;
    private double priceProportion;

    public PlatinumMovieSuites(String cinemaID, double price) {
        super(cinemaID);
        priceProportion = price;
    }

    public double getPriceProportion() {
        return priceProportion;
    }

    public CinemaType getCinemaType() {
        return CinemaType.PLATINUM_MOVIE_SUITES;
    }
}
