package moblima.Entity;

/**
 * Represents the Showing Status of a Movie.
 * Enum class.
 * @author Yap Shen Hwei
 * @version 1.0
 * @since 2022-11-13
 */
public enum ShowingStatus {
    COMING_SOON("Coming Soon"),
    PREVIEW("Preview"),
    NOW_SHOWING("Now Showing"),
    END_OF_SHOWING("End of Showing");

	/**
	 * The text associated with each Showing Status.
	 */
    private final String text;
    
    /**
     * Creates ShowingStatus with associated text.
     * @param text This ShowingStatus' text.
     */
    private ShowingStatus(String text) {
        this.text = text;
    }

    /**
     * Gets this ShowingStatus' text.
     */
    public String toString() {
        return text;
    }
}
