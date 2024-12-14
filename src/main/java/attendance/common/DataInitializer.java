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
        List<String> attendance = fileLoader.loadFile(fileName);
        List<WorkerHistory> workerHistories = workerHistoryParser.toWorkers(attendance);
        workerHistoryRepository.saveAll(workerHistories);
    }
}
