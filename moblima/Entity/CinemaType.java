package moblima.Entity;

public enum CinemaType {
    REGULAR("Regular"),
    PLATINUM_MOVIE_SUITES("Platinum"),
    GOLD_CLASS("Gold Class");

    private String name;

    CinemaType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
