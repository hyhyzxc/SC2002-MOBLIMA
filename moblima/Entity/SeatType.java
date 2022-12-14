package moblima.Entity;

/**
 * Represents the Type of each Seat.
 * Enum class.
 * @author Goh Hong Yi
 * @version 1.0
 * @since 2022-11-13
 */
public enum SeatType {
    REGULAR("Regular"),
    COUPLE("Couple"),
    ELITE("Elite"),
    ULTIMA("Ultima");
	
	/**
	 * Name of the SeatType.
	 */
    private String name;

    /**
     * Creates new SeatType with given name.
     * @param name
     */
    SeatType(String name) {
        this.name = name;
    }

    /**
     * Gets name of SeatType.
     * @return name of SeatType.
     */
    public String getName() {
        return name;
    }
}
