package attendance.service;

import static attendance.common.ExceptionMessage.ILLEGAL_ERROR;

import attendance.domain.CustomTime;
import camp.nextstep.edu.missionutils.DateTimes;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class DateService {

    private static final String MONTH = "월";
    private static final String DAY = "일";

    private final DayOfWeekService dayOfWeekService;

    public DateService(DayOfWeekService dayOfWeekService) {
        this.dayOfWeekService = dayOfWeekService;
    }

    public CustomTime createNowDate() {
        LocalDateTime localDateTime = DateTimes.now();
        LocalDate localDate = LocalDate.from(localDateTime);
        String month = parseToString(localDate.getMonth().getValue());
        String day = parseToString(localDate.getDayOfMonth());
        String dayOfWeek = dayOfWeekService.getDayOfWeek(Integer.parseInt(day));
        return new CustomTime(month, day, dayOfWeek, 0, 0);
    }

    public int getHour(String time) {
        int hour = Integer.parseInt(time.split(":")[0]);
        if (hour < 0 || hour > 24) {
            throw new IllegalArgumentException(ILLEGAL_ERROR);
        }
        return hour;
    }

    public int getMinute(String time) {
        int minute = Integer.parseInt(time.split(":")[1]);
        if (minute < 0 || minute > 59) {
            throw new IllegalArgumentException(ILLEGAL_ERROR);
        }
        return minute;
    }

    private String parseToString(int value) {
        if (value < 10) {
            return "0" + value;
        }
        return String.valueOf(value);
    }
}
