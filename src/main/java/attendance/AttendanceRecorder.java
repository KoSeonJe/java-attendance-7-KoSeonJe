package attendance;

import attendance.domain.CustomTime;
import attendance.view.ApplicationView;

public class AttendanceRecorder {

    private final ApplicationView applicationView;
    private final DateService dateService;

    public AttendanceRecorder(ApplicationView applicationView, DateService dateService) {
        this.applicationView = applicationView;
        this.dateService = dateService;
    }

    public void execute() {
        CustomTime customTime = dateService.createNowDate();
        String selectNumber = selectAction(customTime);
    }

    private String selectAction(CustomTime customTime) {
        return applicationView.selectAction(customTime);
    }
}
