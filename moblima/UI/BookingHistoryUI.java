package moblima.UI;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import moblima.Database.*;
import moblima.Entity.*;
import moblima.Exceptions.*;
import moblima.Manager.*;
import java.util.*;

public class BookingHistoryUI {
    private static CustomerAccount owner;
    private static ManagerList managerList = new ManagerList();

    public BookingHistoryUI(CustomerAccount account) {
        this.owner = account;
    }

    private static void getBookingHistory() {
        BookingManager BM = managerList.getBookingManager();
        ArrayList<Booking> bookings = BM.getBookingsOfCustomer(owner);
        if (bookings == null) {
            System.out.println("No bookings made.");
            return;
        } else {
            for (Booking booking : bookings) {
                booking.toTicket();
            }
        }
    }

    public static void main(String[] args) {
        getBookingHistory();
        return;
    }
}
