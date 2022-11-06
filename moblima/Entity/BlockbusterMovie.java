package moblima.Entity;

import java.util.ArrayList;

public class BlockbusterMovie extends Movie {
    private double price;

    public BlockbusterMovie(String title, String sypnosis, ShowingStatus status, String director,
            ArrayList<String> cast,
            int movieID, double price) {
        super(title, sypnosis, status, director, cast, movieID);
        this.price = price;
    }

    public double getPriceProportion() {
        return price;
    }
}
