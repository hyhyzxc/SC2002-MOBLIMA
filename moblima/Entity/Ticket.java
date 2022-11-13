package moblima.Entity;

/**
 * Represents an instance of a ticket in the customer's "Shopping Cart".
 * @author Darren Lee
 * @version 1.0
 * @since 2022-11-13
 */
public class Ticket {
	/**
	 * The CustomerAccount that books this Ticket.
	 */
	private CustomerAccount booker;
	/**
	 * The Session in which this Ticket was booked.
	 */
	private Session sessionBooked;
	/**
	 * The Cineplex that this Tickets booked a movie for.
	 */
	private Cineplex cineplexBooked;
	/**
	 * The Seat booked by this Ticket.
	 */
	private Seat seatBooked;
	/**
	 * The age group this Ticket is purchased for.
	 */
	private String status;

	/**
	 * Creates a new Ticket.
	 * 
	 * @param booker         The CustomerAccount that books this Ticket.
	 * @param sessionBooked  The Session in which this Ticket was booked.
	 * @param cineplexBooked The Cineplex that this Tickets booked a movie for.
	 * @param seatBooked     The Seat booked by this Ticket.
	 * @param status         The age group this Ticket is purchased for.
	 */
	public Ticket(CustomerAccount booker, Session sessionBooked, Cineplex cineplexBooked, Seat seatBooked,
			String status) {
		this.booker = booker;
		this.sessionBooked = sessionBooked;
		this.cineplexBooked = cineplexBooked;
		this.seatBooked = seatBooked;
		this.status = status; // affects the price: Child, Adult, Senior Citizen
	}

	/**
	 * Gets the CustomerAccount that books this Ticket.
	 * 
	 * @return this Ticket's CustomerAccount.
	 */
	public CustomerAccount getBooker() {
		return this.booker;
	}

	/**
	 * Gets the Session in which this Ticket was booked.
	 * 
	 * @return this Ticket's Session.
	 */
	public Session getSessionBooked() {
		return sessionBooked;
	}

	/**
	 * Gets the Cineplex that this Tickets booked a movie for.
	 * 
	 * @return this Ticket's Cineplex.
	 */
	public Cineplex getCineplexBooked() {
		return cineplexBooked;
	}

	/**
	 * Gets the Seat booked by this Ticket.
	 * 
	 * @return this Ticket's Seat.
	 */
	public Seat getSeatBooked() {
		return seatBooked;
	}

	/**
	 * Gets the SeatType booked by this Ticket.
	 * 
	 * @return this Ticket's SeatType.
	 */
	public SeatType getSeatType() {
		return seatBooked.getSeatType();
	}

	/**
	 * Gets the age group this Ticket is purchased for.
	 * 
	 * @return this Ticket's status.
	 */
	public String getStatus() {
		return this.status;
	}
}
