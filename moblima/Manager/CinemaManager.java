package moblima.Manager;

import java.util.*;
import moblima.Entity.*;
import moblima.Exceptions.*;
import moblima.Serializer.*;

public class CinemaManager {
    private ArrayList<Cineplex> cineplexList;
    static CinemaSerializer s = new CinemaSerializer();

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

    public ArrayList<Cineplex> getCineplexList() {
        return cineplexList;
    }

    public void addSessionToCineplex(Session session, int cineplexIndex) {
        Cineplex cineplex = cineplexList.get(cineplexIndex);
        cineplex.addSession(session);
        s.saveCineplexStatus(cineplexList, "CineplexDatabase.ser");
        System.out.println("Session added to Cineplex.");
    }

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

    public void unreserveSeat(Seat seat) {
        seat.setEmpty();
        s.saveCineplexStatus(cineplexList, "CineplexDatabase.ser");
    }

    public void reserveSeat(Seat seat) {
        seat.setOccupied();
        s.saveCineplexStatus(cineplexList, "CineplexDatabase.ser");
    }
}
