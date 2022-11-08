package moblima.Entity;

import java.util.ArrayList;

/**
 * Represents a 3D Movie
 * Subclass of Movie Superclass
 */
public class ThreeDMovie extends Movie {
	/**
     * Creates a new ThreeDMovie with given title, sypnosis, status, director. 
     * @param title This ThreeDMovie's title. 
     * @param sypnosis This ThreeDMovie's sypnosis. 
     * @param status This ThreeDMovie's status. 
     * @param director This ThreeDMovie's director. 
     * @param cast This ThreeDMovie's cast.
     * @param movieID This ThreeDMovie's movieID.
     * @param price This ThreeDMovie's price.
     */
    public ThreeDMovie(String title, String sypnosis, ShowingStatus status, String director,
            ArrayList<String> cast,
            int movieID, double price) {
        super(title, sypnosis, status, director, cast, movieID, price);
        this.price = price;
    }
}
