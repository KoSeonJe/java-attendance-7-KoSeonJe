package attendance.domain;

public class CustomTime {

    private String month;
    private String day;
    private String dayOfWeek;
    private int hour;
    private int minute;

    public CustomTime(String month, String day, String dayOfWeek, int hour, int minute) {
        this.month = month;
        this.day = day;
        this.dayOfWeek = dayOfWeek;
        this.hour = hour;
        this.minute = minute;
    }

    public String getMonth() {
        return month;
    }

    public String getDay() {
        return day;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public void updateTime(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
    }
}
