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

    public static LinkedHashMap<String, Float> sortByValue(LinkedHashMap<String, Float> hm) {
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

    public LinkedHashMap<String, Float> sortMoviesBySales() {
        bookings = s.getBookings("BookingDatabase.ser");
        LinkedHashMap<String, Float> map = new LinkedHashMap<>();
        for (Booking booking : bookings) {
            String movieBooked = booking.getSessionBooked().getMovie().getTitle();
            if (!map.containsKey(movieBooked)) {
                map.put(movieBooked, (float) 1);
            } else {
                Float sale = map.get(movieBooked);
                map.replace(movieBooked, sale, sale + 1);
            }
        }
        LinkedHashMap<String, Float> sortedMap = sortByValue(map);
        return sortedMap;

    }

}
