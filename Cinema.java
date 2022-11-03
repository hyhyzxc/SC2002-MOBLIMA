import java.util.*;

public abstract class Cinema {
    private int cinemaID;
    private ArrayList<Seat> seats;
    private CinemaType cinemaType;

    public Cinema(int cinemaID, ArrayList<Seat> seats, CinemaType cinemaType) {
        this.cinemaID = cinemaID;
        this.seats = seats;
        this.cinemaType = cinemaType;
    }

    public int getCinemaID() {
        return cinemaID;
    }

    public ArrayList<Seat> getSeats() {
        return seats;
    }

    public CinemaType getCinemaType() {
        return cinemaType;
    }
}
