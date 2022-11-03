public enum ShowingStatus {
    COMING_SOON("Coming Soon"),
    PREVIEW("Preview"),
    NOW_SHOWING("Now Showing"),
    END_OF_SHOWING("End of Showing");

    private final String text;

    private ShowingStatus(String text) {
        this.text = text;
    }

    public String toString() {
        return text;
    }
}
