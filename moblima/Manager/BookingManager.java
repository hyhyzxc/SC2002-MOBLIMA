package moblima.Manager;

import moblima.Entity.*;
import moblima.Exceptions.*;
import moblima.Manager.*;
import moblima.Serializer.*;
import java.util.*;
import java.util.Map.Entry;

/**
 * Represent a BookingManager.
 * 
 * @author
 * @version 1.0
 * @since 2022-11-08
 */
public class BookingManager {
    /**
     * ArrayList consisting of bookings.
     */
    private ArrayList<Booking> bookings;
    static BookingSerializer s = new BookingSerializer();

    /**
     * Creates a new BookingManager.
     */
    public BookingManager() {
        bookings = s.getBookings("BookingDatabase.ser");
        if (bookings == null) {
            bookings = new ArrayList<Booking>();
        }
    }

    /**
     * Appends newBooking to ArrayList of current bookings.
     * Displays a message of a successful booking.
     * 
     * @param newBooking this BookingManager's newBooking.
     */
    public void addNewBooking(Booking newBooking) {
        bookings.add(newBooking);
        s.saveBookings(bookings, "BookingDatabase.ser");
        System.out.println("Booking Successfully Saved.");
    }

    /**
     * Searches for a customers booking with given owner.
     * Iterates through ArrayList of bookings and finds an entry corresponding to
     * the given owner.
     * 
     * @param owner This BookingManager's owner.
     * @return this owner's customerBookings.
     */
    public ArrayList<Booking> getBookingsOfCustomer(CustomerAccount owner) {
        bookings = s.getBookings("BookingDatabase.ser");
        ArrayList<Booking> customerBookings = new ArrayList<Booking>();
        for (Booking booking : bookings) {
            if (booking.getBooker().getUsername().equals(owner.getUsername())) {
                customerBookings.add(booking);
            }
        }
        return customerBookings;
    }

    /**
     * Gets an ArrayList of Booking.
     * 
     * @return this BookingManager's bookings.
     */
    public ArrayList<Booking> getBookings() {
        return bookings;
    }

    public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm) {
        // Create a list from elements of HashMap
        List<Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(hm.entrySet());

        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1,
                    Map.Entry<String, Integer> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        // put data from sorted list to hashmap
        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }

    public HashMap<String, Integer> sortMoviesBySales() {
        bookings = s.getBookings("BookingDatabase.ser");
        HashMap<String, Integer> map = new HashMap<>();
        for (Booking booking : bookings) {
            String movieBooked = booking.getSessionBooked().getMovie().getTitle();
            if (!map.containsKey(movieBooked)) {
                map.put(movieBooked, 1);
            } else {
                Integer sale = map.get(movieBooked);
                map.replace(movieBooked, sale, sale + 1);
            }
        }
        HashMap<String, Integer> sortedMap = sortByValue(map);
        return sortedMap;

    }

}
