package attendance.service;

import static attendance.common.Month.*;

import java.util.HashMap;
import java.util.Map;

public class DayOfWeekService {

    private final Map<Integer, String> dayOfWeek12 = new HashMap<>();

    public DayOfWeekService() {
        dayOfWeek12.put(2, MONDAY.getDescription());
        dayOfWeek12.put(3, TUESDAY.getDescription());
        dayOfWeek12.put(4, WEDNESDAY.getDescription());
        dayOfWeek12.put(5, THURSDAY.getDescription());
        dayOfWeek12.put(6, FRIDAY.getDescription());
        dayOfWeek12.put(0, SATURDAY.getDescription());
        dayOfWeek12.put(1, SUNDAY.getDescription());
    }

    public String getDayOfWeek(int day) {
        int dayOfWeek = day % 7;
        return dayOfWeek12.get(dayOfWeek);
    }
}
