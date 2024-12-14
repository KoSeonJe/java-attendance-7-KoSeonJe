package attendance.service;

import static attendance.common.ExceptionMessage.NOT_EXIST_NICKNAME;

import attendance.domain.AttendanceStatus;
import attendance.domain.CustomTime;
import attendance.domain.WorkerHistory;
import attendance.repository.WorkerHistoryRepository;
import java.util.List;

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

    public WorkerHistory findByNameAndDay(String nickName, int day) {
        WorkerHistory workerHistory = workerHistoryRepository.findByNameAndDay(nickName, day);
        if (workerHistory == null) {
            throw new IllegalArgumentException(NOT_EXIST_NICKNAME);
        }
        return workerHistory;
    }
    public WorkerHistory update(WorkerHistory last, String time) {
        int hour = dateService.getHour(time);
        int minute = dateService.getMinute(time);
        CustomTime lastTime = last.getCustomTime();
        CustomTime updateTime = new CustomTime(lastTime.getMonth(), lastTime.getDay(), lastTime.getDayOfWeek(), hour,
            minute);
        AttendanceStatus attendanceStatus = attendanceService.judge(lastTime.getDayOfWeek(), hour, minute);
        WorkerHistory update = WorkerHistory.create(last.getName(), updateTime, attendanceStatus);
        workerHistoryRepository.save(update);
        workerHistoryRepository.remove(last);
        return update;
    }

    public List<WorkerHistory> findByNickName(String nickName) {
        validateNickName(nickName);
        return workerHistoryRepository.findByName(nickName);
    }

    private void validateNickName(String nickName) {
        if (workerHistoryRepository.isEmpty(nickName)) {
            throw new IllegalArgumentException(NOT_EXIST_NICKNAME);
        }
    }

}
