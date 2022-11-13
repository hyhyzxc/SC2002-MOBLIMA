package moblima.Entity;

import java.util.ArrayList;

/**
 * Represents a Platinum Movie Suites.
 * Concrete class that extends from Cinema.
 * @author Yap Shen Hwei
 * @version 1.0
 * @since 2022-11-13
 */
public class PlatinumMovieSuites extends Cinema {
	/**
	 * Creates new PlatinumMovieSuites
	 * 
	 * @param cinemaID ID of the PlatinumMovieSuites
	 * @param price    priceProportionality constant of the PlatinumMovieSuites
	 */
	public PlatinumMovieSuites(String cinemaID, double price) {
		super(cinemaID, price);
		super.type = CinemaType.PLATINUM_MOVIE_SUITES;
	}

}
