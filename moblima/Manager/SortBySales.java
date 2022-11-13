package moblima.Manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

import moblima.Entity.Booking;
import moblima.Manager.SortByValue;
import moblima.Serializer.BookingSerializer;

/**
 * Represents a SortBySales.
 * Concrete base class that implements the Sorter interface.
 * @author Yap Shen Hwei
 * @version 1.0
 * @since 2022-11-11
 */
public class SortBySales implements Sorter {
	/**
	 * Sorts the movies the the LinkedHashMap according to their movie sales.
	 * Movies with the most sales will be listed first.
	 * @return a LinkedHashMap of sorted movie titles.
	 */
	public LinkedHashMap<String, Float> sortBy() {
		ArrayList<Booking> bookings = (new BookingSerializer()).getBookings("BookingDatabase.ser");
		LinkedHashMap<String, Float> map = new LinkedHashMap<>();
		for (Booking booking : bookings) {
			String movieBooked = booking.getSessionBooked().getMovie().getTitle();
			if (!map.containsKey(movieBooked)) {
				map.put(movieBooked, (float) 1);
			} else {
				Float sale = map.get(movieBooked);
				map.replace(movieBooked, (float) sale, (float) (sale + 1));
			}
		}
		LinkedHashMap<String, Float> sortedMap = (new SortByValue()).sortBy(map);
		return sortedMap;
	}

	@Override
	public LinkedHashMap<String, Float> sortBy(LinkedHashMap<String, Float> hm) {
		// TODO Auto-generated method stub
		return null;
	}

}
