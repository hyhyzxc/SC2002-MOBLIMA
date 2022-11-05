package moblima.Entity;

public enum SeatType {
    NORMAL("Normal"),
    ELITE("Elite"),
    ULTIMA("Ultima");

    private String name;

    SeatType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
