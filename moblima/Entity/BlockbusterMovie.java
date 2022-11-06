package moblima.Entity;

import java.util.ArrayList;

/**
 * Represents a BlockbusterMovie 
 * Subclass of Movie superclass
 */
public class BlockbusterMovie extends Movie {
    /**
     * The price of this BlockbusterMovie.
     */
    private double price;
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
            int movieID, double price) {
        super(title, sypnosis, status, director, cast, movieID);
        this.price = price;
    }
    
    /**
     * Gets the price of this BlockbusterMovie. 
     * @return This BlockbusterMovie's price. 
     */
    public double getPriceProportion() {
        return price;
    }
}
