package attendance.view;

import attendance.domain.CustomTime;
import attendance.domain.WorkerHistory;

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
}
