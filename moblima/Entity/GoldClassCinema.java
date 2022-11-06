package moblima.Entity;

import java.util.ArrayList;

public class GoldClassCinema extends Cinema {
    private String cinemaID;
    private ArrayList<Seat> seats;
    private double priceProportion;

    public GoldClassCinema(String cinemaID, double price) {
        super(cinemaID);
        priceProportion = price;
    }

    public double getPriceProportion() {
        return priceProportion;
    }

    public CinemaType getCinemaType() {
        return CinemaType.GOLD_CLASS;
    }
}
