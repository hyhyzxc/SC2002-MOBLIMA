package moblima.Entity;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Represents a Session in which Movie will be showing.
 * implements Serializable.
 */
public class Session implements Serializable {
    /**
     * Movie showed in this Session.
     */
    private Movie movie;
    /**
     * This Session's start time.
     */
    private LocalDateTime sessionDateTimeStart;
    /**
     * This Session's end time.
     */
    private LocalDateTime sessionDateTimeEnd;
    /**
     * The day this Session was made on.
     */
    private String day;
    /**
     * The serialization version UID of User Class.
     */
    private static final long serialVersionUID = 4190978198976273755L;

    /**
     * Creates new Session with given movie, start and end time and day
     * 
     * @param movie                Movie showed in this Session.
     * @param sessionDateTimeStart This Session's start time.
     * @param sessionDateTimeEnd   This Session's end time.
     * @param day                  The day this Session was made on.
     */
    public Session(Movie movie, LocalDateTime sessionDateTimeStart, LocalDateTime sessionDateTimeEnd, String day) {
        this.movie = movie;
        this.sessionDateTimeStart = sessionDateTimeStart;
        this.sessionDateTimeEnd = sessionDateTimeEnd;
        this.day = day;
    }

    /**
     * Gets this Session's Movie.
     * 
     * @return this Session's Movie.
     */
    public Movie getMovie() {
        return movie;
    }

    /**
     * Gets this Session's start time.
     * 
     * @return this Session's start time.
     */
    public LocalDateTime getSessionDateTimeStart() {
        return sessionDateTimeStart;
    }

    /**
     * Gets this Session's end time.
     * 
     * @return this Session's end time.
     */
    public LocalDateTime getSessionDateTimeEnd() {
        return sessionDateTimeEnd;
    }

    /**
     * Gets this Session's day.
     * 
     * @return this Session's day.
     */
    public String getDay() {
        return day;
    }
}
