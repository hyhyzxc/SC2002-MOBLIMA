package moblima.Entity;

/**
 * Represents an instance of a ticket in the customer's "Shopping Cart"
 */
public class Ticket {
	private CustomerAccount booker;
	private Session sessionBooked;
	private Cineplex cineplexBooked;
	private Seat seatBooked;
	private Status status;

	public Ticket(CustomerAccount booker, Session sessionBooked, Cineplex cineplexBooked, Seat seatBooked,
			Status status) {
		this.booker = booker;
		this.sessionBooked = sessionBooked;
		this.cineplexBooked = cineplexBooked;
		this.seatBooked = seatBooked;
		this.status = status; // affects the price: Child, Adult, Senior Citizen
	}

	public CustomerAccount getBooker() {
		return this.booker;
	}

	public Session getSessionBooked() {
		return sessionBooked;
	}

	public Cineplex getCineplexBooked() {
		return cineplexBooked;
	}

	public Seat getSeatBooked() {
		return seatBooked;
	}

	public SeatType getSeatType() {
		return seatBooked.getSeatType();
	}

	public Status getStatus() {
		return this.status;
	}
}
