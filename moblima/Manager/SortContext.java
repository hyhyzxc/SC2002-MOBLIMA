package moblima.Manager;

import java.util.ArrayList;
import java.util.HashMap;

import moblima.Entity.Movie;

public class SortContext {
	private Sorter sorter;

	public SortContext(Sorter sorter) {
		this.sorter = sorter;
	}

	public void setSort(Sorter sorter) {
		this.sorter = sorter;
	}

	public HashMap<String, Float> executeSort(HashMap<String, Float> hm) {
		return this.sorter.sortBy(hm);
	}

	public HashMap<String, Float> executeSort() {
		return this.sorter.sortBy();
	}
}
