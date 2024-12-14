package attendance.view;

import attendance.domain.CustomTime;

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
}
