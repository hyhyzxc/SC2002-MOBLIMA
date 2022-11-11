package moblima.Manager;

import java.util.ArrayList;

import moblima.Entity.Movie;

public class SortContext {
	private Sorter sorter;

	public SortContext(Sorter sorter) {
		this.sorter = sorter;
	}

	public void setSort(Sorter sorter) {
		this.sorter = sorter;
	}

	public ArrayList<Movie> executeSort(ArrayList<Movie> arr) {
		return this.sorter.sort(arr);
	}
}
