package moblima.Entity;

import java.io.Serializable;
import java.util.*;

/**
 * Represents a Cineplex
 * Concrete base class that implements the Serializable interface.
 */
public class Cineplex implements Serializable {
    /**
     * The location of this Cineplex
     */
    private String location;
    /**
     * The arrayList of Cinema class that represents a Cineplex. 
     */
    private ArrayList<Cinema> theatres;
    /**
     * The arrayList of Session class that displays the available sessions in a Cineplex.
     */
    private ArrayList<Session> availableSessions;
    static Random r = new Random();

    /**
     * Creates a new Cineplex with the given location.
     * @param location This Cineplex's location.
     */
    public Cineplex(String location) {
        this.location = location;
        this.theatres = new ArrayList<Cinema>();
        Cinema c1 = new Cinema("REG", 2.0, CinemaType.REGULAR);
        Cinema c2 = new Cinema("GCC", 4.0, CinemaType.GOLD_CLASS);
        Cinema c3 = new Cinema("PMS", 6.0, CinemaType.PLATINUM_MOVIE_SUITES);
        theatres.add(c1);
        theatres.add(c2);
        theatres.add(c3);
        this.availableSessions = new ArrayList<Session>();
    }

    /**
     * Accessor method that gets this Cineplex's location.
     * @return This Cineplex's location.
     */
    public String getLocation() {
        return location;
    }

    /**
     * Accessor method that gets this Cineplex's cinemas in an ArrayList.
     * @return This Cineplex's cinemas in an ArrayList. 
     */

    public ArrayList<Cinema> getTheatres() {
        return theatres;
    }

    /**
     * Accessor method that gets this Cineplex's sessions in an ArrayList.
     * @return This Cineplex's available sessions in an ArrayList.
     */

    public ArrayList<Session> getAvailableSessions() {
        return availableSessions;
    }
    /**
     * Method to add a new available session into this Cineplex's ArrayList of sessions. 
     * @param session This Cinexplex's new instance of available session. 
     */
    public void addSession(Session session) {
        availableSessions.add(session);
    }
}
