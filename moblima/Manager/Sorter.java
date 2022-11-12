package moblima.Manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Interface for Sorting ArrayLists.
 */
public interface Sorter {
	public LinkedHashMap<String, Float> sortBy(LinkedHashMap<String, Float> hm);

	public LinkedHashMap<String, Float> sortBy();
}
