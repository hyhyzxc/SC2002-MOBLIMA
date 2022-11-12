package moblima.Manager;

import java.util.ArrayList;
import java.util.HashMap;

import moblima.Entity.Booking;
import moblima.Manager.SortByValue;
import moblima.Serializer.BookingSerializer;

public class SortBySales implements Sorter {
	public HashMap<String, Float> sortBy() {
		ArrayList<Booking> bookings = (new BookingSerializer()).getBookings("BookingDatabase.ser");
		HashMap<String, Float> map = new HashMap<>();
		for (Booking booking : bookings) {
			String movieBooked = booking.getSessionBooked().getMovie().getTitle();
			if (!map.containsKey(movieBooked)) {
				map.put(movieBooked, (float)1);
			} else {
				Float sale = map.get(movieBooked);
				map.replace(movieBooked, (float) sale, (float) (sale + 1));
			}
		}
		HashMap<String, Float> sortedMap = (new SortByValue()).sortBy(map);
		return sortedMap;
	}

	@Override
	public HashMap<String, Float> sortBy(HashMap<String, Float> hm) {
		// TODO Auto-generated method stub
		return null;
	}

}
