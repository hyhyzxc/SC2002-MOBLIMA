package moblima.Manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Interface for Sorters that implements from it. For example, SortBySales and
 * SortByRatings are classes that realises Sorter.
 * 
 * @author Isaac Wong
 * @version 1.0
 * @since 2022-11-11
 */
public interface Sorter {
	/**
	 * Allows Sorter types to implement their own sorting algorithms
	 * 
	 * @param hm
	 * @return A sorted LinkedHashMap according to the sorting algorithm.
	 */
	public LinkedHashMap<String, Float> sortBy(LinkedHashMap<String, Float> hm);

	/**
	 * Method to sort a L
	 * 
	 * @return A sorted LinkedHashMap according to the sorting algorithm.
	 */
	public LinkedHashMap<String, Float> sortBy();
}
