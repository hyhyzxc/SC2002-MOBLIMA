package moblima.Entity;

import java.util.ArrayList;

/**
 * Represents a BlockbusterMovie 
 * Subclass of Movie superclass
 */
public class BlockbusterMovie extends Movie {
    /**
     * Creates a new BlockbusterMovie with given title, sypnosis, status, director. 
     * @param title This BlockbusterMovie's title. 
     * @param sypnosis This BlockbusterMovie's sypnosis. 
     * @param status This BlockbusterMovie's status. 
     * @param director This BlockbusterMovie's director. 
     * @param cast This BlockbusterMovie's cast.
     * @param movieID This BlockbusterMovie's movieID.
     * @param price This BlockbusterMovie's price.
     */
    public BlockbusterMovie(String title, String sypnosis, ShowingStatus status, String director,
            ArrayList<String> cast,
            int movieID, double priceProportion) {
        super(title, sypnosis, status, director, cast, movieID, priceProportion);
    }
}
