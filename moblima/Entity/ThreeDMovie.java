package moblima.Entity;

import java.util.ArrayList;

public class ThreeDMovie extends Movie {
    private double price;

    public ThreeDMovie(String title, String sypnosis, ShowingStatus status, String director,
            ArrayList<String> cast,
            int movieID, double price) {
        super(title, sypnosis, status, director, cast, movieID);
        this.price = price;
    }

    public double getPriceProportion() {
        return price;
    }
}
