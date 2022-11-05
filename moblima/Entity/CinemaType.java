package moblima.Entity;

public enum CinemaType {
    REGULAR("Regular"),
    PLATINUM_MOVIE_SUITES("Platinum");

    private String name;

    CinemaType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
