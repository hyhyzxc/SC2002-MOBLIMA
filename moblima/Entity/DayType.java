package moblima.Entity;

/**
 * Represent a DayType.
 * Enum class.
 */
public enum DayType {

    WEEKDAY("Weekday"),
    WEEKEND("Weekend"),
    PUBLIC_HOLIDAY("Public Holiday");
    /**
     * The name of  this DayType. 
     */
    private String name;
    /**
     * Creates a DayType with the given name.
     * @param name This DayType's name. 
     */
    DayType(String name) {
        this.name = name;
    }
    /**
     * Gets the name of this DayType.
     * @return this DayType's name. 
     */
    public String getName() {
        return name;
    }
}