package attendance.view;

import attendance.domain.CustomTime;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String SELECTION = """
        1. 출석 확인
        2. 출석 수정
        3. 크루별 출석 기록 확인
        4. 제적 위험자 확인
        Q. 종료""";
    private static final String NOW_TIME_SELECT_MESSAGE = "오늘은 %s월 %s일 %s입니다. 기능을 선택해 주세요.";
    private static final String LINE_BREAKER = System.lineSeparator();
    private static final String INPUT_CREATE_NICKNAME = "닉네임을 입력해 주세요.";
    private static final String INPUT_CREATE_DATETIME = "등교 시간을 입력해 주세요.";
    private static final String INPUT_UPDATE_NICKNAME = "출석을 수정하려는 크루의 닉네임을 입력해 주세요.";
    private static final String INPUT_UPDATE_DAY = "수정하려는 날짜(일)를 입력해 주세요.";
    private static final String INPUT_UPDATE_TIME = "언제로 변경하겠습니까?";

    public String selectAction(CustomTime nowTime) {
        System.out.printf(NOW_TIME_SELECT_MESSAGE + LINE_BREAKER, nowTime.getMonth(), nowTime.getDay(),
            nowTime.getDayOfWeek());
        println(SELECTION);
        return Console.readLine();
    }

    public String inputCreateNickName() {
        println(INPUT_CREATE_NICKNAME);
        return Console.readLine();
    }

    private void println(String message) {
        System.out.println(message);
    }

    public String inputCreateDateTime() {
        println(INPUT_CREATE_DATETIME);
        return Console.readLine();
    }

    public String inputUpdateNickName() {
        println(INPUT_UPDATE_NICKNAME);
        return Console.readLine();
    }

    public String inputUpdateDay() {
        println(INPUT_UPDATE_DAY);
        return Console.readLine();
    }

    public String inputUpdateTime() {
        println(INPUT_UPDATE_TIME);
        return Console.readLine();
    }

    public String inputGetNickName() {
        println(INPUT_CREATE_NICKNAME);
        return Console.readLine();
    }
}
