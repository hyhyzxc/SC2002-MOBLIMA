package moblima.Entity;

import java.util.ArrayList;
/**
 * Represents a Gold Class Cinema
 * Concrete class that extends from Cinema.
 * @author Darren Lee
 * @version 1.0
 * @since 2022-11-13
 */
public class GoldClassCinema extends Cinema {
	/**
	 * Creates new GoldClassCinema
	 * @param cinemaID ID of the GoldClassCinema
	 * @param price priceProportionality constant of the GoldClassCinema
	 */
    public GoldClassCinema(String cinemaID, double price) {
        super(cinemaID, price);
        super.type = CinemaType.GOLD_CLASS;
    }
}
