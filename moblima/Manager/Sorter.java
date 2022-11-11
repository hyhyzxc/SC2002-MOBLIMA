package moblima.Manager;

import java.util.ArrayList;

import moblima.Entity.Movie;

/**
 * Interface for Sorting ArrayLists.
 */
public interface Sorter {
	public ArrayList<Movie> sort(ArrayList<Movie> arrayList);
}
// /**
// * Gets an ArrayList that is sorted.
// *
// * @return sorted ArrayList.
// */
// public ArrayList getSortedRating();

// public ArrayList getSortedSales();