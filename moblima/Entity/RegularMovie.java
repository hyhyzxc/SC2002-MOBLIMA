package moblima.Entity;

import java.util.ArrayList;

/**
 * Represents a 3D Movie.
 * Subclass of Movie Superclass.
 * @author Goh Hong Yi
 * @version 1.0
 * @since 2022-11-13
 */
public class RegularMovie extends Movie {
    /**
     * Creates a new RegularMovie with given title, sypnosis, status, director.
     * 
     * @param title    This RegularMovie's title.
     * @param sypnosis This RegularMovie's sypnosis.
     * @param status   This RegularMovie's status.
     * @param director This RegularMovie's director.
     * @param cast     This RegularMovie's cast.
     * @param movieID  This RegularMovie's movieID.
     * @param price    This RegularMovie's price.
     */
    public RegularMovie(String title, String sypnosis, ShowingStatus status, String director, ArrayList<String> cast,
            int movieID) {
        super(title, sypnosis, status, director, cast, movieID);
        priceProportion = 2;
    }

    public String printType() {
        return "Regular Movie";
    }
}
