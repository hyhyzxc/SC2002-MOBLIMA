package moblima.Manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

import moblima.Entity.Booking;
import moblima.Manager.SortByValue;
import moblima.Serializer.BookingSerializer;

public class SortBySales implements Sorter {
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
