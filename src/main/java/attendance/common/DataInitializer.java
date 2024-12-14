package attendance.common;

import attendance.infra.FileLoader;
import attendance.domain.WorkerHistory;
import attendance.repository.WorkerHistoryRepository;
import attendance.service.WorkerHistoryParser;
import java.util.List;

public class DataInitializer {

    private static final String fileName = "attendances.csv";

    private final FileLoader fileLoader;
    private final WorkerHistoryRepository workerHistoryRepository;
    private final WorkerHistoryParser workerHistoryParser;

    public DataInitializer(FileLoader fileLoader, WorkerHistoryRepository workerHistoryRepository,
        WorkerHistoryParser workerHistoryParser) {
        this.fileLoader = fileLoader;
        this.workerHistoryRepository = workerHistoryRepository;
        this.workerHistoryParser = workerHistoryParser;
    }

    public void initWorkHistory() {
        workerHistoryRepository.clear();
        List<String> attendance = fileLoader.loadFile(fileName);
        addNoAttendance(attendance);
        List<WorkerHistory> workerHistories = workerHistoryParser.toWorkers(attendance);
        workerHistoryRepository.saveAll(workerHistories);
    }

    private void addNoAttendance(List<String> attendance) {
        attendance.add("짱수,2024-12-11 null");
        attendance.add("이든,2024-12-05 null");
        attendance.add("쿠키,2024-12-06 null");
        attendance.add("빙티,2024-12-09 null");
        attendance.add("이든,2024-12-11 null");
        attendance.add("빙티,2024-12-11 null");
        attendance.add("쿠키,2024-12-12 null");
        attendance.add("빙티,2024-12-12 null");
        attendance.add("짱수,2024-12-13 null");
    }
}
