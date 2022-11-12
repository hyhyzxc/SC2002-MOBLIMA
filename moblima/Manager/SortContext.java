package moblima.Manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

import moblima.Entity.Movie;

public class SortContext {
	private Sorter sorter;

	public SortContext(Sorter sorter) {
		this.sorter = sorter;
	}

	public void setSort(Sorter sorter) {
		this.sorter = sorter;
	}

	public LinkedHashMap<String, Float> executeSort(LinkedHashMap<String, Float> hm) {
		return this.sorter.sortBy(hm);
	}

	public LinkedHashMap<String, Float> executeSort() {
		return this.sorter.sortBy();
	}
}
