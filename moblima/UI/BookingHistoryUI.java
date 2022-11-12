package moblima.UI;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import moblima.Entity.*;
import moblima.Exceptions.*;
import moblima.Manager.*;
import java.util.*;

/**
 * Handles all user IO for current BookingHistory
 * 
 * @author
 *
 */
public class BookingHistoryUI {
    /**
     * The Owner that this BookingHistoryUI is servicing.
     */
    private CustomerAccount owner;
    /**
     * This StaffUI's list of managers.
     */
    private ManagerList managerList;

    /**
     * Creates new BookingHistoryUI with given account and managerList.
     * 
     * @param account     The Owner that this BookingHistoryUI is servicing.
     * @param managerList This StaffUI's list of managers.
     */
    public BookingHistoryUI(CustomerAccount account, ManagerList managerList) {
        this.owner = account;
        this.managerList = managerList;
    }

    /**
     * Retrieves BookingHistory of owner from BookingManager and displays them.
     */
    private void getBookingHistory() {
        BookingManager BM = managerList.getBookingManager();
        PriceManager PM = managerList.getPriceManager();
        ArrayList<Booking> bookings = BM.getBookingsOfCustomer(owner);
        if (bookings == null) {
            System.out.println("No bookings made.");
            return;
        } else {
            for (Booking booking : bookings) {
                booking.toTicket();
                System.out.printf("| %-20s | %-20s |%n", "Seat Type: ", PM.calcPrice(booking));
            }
        }
    }

    /**
     * Initialises BookingHistoryUI.
     */
    public void init() {
        getBookingHistory();
        return;
    }
}
