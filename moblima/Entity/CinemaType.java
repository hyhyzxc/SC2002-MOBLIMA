package moblima.Entity;

/**
 * Represents a CinemaType
 * Enum class.
 * @author Darren Lee
 * @version 1.0
 * @since 2022-11-13
 */
public enum CinemaType {
    REGULAR("Regular"),
    PLATINUM_MOVIE_SUITES("Platinum"),
    GOLD_CLASS("Gold Class");

    /**
     * This CinemaType's name.
     */
    private String name;

    /**
     * Creates a new CinemaType with given name. 
     * @param name This CinemaType's name.
     */
    CinemaType(String name) {
        this.name = name;
    }
    /**
     * Gets the name of this CinemaType. 
     * @return this CinemaType's name.
     */
    public String getName() {
        return name;
    }

}
