package attendance.domain;

public class CustomTime {

    private int month;
    private int day;
    private String dayOfWeek;
    private int hour;
    private int minute;

    public CustomTime(int month, int day, String dayOfWeek, int hour, int minute) {
        this.month = month;
        this.day = day;
        this.dayOfWeek = dayOfWeek;
        this.hour = hour;
        this.minute = minute;
    }
}
