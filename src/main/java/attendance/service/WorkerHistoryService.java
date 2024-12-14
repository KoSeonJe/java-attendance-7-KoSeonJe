package attendance.service;

import static attendance.common.ExceptionMessage.NOT_EXIST_NICKNAME;

import attendance.domain.AttendanceStatus;
import attendance.domain.CustomTime;
import attendance.domain.WorkerHistory;
import attendance.repository.WorkerHistoryRepository;

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
        validateNickName(nickName);
        workerHistoryRepository.save(workerHistory);
        return workerHistory;
    }

    private void validateNickName(String nickName) {
        if (workerHistoryRepository.isEmpty(nickName)) {
            throw new IllegalArgumentException(NOT_EXIST_NICKNAME);
        }
    }
}