package attendance.common;

import attendance.AttendanceRecorder;
import attendance.service.WorkerHistoryService;
import attendance.service.DateService;
import attendance.infra.FileLoader;
import attendance.repository.WorkerHistoryRepository;
import attendance.service.AttendanceService;
import attendance.service.DayOfWeekService;
import attendance.service.WorkerHistoryParser;
import attendance.view.ApplicationView;
import attendance.view.InputView;
import attendance.view.OutputView;

public class AttendanceConfig {

    public DataInitializer dataInitializer() {
        return new DataInitializer(new FileLoader(), workerHistoryRepository(), workerParser());
    }

    public AttendanceRecorder attendanceRecorder() {
        return new AttendanceRecorder(applicationView(), dateService(), workerHistoryService(), attendanceService());
    }

    private WorkerHistoryRepository workerHistoryRepository() {
        return WorkerHistoryRepository.getInstance();
    }

    private WorkerHistoryParser workerParser() {
        return new WorkerHistoryParser(attendanceService(), dayOfWeekService());
    }

    private AttendanceService attendanceService() {
        return new AttendanceService();
    }

    private DayOfWeekService dayOfWeekService() {
        return new DayOfWeekService();
    }

    private ApplicationView applicationView() {
        return new ApplicationView(new InputView(), new OutputView());
    }

    private DateService dateService() {
        return new DateService(dayOfWeekService());
    }

    private WorkerHistoryService workerHistoryService() {
        return new WorkerHistoryService(attendanceService(), dateService(), workerHistoryRepository());
    }
}
