package moblima.Entity;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Session implements Serializable {
    private Movie movie;
    private LocalDateTime sessionDateTimeStart;
    private LocalDateTime sessionDateTimeEnd;
    private DayType day;
    private static final long serialVersionUID = 4190978198976273755L;

    public Session(Movie movie, LocalDateTime sessionDateTimeStart, LocalDateTime sessionDateTimeEnd, DayType day) {
        this.movie = movie;
        this.sessionDateTimeStart = sessionDateTimeStart;
        this.sessionDateTimeEnd = sessionDateTimeEnd;
        this.day = day;
    }

    public Movie getMovie() {
        return movie;
    }

    public LocalDateTime getSessionDateTimeStart() {
        return sessionDateTimeStart;
    }

    public LocalDateTime getSessionDateTimeEnd() {
        return sessionDateTimeEnd;
    }

    public DayType getDay() {
        return day;
    }
}
