package attendance.common;

public enum Month {

    MONDAY("월요일"),
    TUESDAY("화요일"),
    WEDNESDAY("수요일"),
    THURSDAY("목요일"),
    FRIDAY("금요일");

    private String description;

    Month(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
