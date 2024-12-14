package attendance.common;

import attendance.infra.FileLoader;
import attendance.repository.WorkerHistoryRepository;
import attendance.service.AttendanceService;
import attendance.service.DayOfWeekService;
import attendance.service.WorkerHistoryParser;

public class AttendanceConfig {

    public DataInitializer dataInitializer() {
        return new DataInitializer(new FileLoader(), workerHistoryRepository(), workerParser());
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
}
