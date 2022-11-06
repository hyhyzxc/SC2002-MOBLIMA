package moblima.Manager;

import java.util.ArrayList;

import moblima.Entity.DayType;
import moblima.Entity.Movie;
import moblima.Entity.SeatType;
import moblima.Entity.Session;
import moblima.Entity.Status;
import moblima.Entity.Ticket;

/**
 * Logic Class that calculates price of tickets. Can be an individual ticket or
 * the total of all tickets.
 */
public class PriceManager {

    /**
     * Returns the price of a single ticket based on movie type, day type,
     * status (CHILD, ADULT, SENIOR CITIZEN), time of day.
     * 
     * @param ticket A single unit from tickets
     */
    public double calcPrice(Ticket ticket) {
        double price = 0;
        Session session = ticket.getSessionBooked();
        DayType dayType = session.getDay();
        Status status = ticket.getStatus();
        SeatType seatType = ticket.getSeatType();
        Movie movie = session.getMovie();

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

        switch (seatType) {
            case COUPLE:
                price *= 2;
                price += 2;
                break;
            case ELITE:
                price += 3;
            case REGULAR:
                break;
            case ULTIMA:
                price += 5;
            default:
                break;
        }

        return price;
    }

    /**
     * Returns the total cost of all tickets in the "Shopping Cart"
     * 
     * @param tickets the ArrayList of Ticket type
     */
    public double calcTotalPrice(ArrayList<Ticket> tickets) {
        double total = 0;
        for (Ticket ticket : tickets) {
            total += calcPrice(ticket);
        }

        return total;
    }
}
