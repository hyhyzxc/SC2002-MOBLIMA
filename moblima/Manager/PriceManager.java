package moblima.Manager;

import java.util.ArrayList;

import moblima.Entity.Booking;
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
        DayType dayType = session.getDay();
        Status status = booking.getStatus();
        Seat seat = booking.getSeatBooked();
        Movie movie = session.getMovie();
        Cineplex cineplex = booking.getCineplexBooked();

        price += movie.getPriceProportion();
        switch (dayType.getName()) {
            case ("Weekday"):
                price += 6.5;
                break;
            case ("Weekend"):
                price += 9.0;
                break;
            case ("Public Holiday"):
                price += 10;
                break;
            default:
                break;
        }

        switch (status) {
            case STUDENT:
                price -= 2.0;
                break;
            case ADULT:
                break;
            case SENIOR_CITIZEN:
                price -= 3.0;
                break;
            default:
                break;

        }

        price += seat.getPriceProportion();
        price += movie.getPriceProportion();

        return price;
    }

}
