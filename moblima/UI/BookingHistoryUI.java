package moblima.UI;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import moblima.Entity.*;
import moblima.Exceptions.*;
import moblima.Manager.*;
import java.util.*;

public class BookingHistoryUI {
    private static CustomerAccount owner;
    private static ManagerList managerList;

    public BookingHistoryUI(CustomerAccount account, ManagerList managerList) {
        this.owner = account;
        this.managerList = managerList;
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

    public void init() {
        getBookingHistory();
        return;
    }
}
