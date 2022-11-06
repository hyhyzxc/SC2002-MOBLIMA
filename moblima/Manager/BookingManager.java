package moblima.Manager;

import moblima.Entity.*;
import moblima.Exceptions.*;
import moblima.Manager.*;
import moblima.Serializer.*;
import java.util.*;

public class BookingManager {
    private ArrayList<Booking> bookings;
    static BookingSerializer s = new BookingSerializer();

    public BookingManager() {
        bookings = s.getBookings("BookingDatabase.ser");
        if (bookings == null) {
            bookings = new ArrayList<Booking>();
        }
    }

    public void addNewBooking(Booking newBooking) {
        bookings.add(newBooking);
        s.saveBookings(bookings, "BookingDatabase.ser");
        System.out.println("Booking Successfully Saved.");
    }

}
