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
     * The arrayList of Session class that displays the available sessions in a
     * Cineplex.
     */
    private ArrayList<Session> availableSessions;
    static Random r = new Random();

    /**
     * Creates a new Cineplex with the given location.
     * 
     * @param location This Cineplex's location.
     */
    public Cineplex(String location) {
        this.location = location;
        this.theatres = new ArrayList<Cinema>();
        Cinema c1 = new RegularCinema("REG", 2.0);
        Cinema c2 = new GoldClassCinema("GCC", 4.0);
        Cinema c3 = new PlatinumMovieSuites("PMS", 6.0);
        theatres.add(c1);
        theatres.add(c2);
        theatres.add(c3);
        this.availableSessions = new ArrayList<Session>();
    }

    /**
     * Accessor method that gets this Cineplex's location.
     * 
     * @return This Cineplex's location.
     */
    public String getLocation() {
        return location;
    }

    /**
     * Accessor method that gets this Cineplex's cinemas in an ArrayList.
     * 
     * @return This Cineplex's cinemas in an ArrayList.
     */

    public ArrayList<Cinema> getTheatres() {
        return theatres;
    }

    /**
     * Accessor method that gets this Cineplex's sessions in an ArrayList.
     * 
     * @return This Cineplex's available sessions in an ArrayList.
     */

    public ArrayList<Session> getAvailableSessions() {
        return availableSessions;
    }

    /**
     * Method to add a new available session into this Cineplex's ArrayList of
     * sessions.
     * 
     * @param session This Cinexplex's new instance of available session.
     */
    public void addSession(Session session) {
        availableSessions.add(session);
    }

    /**
     * Method to delete all the sessions available in the cineplex by Movie Name.
     * This
     * is used when a movie is removed, so it implies that the session must be
     * deleted too.
     * 
     * @param movieName The name of the movie that is linked to any sessions in the
     *                  cineplex
     */
    public void deleteAllSessionsByMovieName(String movieName) {
        for (int i = 0; i < availableSessions.size(); i++) {
            System.out.println("thsi is: " + availableSessions.get(i).getMovie().getTitle());
            if (availableSessions.get(i).getMovie().getTitle() == "to rm") {
                System.out.println("moviename in deleteallsessions" + movieName);
                availableSessions.remove(i);
            }
        }
    }

    /**
     * Method to remove a particular session from a currently avaiable list of
     * sessions of a cineplex. Used when staff configures the listings.
     * 
     * @param session an instance of the class Session.
     */
    public void deleteSession(Session session) {
        try {
            availableSessions.remove(session);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
