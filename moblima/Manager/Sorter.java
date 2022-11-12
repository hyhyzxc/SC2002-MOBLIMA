package moblima.Manager;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Interface for Sorting ArrayLists.
 */
public interface Sorter {
	public HashMap<String, Float> sortBy(HashMap<String, Float> hm);

	public HashMap<String, Float> sortBy();
}
