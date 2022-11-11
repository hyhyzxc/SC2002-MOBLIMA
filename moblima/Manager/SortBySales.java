package moblima.Manager;

import java.util.ArrayList;

import moblima.Entity.Movie;

public class SortBySales implements Sorter {

	@Override
	public ArrayList<Movie> sort(ArrayList<Movie> arr) {
		arr.sort((m1, m2) -> m1.getNumSales() > m2.getNumSales() ? -1 : 1);
		return arr;
	}
}
