package moblima.Manager;

import java.util.ArrayList;

import moblima.Entity.Booking;
import moblima.Entity.Cinema;
import moblima.Entity.Cineplex;
import moblima.Entity.DayType;
import moblima.Entity.Movie;
import moblima.Entity.Seat;
import moblima.Entity.SeatType;
import moblima.Entity.Session;
import moblima.Entity.Status;

/**
 * Logic Class that calculates price of a booking. Can be an individual ticket
 * or
 * the total of all tickets.
 */
public class PriceManager {

    /**
     * Returns the price of a single ticket based on movie type, day type,
     * status (CHILD, ADULT, SENIOR CITIZEN), time of day.
     * 
     * @param ticket A single unit from tickets
     */
    public double calcPrice(Booking booking) {
        double price = 0;
        Session session = booking.getSessionBooked();
        String day = session.getDay();
        String status = booking.getStatus();
        Seat seat = booking.getSeatBooked();
        Movie movie = session.getMovie();

        Cinema cinema = booking.getCinemaBooked();
        price += movie.getPriceProportion();
        price += new DayType().getPriceProportion(day);
        price += new Status().getPriceProportion(status);
        price += seat.getPriceProportion();
        price += cinema.getPriceProportion();

        return price;
    }

    public void setPriceProportion(Object o, double newPrice) {
        if (o instanceof Movie) {
            ((Movie) o).setPriceProportion(newPrice);
        } else if (o instanceof Cinema) {
            ((Cinema) o).setPriceProportion(newPrice);
        } else if (o instanceof Seat) {
            ((Seat) o).setPriceProportion(newPrice);
        } else {
            // throw some errors
        }
    }
}
