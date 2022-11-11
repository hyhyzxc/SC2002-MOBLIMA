package moblima.Manager;

import java.util.*;
import moblima.Entity.*;
import moblima.Exceptions.*;
import moblima.Serializer.*;

/**
 * Represents a CinemaManager.
 * 
 * @author
 * @version 1.0
 * @since 2022-11-08
 */
public class CinemaManager {
    /**
     * This CinemaManager's cineplexList.
     */
    private ArrayList<Cineplex> cineplexList;
    static CinemaSerializer s = new CinemaSerializer();

    /**
     * Creates a new CinemaManager.
     * If cineplexList does not exist, create a cineplexList.
     * CineplexList consist of 3 cineplexe stored in an Arraylist.
     */
    public CinemaManager() {
        cineplexList = s.getCineplexStatus("CineplexDatabase.ser");
        if (cineplexList == null) {
            cineplexList = new ArrayList<Cineplex>();
            Cineplex newCine1 = new Cineplex("Jurong");
            Cineplex newCine2 = new Cineplex("Serangoon");
            Cineplex newCine3 = new Cineplex("Bugis");
            cineplexList.add(newCine1);
            cineplexList.add(newCine2);
            cineplexList.add(newCine3);
        }
    }

    /**
     * Gets an ArrayList of Cineplex.
     * 
     * @return this CinemaManager's cineplexList.
     */
    public ArrayList<Cineplex> getCineplexList() {
        return cineplexList;
    }

    /**
     * Appends a given session to a given cineplex.
     * Displays a message of a successful addition of given session to given
     * cineplex.
     * 
     * @param session       new session to be added
     * @param cineplexIndex index value of cineplex
     */
    public void addSessionToCineplex(Session session, int cineplexIndex) {
        Cineplex cineplex = cineplexList.get(cineplexIndex);
        cineplex.addSession(session);
        s.saveCineplexStatus(cineplexList, "CineplexDatabase.ser");
        System.out.println("Session added to Cineplex.");
    }

    /**
     * Gets the full ArrayList of sessions across all cineplexes.
     * 
     * @return
     */
    public ArrayList<Session> getAllSessions() {
        cineplexList = s.getCineplexStatus("CineplexDatabase.ser");
        ArrayList<Session> sessions = new ArrayList<Session>();

        for (int i = 0; i < cineplexList.size(); i++) {
            ArrayList<Session> cineSess = cineplexList.get(i).getAvailableSessions();
            for (Session j : cineSess) {
                sessions.add(j);
            }
        }
        return sessions;
    }

    /**
     * Change given seat's status to empty.
     * 
     * @param seat
     */
    public void unreserveSeat(Seat seat) {
        seat.setEmpty();
        s.saveCineplexStatus(cineplexList, "CineplexDatabase.ser");
    }

    /**
     * Change given seat's status to occupied.
     * 
     * @param seat
     */
    public void reserveSeat(Seat seat) {
        seat.setOccupied();
        s.saveCineplexStatus(cineplexList, "CineplexDatabase.ser");
    }
}
