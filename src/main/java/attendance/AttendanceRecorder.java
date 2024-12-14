package attendance;

import static attendance.common.ExceptionMessage.ILLEGAL_ERROR;

import attendance.common.ActionConstant;
import attendance.domain.CustomTime;
import attendance.domain.WorkerHistory;
import attendance.service.DateService;
import attendance.service.WorkerHistoryService;
import attendance.view.ApplicationView;
import java.util.Objects;

public class AttendanceRecorder {

    private final ApplicationView applicationView;
    private final DateService dateService;
    private final WorkerHistoryService workerHistoryService;

    public AttendanceRecorder(ApplicationView applicationView, DateService dateService,
        WorkerHistoryService workerHistoryService) {
        this.applicationView = applicationView;
        this.dateService = dateService;
        this.workerHistoryService = workerHistoryService;
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

            if (Objects.equals(selectNumber, ActionConstant.WEEDING_NUMBER)) {
                continue;
            }

            if (Objects.equals(selectNumber, ActionConstant.EXIT_NUMBER)) {
                return;
            }

            throw new IllegalArgumentException(ILLEGAL_ERROR);
        }
    }

    private void updateAttendance(CustomTime customTime) {

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
