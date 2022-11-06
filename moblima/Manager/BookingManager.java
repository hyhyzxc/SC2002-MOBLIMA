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

    public ArrayList<Booking> getBookings() {
        return bookings;
    }

}
