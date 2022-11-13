package moblima.Manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

import moblima.Entity.ManagerList;
import moblima.Entity.Movie;

/**
 * Represents a SortByRatings.
 * Concrete base class that imlements Sorter interface.
 * 
 * @author Yap Shen Hwei
 * @version 1.0
 * @since 2022-11-11
 */
public class SortByRatings implements Sorter {
	MovieManager MM = (new ManagerList()).getMovieManager();

	/**
	 * Sorts the movies the the LinkedHashMap according to their ratings.
	 * Movies with the highest ratings will be listed first.
	 * 
	 * @return a LinkedHashMap of sorted movie titles.
	 */
	public LinkedHashMap<String, Float> sortBy() {
		ArrayList<Movie> movies = MM.getSorted();
		LinkedHashMap<String, Float> hm = new LinkedHashMap<>();

		for (Movie movie : movies) {
			// System.out.println(movie.getAverageRatings());
			hm.put(movie.getTitle(), movie.getAverageRatings());
		}

		return hm;

	}

	@Override
	public LinkedHashMap<String, Float> sortBy(LinkedHashMap<String, Float> hm) {
		// TODO Auto-generated method stub
		return null;
	}

}
