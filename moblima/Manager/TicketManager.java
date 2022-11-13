package moblima.Manager;

import java.util.ArrayList;

import moblima.Entity.Ticket;

/**
 * Responsible for creating a storage of Ticket type 
 * whose lifetime last only during runtime.
 * @author Amabel Lim
 * @version 1.0
 * @since 2022-11-11
 */
public class TicketManager {
	ArrayList<Ticket> tickets = new ArrayList<Ticket>();

	// static TicketSerializer s = new TicketSerializer();
	public TicketManager() {
		tickets = null;
	}

	/**
	 * Adds a new ticket into the ArrayList<Ticket> tickets. This allows
	 * customer to purchase multiple tickets with different statuses for each
	 * Booking.
	 * 
	 * @param newTicket the new Ticket to be added.
	 */
	public void addNewTicket(Ticket newTicket) {
		tickets.add(newTicket);
		System.out.println("You have added a new ticket");
	}

	/**
	 * Removes a particular ticket from tickets
	 * Sets the occupied seat back to empty
	 * 
	 * @param ticketIndex the index from the array list.
	 */
	public void removeTicket(int ticketIndex) {
		if (tickets != null && ticketIndex < tickets.size()) {
			Ticket toRemove = tickets.get(ticketIndex);
			tickets.remove(toRemove);
			// Seat seatToRemove = toRemove.getSeatBooked();
			// seatToRemove.setEmpty(); // this should be in UI, not in this.
		}
	}
	/**
	 * Gets an ArrayList of Ticket. 
	 * @return this TicketManager's 
	 */
	public ArrayList<Ticket> getTickets() {
		return this.tickets;
	}

}
