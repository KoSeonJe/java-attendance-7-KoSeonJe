package attendance.service;

import static attendance.domain.AttendanceStatus.*;

import attendance.common.Month;
import attendance.domain.AttendanceStatus;
import attendance.domain.WorkerHistory;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AttendanceService {

    private static final int MONDAY_ATTENDANCE_HOUR = 13;
    private static final int REST_ATTENDANCE_HOUR = 10;
    private static final int PERCEPTION_HOUR = 5;
    private static final int ABSENCE_HOUR = 30;

    public AttendanceStatus judge(String dayOfWeek, int hour, int minute) {
        if (Objects.equals(dayOfWeek, Month.MONDAY.getDescription())) {
            if (hour > MONDAY_ATTENDANCE_HOUR) {
                return ABSENCE;
            }

            if (hour == MONDAY_ATTENDANCE_HOUR) {
                return judgeMinute(minute);
            }
            return ATTENDANCE;
        }

        if (hour > REST_ATTENDANCE_HOUR) {
            return ABSENCE;
        }

        if (hour == REST_ATTENDANCE_HOUR) {
            return judgeMinute(minute);
        }
        return ATTENDANCE;
    }

    private AttendanceStatus judgeMinute(int minute) {
        if (minute > PERCEPTION_HOUR && minute <= ABSENCE_HOUR) {
            return PERCEPTION;
        }

        if (minute > ABSENCE_HOUR) {
            return ABSENCE;
        }

        return ATTENDANCE;
    }

    public List<Integer> getAttendanceResult(List<WorkerHistory> workerHistories) {
        int attendance = 0;
        int perception = 0;
        int absence = 0;

        for (WorkerHistory workerHistory : workerHistories) {
            if (workerHistory.getAttendanceStatus() == ATTENDANCE) {
                attendance++;
            }
            if (workerHistory.getAttendanceStatus() == PERCEPTION) {
                perception++;
            }
            if (workerHistory.getAttendanceStatus() == ABSENCE) {
                absence++;
            }
        }
        return new ArrayList<>(List.of(attendance, perception, absence));
    }
}
