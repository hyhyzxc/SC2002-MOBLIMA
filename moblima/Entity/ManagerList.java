package moblima.Entity;

import java.io.Serializable;

import moblima.Manager.*;

public class ManagerList {
    private CustomerManager customerManager;
    private MovieManager movieManager;
    private StaffManager staffManager;
    private CinemaManager cinemaManager;
    private BookingManager bookingManager;
    private PriceManager priceManager;

    public ManagerList() {
        this.customerManager = new CustomerManager();
        this.movieManager = new MovieManager();
        this.staffManager = new StaffManager();
        this.cinemaManager = new CinemaManager();
        this.bookingManager = new BookingManager();
        this.priceManager = new PriceManager();
    }

    public CustomerManager getCustomerManager() {
        return customerManager;
    }

    public MovieManager getMovieManager() {
        return movieManager;
    }

    public StaffManager getStaffManager() {
        return staffManager;
    }

    public CinemaManager getCinemaManager() {
        return cinemaManager;
    }

    public BookingManager getBookingManager() {
        return bookingManager;
    }

    public PriceManager getPriceManager() {
        return priceManager;
    }
}
