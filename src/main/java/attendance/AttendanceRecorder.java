package attendance;

import static attendance.common.ExceptionMessage.ILLEGAL_ERROR;

import attendance.common.ActionConstant;
import attendance.domain.CustomTime;
import attendance.domain.WorkerHistory;
import attendance.service.AttendanceService;
import attendance.service.DateService;
import attendance.service.WorkerHistoryService;
import attendance.view.ApplicationView;
import java.util.List;
import java.util.Objects;

public class AttendanceRecorder {

    private final ApplicationView applicationView;
    private final DateService dateService;
    private final WorkerHistoryService workerHistoryService;
    private final AttendanceService attendanceService;

    public AttendanceRecorder(ApplicationView applicationView, DateService dateService,
        WorkerHistoryService workerHistoryService, AttendanceService attendanceService) {
        this.applicationView = applicationView;
        this.dateService = dateService;
        this.workerHistoryService = workerHistoryService;
        this.attendanceService = attendanceService;
    }

    public void execute() {
        while (true) {
            CustomTime customTime = dateService.createNowDate();
            String selectNumber = selectAction(customTime);

            if (Objects.equals(selectNumber, ActionConstant.CREATE_NUMBER)) {
                createAttendance(customTime);
                continue;
            }

            if (Objects.equals(selectNumber, ActionConstant.UPDATE_NUMBER)) {
                updateAttendance(customTime);
                continue;
            }

            if (Objects.equals(selectNumber, ActionConstant.GET_NUMBER)) {
                getCrewAttendance();
                continue;
            }

            if (Objects.equals(selectNumber, ActionConstant.WEEDING_NUMBER)) {
                continue;
            }

            if (Objects.equals(selectNumber, ActionConstant.EXIT_NUMBER)) {
                return;
            }

            throw new IllegalArgumentException(ILLEGAL_ERROR);
        }
    }

    private void getCrewAttendance() {
        String nickName = applicationView.inputGetNickName();
        List<WorkerHistory> workerHistories = workerHistoryService.findByNickName(nickName);
        List<Integer> attendanceResult = attendanceService.getAttendanceResult(workerHistories);
        applicationView.printWorkerHistories(attendanceResult, workerHistories);
    }

    private void updateAttendance(CustomTime customTime) {
        String nickName = applicationView.inputUpdateNickName();
        int day = applicationView.inputUpdateDay();
        String time = applicationView.inputUpdateTime();
        WorkerHistory last = workerHistoryService.findByNameAndDay(nickName, day);
        WorkerHistory update = workerHistoryService.update(last, time);
        applicationView.printUpdateResult(last, update);
    }

    private void createAttendance(CustomTime customTime) {
        String nickName = applicationView.inputCreateNickName();
        String time = applicationView.inputCreateDateTime();
        WorkerHistory workerHistory = workerHistoryService.createWorkHistory(nickName, customTime, time);
        applicationView.printCreateResult(workerHistory);
    }

    private String selectAction(CustomTime customTime) {
        return applicationView.selectAction(customTime);
    }
}
