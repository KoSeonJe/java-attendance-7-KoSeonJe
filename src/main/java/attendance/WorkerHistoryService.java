package attendance;

import attendance.domain.AttendanceStatus;
import attendance.domain.CustomTime;
import attendance.domain.WorkerHistory;
import attendance.repository.WorkerHistoryRepository;
import attendance.service.AttendanceService;
import attendance.service.DateService;

public class WorkerHistoryService {

    private final AttendanceService attendanceService;
    private final DateService dateService;
    private final WorkerHistoryRepository workerHistoryRepository;

    public WorkerHistoryService(AttendanceService attendanceService, DateService dateService,
        WorkerHistoryRepository workerHistoryRepository) {
        this.attendanceService = attendanceService;
        this.dateService = dateService;
        this.workerHistoryRepository = workerHistoryRepository;
    }

    public WorkerHistory createWorkHistory(String nickName, CustomTime customTime, String time) {
        int hour = dateService.getHour(time);
        int minute = dateService.getMinute(time);
        customTime.updateTime(hour, minute);
        AttendanceStatus attendanceStatus = attendanceService.judge(customTime.getDayOfWeek(), hour, minute);
        WorkerHistory workerHistory = WorkerHistory.create(nickName, customTime, attendanceStatus);
        workerHistoryRepository.save(workerHistory);
        return workerHistory;
    }
}
