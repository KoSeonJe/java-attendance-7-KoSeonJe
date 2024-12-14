package attendance;

import attendance.domain.CustomTime;
import attendance.service.DayOfWeekService;
import camp.nextstep.edu.missionutils.DateTimes;
import java.time.LocalDate;
import java.time.LocalDateTime;
import net.bytebuddy.asm.Advice.Local;

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

    private String parseToString(int value) {
        if (value < 10) {
            return "0" + value;
        }
        return String.valueOf(value);
    }
}
