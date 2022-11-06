package moblima.Entity;

public enum DayType {

    WEEKDAY("Weekday"),
    WEEEKEND("Weekend"),
    PUBLIC_HOLIDAY("Public Holiday");

    private String name;

    DayType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}