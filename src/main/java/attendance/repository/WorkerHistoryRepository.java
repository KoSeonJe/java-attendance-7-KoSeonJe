package attendance.repository;

import attendance.domain.WorkerHistory;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class WorkerHistoryRepository {

    private static final WorkerHistoryRepository INSTANCE = new WorkerHistoryRepository();

    private final List<WorkerHistory> repository = new ArrayList<>();

    private WorkerHistoryRepository() {
    }

    public static WorkerHistoryRepository getInstance() {
        return INSTANCE;
    }

    public List<WorkerHistory> findByName(String nickName) {
        return repository.stream()
            .filter(workerHistory -> Objects.equals(workerHistory.getName(), nickName))
            .toList();
    }

    public void saveAll(List<WorkerHistory> workerHistories) {
        repository.addAll(workerHistories);
    }

    public void save(WorkerHistory workerHistory) {
        repository.add(workerHistory);
    }

    public boolean isEmpty(String nickName) {
        return repository.stream()
            .filter(workerHistory -> Objects.equals(workerHistory.getName(), nickName))
            .toList()
            .isEmpty();
    }

    public WorkerHistory findByNameAndDay(String nickName, int day) {
        return repository.stream()
            .filter(workerHistory ->
                Objects.equals(workerHistory.getName(), nickName) &&
                    Integer.parseInt(workerHistory.getCustomTime().getDay()) == day
            )
            .findFirst()
            .orElse(null);
    }

    public void remove(WorkerHistory last) {
        repository.remove(last);
    }
}
