package moblima.Entity;

import java.util.*;
/**
 * Represents a Regular Cinema
 * Concrete class that extends from Cinema
 */
public class RegularCinema extends Cinema {
    public RegularCinema(String cinemaID, double price) {
    	/**
    	 * Creates new RegularCinema
    	 * @param cinemaID ID of the RegularCinema
    	 * @param price priceProportionality constant of the RegularCinema
    	 */
        super(cinemaID, price);
        super.type = CinemaType.REGULAR;
    }
}
