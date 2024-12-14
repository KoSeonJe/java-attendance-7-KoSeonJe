package attendance.view;

import attendance.domain.CustomTime;
import attendance.domain.WorkerHistory;
import java.util.List;

public class ApplicationView {

    private final InputView inputView;
    private final OutputView outputView;

    public ApplicationView(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public String selectAction(CustomTime nowTime) {
        return inputView.selectAction(nowTime);
    }

    public String inputCreateNickName() {
        return inputView.inputCreateNickName();
    }

    public String inputCreateDateTime() {
        return inputView.inputCreateDateTime();
    }

    public void printCreateResult(WorkerHistory workerHistory) {
        outputView.createCrateResult(workerHistory);
    }

    public String inputUpdateNickName() {
        return inputView.inputUpdateNickName();
    }

    public int inputUpdateDay() {
        return Integer.parseInt(inputView.inputUpdateDay());
    }

    public String inputUpdateTime() {
        return inputView.inputUpdateTime();
    }

    public void printUpdateResult(WorkerHistory last, WorkerHistory update) {
        outputView.printUpdateResult(last, update);
    }

    public String inputGetNickName() {
        return inputView.inputGetNickName();
    }

    public void printWorkerHistories(List<Integer> attendanceResult, List<WorkerHistory> workerHistories) {
        outputView.printWorkerHistories(attendanceResult, workerHistories);
    }
}
