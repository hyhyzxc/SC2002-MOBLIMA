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

	public LinkedHashMap<String, Float> sortBy(LinkedHashMap<String, Float> hm);

	/**
	 * Method to sort a L
	 * 
	 * @return
	 */
	public LinkedHashMap<String, Float> sortBy();
}
