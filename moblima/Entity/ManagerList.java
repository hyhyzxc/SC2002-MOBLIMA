package moblima.Entity;

import java.io.Serializable;
import java.util.ArrayList;

import moblima.Manager.*;
/**
 * Represent a ManagerList. 
 * Maintains an instance of all managers. 
 * @author Wong Changman Isaac 
 * @version 1.0
 * @since 2022-11-08
 */
public class ManagerList {
   /**
    * This customerManager of this ManagerList. 
    */
   private CustomerManager customerManager;
   /**
    * This movieManager of this ManagerList. 
    */
   private MovieManager movieManager;
   /**
    * This staffManager of this ManagerList. 
    */
   private StaffManager staffManager;
   /**
   * This cinemaManager of this ManagerList. 
   */
   private CinemaManager cinemaManager;
   /**
   * This bookingManager of this ManagerList. 
   */
   private BookingManager bookingManager;
   /**
   * This priceManager of this ManagerList. 
   */
   private PriceManager priceManager;

   /**
    * Creates a new ManagerList. 
    * Creates a new instance of each manager. 
    */
   public ManagerList() {
       this.customerManager = new CustomerManager();
       this.movieManager = new MovieManager();
       this.staffManager = new StaffManager();
       this.cinemaManager = new CinemaManager();
       this.bookingManager = new BookingManager();
       this.priceManager = new PriceManager();
   }

   /**
    * Gets the customerManager of this ManagerList.
    * @return this ManagerList's customerManager.
    */
   public CustomerManager getCustomerManager() {
       return customerManager;
   }

   /**
    * Gets the movieManager of this ManagerList.
    * @return this ManagerList's movieManager.
    */
   public MovieManager getMovieManager() {
       return movieManager;
   }

   /**
    * Gets the staffManager of this ManagerList.
    * @return this ManagerList's staffManager.
    */
   public StaffManager getStaffManager() {
       return staffManager;
   }

   /**
    * Gets the cinemaManager of this ManagerList.
    * @return this ManagerList's cinemaManager.
    */
   public CinemaManager getCinemaManager() {
       return cinemaManager;
   }

   /**
    * Gets the bookingManager of this ManagerList.
    * @return this ManagerList's bookingManager.
    */
   public BookingManager getBookingManager() {
       return bookingManager;
   }

   /**
    * Gets the priceManager of this ManagerList.
    * @return this ManagerList's priceManager.
    */
   public PriceManager getPriceManager() {
       return priceManager;
   }
}