package attendance.service;

import attendance.domain.WorkerHistory;
import attendance.domain.AttendanceStatus;
import attendance.domain.CustomTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class WorkerHistoryParser {

    private final AttendanceService attenDanceService;
    private final DayOfWeekService dayOfWeekService;

    public WorkerHistoryParser(AttendanceService attenDanceService, DayOfWeekService dayOfWeekService) {
        this.attenDanceService = attenDanceService;
        this.dayOfWeekService = dayOfWeekService;
    }

    public List<WorkerHistory> toWorkers(List<String> attendances) {
        List<WorkerHistory> workerHistories = new ArrayList<>();
        for (String attendance : attendances) {
            String[] nickDate = attendance.split(",");
            String nickName = nickDate[0];
            String rawDateTime = nickDate[1];

            String[] dateTime = rawDateTime.split(" ");
            String rawDate = dateTime[0];

            String[] date = rawDate.split("-");
            String month = date[1];
            String day = date[2];
            String dayOfWeek = dayOfWeekService.getDayOfWeek(Integer.parseInt(day));

            if (Objects.equals(dateTime[1], "null")) {
                CustomTime customTime = new CustomTime(month, day, dayOfWeek);
                workerHistories.add(new WorkerHistory(nickName, customTime, AttendanceStatus.ABSENCE));
                continue;
            }
            String rawTime = dateTime[1];
            String[] time = rawTime.split(":");
            int hour = Integer.parseInt(time[0]);
            int minute = Integer.parseInt(time[1]);

            AttendanceStatus attendanceStatus = attenDanceService.judge(dayOfWeek, hour, minute);
            CustomTime customTime = new CustomTime(month, day, dayOfWeek, hour, minute);

            workerHistories.add(new WorkerHistory(nickName, customTime, attendanceStatus));
        }
        return workerHistories;
    }
}
