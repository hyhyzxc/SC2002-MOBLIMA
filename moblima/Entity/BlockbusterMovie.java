package moblima.Entity;

import java.util.ArrayList;

/**
 * Represents a Movie
 * Subclass of Movie superclass
 */
public class BlockbusterMovie extends Movie {
    /**
     * Creates a new Movie with given title, sypnosis, status, director.
     * 
     * @param title    This Movie's title.
     * @param sypnosis This Movie's sypnosis.
     * @param status   This Movie's status.
     * @param director This Movie's director.
     * @param cast     This Movie's cast.
     * @param movieID  This Movie's movieID.
     * @param price    This Movie's price.
     */
    public BlockbusterMovie(String title, String sypnosis, ShowingStatus status, String director,
            ArrayList<String> cast,
            int movieID, double priceProportion) {
        super(title, sypnosis, status, director, cast, movieID, priceProportion);
    }
}
