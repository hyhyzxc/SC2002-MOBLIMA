package moblima.Manager;

import java.util.*;
import java.util.Map.Entry;
/**
 * Represents a SortByValue.
 * Concrete base class that implements Sorter interface.
 * @author Yap Shen Hwei
 * @version 1.0
 * @since 2022-11-11
 */
public class SortByValue implements Sorter {

	@Override
	public LinkedHashMap<String, Float> sortBy(LinkedHashMap<String, Float> hm) {
		// Create a list from elements of HashMap
		List<Entry<String, Float>> list = new LinkedList<Map.Entry<String, Float>>(hm.entrySet());

		// Sort the list
		Collections.sort(list, new Comparator<Map.Entry<String, Float>>() {
			public int compare(Map.Entry<String, Float> o1,
					Map.Entry<String, Float> o2) {
				return (o2.getValue()).compareTo(o1.getValue());
			}
		});

		// put data from sorted list to hashmap
		LinkedHashMap<String, Float> temp = new LinkedHashMap<String, Float>();
		for (Map.Entry<String, Float> aa : list) {
			temp.put(aa.getKey(), aa.getValue());
		}
		return temp;
	}

	@Override
	public LinkedHashMap<String, Float> sortBy() {
		// TODO Auto-generated method stub
		return null;
	}
}
