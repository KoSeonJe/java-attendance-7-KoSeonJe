package attendance.repository;

import attendance.domain.WorkerHistory;
import java.util.ArrayList;
import java.util.List;

public class WorkerHistoryRepository {

    private static final WorkerHistoryRepository INSTANCE = new WorkerHistoryRepository();

    private final List<WorkerHistory> repository = new ArrayList<>();

    private WorkerHistoryRepository() {

    }

    public static WorkerHistoryRepository getInstance() {
        return INSTANCE;
    }

    public void saveAll(List<WorkerHistory> workerHistories) {
        repository.addAll(workerHistories);
    }
}
