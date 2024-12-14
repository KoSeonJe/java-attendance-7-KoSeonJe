package attendance.view;

import attendance.domain.CustomTime;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String SELECTION = """
        1. 출석 확인
        2. 출석 수정
        3. 크루별 출석 기록 확인
        4. 제적 위험자 확인
        Q. 종료
        """;
    private static final String NOW_TIME_SELECT_MESSAGE = "오늘은 %s월 %s일 %s입니다. 기능을 선택해 주세요.";
    private static final String LINE_BREAKER = System.lineSeparator();



    public String selectAction(CustomTime nowTime) {
        System.out.printf(NOW_TIME_SELECT_MESSAGE + LINE_BREAKER, nowTime.getMonth(), nowTime.getDay(),
            nowTime.getDayOfWeek());
        println(SELECTION);
        return Console.readLine();
    }

    private void println(String message) {
        System.out.println(message);
    }
}
