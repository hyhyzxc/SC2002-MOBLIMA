package moblima.Entity;

import java.io.Serializable;
import java.util.*;

public class Cineplex implements Serializable {
    private String location;
    private ArrayList<Cinema> theatres;
    private ArrayList<Session> availableSessions;
    static Random r = new Random();

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

    public String getLocation() {
        return location;
    }

    public ArrayList<Cinema> getTheatres() {
        return theatres;
    }

    public ArrayList<Session> getAvailableSessions() {
        return availableSessions;
    }

    public void addSession(Session session) {
        availableSessions.add(session);
    }
}
