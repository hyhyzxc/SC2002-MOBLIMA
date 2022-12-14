package moblima.Manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

import moblima.Entity.Movie;

/**
 * Represents a SortContext that delegates the sorting work to the sorter.
 * 
 * @author Amabel Lim
 * @version 1.0
 * @since 2022-11-12
 */
public class SortContext {
	/**
	 * The Sorter of this SortContext.
	 */
	private Sorter sorter;

	/**
	 * Creates a new SortContext with the given Sorter.
	 * 
	 * @param sorter this SortContext's Sorter.
	 */
	public SortContext(Sorter sorter) {
		this.sorter = sorter;
	}

	/**
	 * Sets the Sorter of this SortContext with the given Sorter.
	 * @param sorter Sorter to be set.
	 */
	public void setSort(Sorter sorter) {
		this.sorter = sorter;
	}

	/**
	 * Executes sorting.
	 * @param hm LinkedHashMap to be sorted.
	 * @return sorted LinkedHashMap.
	 */
	public LinkedHashMap<String, Float> executeSort(LinkedHashMap<String, Float> hm) {
		return this.sorter.sortBy(hm);
	}

	/**
	 * Executes sorting.
	 * @return Sorted LinkedHashMap.
	 */
	public LinkedHashMap<String, Float> executeSort() {
		return this.sorter.sortBy();
	}
}
