package attendance.domain;

public class CustomTime {

    private String month;
    private String day;
    private String dayOfWeek;
    private Integer hour;
    private Integer minute;

    public CustomTime(String month, String day, String dayOfWeek) {
        this.month = month;
        this.day = day;
        this.dayOfWeek = dayOfWeek;
    }

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

    public Integer getHour() {
        return hour;
    }

    public Integer getMinute() {
        return minute;
    }

    public void updateTime(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
    }
}
