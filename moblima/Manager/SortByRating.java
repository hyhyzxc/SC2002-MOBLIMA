package moblima.Manager;

import java.util.ArrayList;

import moblima.Entity.Movie;

public class SortByRating implements Sorter {

	@Override
	public ArrayList<Movie> sort(ArrayList<Movie> arr) {
		arr.sort((m1, m2) -> m1.getAverageRatings() > m2.getAverageRatings() ? -1 : 1);
		return arr;
	}

}
