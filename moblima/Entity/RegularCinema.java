package moblima.Entity;

import java.util.*;
/**
 * Represents a Regular Cinema
 * Concrete class that extends from Cinema.
 * @author Darren Lee
 * @version 1.0
 * @since 2022-11-13
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
