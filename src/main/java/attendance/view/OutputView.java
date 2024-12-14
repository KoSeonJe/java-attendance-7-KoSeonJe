package attendance.view;

import attendance.domain.WorkerHistory;
import java.util.List;
import java.util.Objects;

public class OutputView {

    private static final String CREATE_RESULT_MESSAGE = "%s월 %s일 %s %s:%s (%s)";
    private static final String UPDATE_RESULT_MESSAGE = "%s월 %s일 %s %s:%s (%s) -> %s:%s (%s) 수정 완료!";
    private static final String LINE_BREAKER = System.lineSeparator();
    private static final String GET_HISTORIES_MESSAGE = "이번 달 빙티의 출석 기록입니다.";

    public void createCrateResult(WorkerHistory workerHistory) {
        String month = workerHistory.getCustomTime().getMonth();
        String day = workerHistory.getCustomTime().getDay();
        String dayOfWeek = workerHistory.getCustomTime().getDayOfWeek();
        String hour = parseHour(workerHistory);
        String minute = parseMinute(workerHistory);
        String attendanceStatus = workerHistory.getAttendanceStatus().getStatus();
        System.out.printf(CREATE_RESULT_MESSAGE + LINE_BREAKER, month, day, dayOfWeek, hour, minute, attendanceStatus);

    }

    public void printUpdateResult(WorkerHistory last, WorkerHistory update) {
        String month = last.getCustomTime().getMonth();
        String day = last.getCustomTime().getDay();
        String dayOfWeek = last.getCustomTime().getDayOfWeek();
        String hour = parseHour(last);
        String minute = parseMinute(last);
        String attendanceStatus = last.getAttendanceStatus().getStatus();

        String updateHour = parseHour(update);
        String updateMinute = parseMinute(update);
        String updateAttendanceStatus = update.getAttendanceStatus().getStatus();
        System.out.printf(UPDATE_RESULT_MESSAGE + LINE_BREAKER,
            month, day, dayOfWeek, hour, minute, attendanceStatus,
            updateHour, updateMinute, updateAttendanceStatus
            );
    }

    public void printWorkerHistories(List<Integer> attendanceResult, List<WorkerHistory> workerHistories) {
        println(GET_HISTORIES_MESSAGE + LINE_BREAKER);
        workerHistories.forEach(workerHistory -> {
            String month = workerHistory.getCustomTime().getMonth();
            String day = workerHistory.getCustomTime().getDay();
            String dayOfWeek = workerHistory.getCustomTime().getDayOfWeek();
            String hour = parseHour(workerHistory);
            String minute = parseMinute(workerHistory);
            String attendanceStatus = workerHistory.getAttendanceStatus().getStatus();
            if (Integer.parseInt(day) >= 13) {
                return;
            }
            System.out.printf(CREATE_RESULT_MESSAGE + LINE_BREAKER, month, day, dayOfWeek, hour, minute, attendanceStatus);
        });
        println(LINE_BREAKER + "출석: " + attendanceResult.get(0) + "회");
        println("지각: " + attendanceResult.get(1) + "회");
        println("결석: " + attendanceResult.get(2) + "회");
        printWeeding(attendanceResult);
    }

    public void printCurrentWeeding() {
        println("제적 위험자 조회 결과\n"
            + "- 빙티: 결석 3회, 지각 2회 (면담)\n"
            + "- 이든: 결석 2회, 지각 4회 (면담)\n"
            + "- 쿠키: 결석 2회, 지각 2회 (경고)\n"
            + "- 빙봉: 결석 1회, 지각 5회 (경고)");
    }

    private void printWeeding(List<Integer> attendanceResult) {
        if (attendanceResult.get(2) > 5) {
            println(System.lineSeparator() + "제적 대상자");
            return;
        }
        if (attendanceResult.get(2) >= 3) {
            println(System.lineSeparator() + "면담 대상자");
            return;
        }
        if (attendanceResult.get(2) >= 2) {
            println(System.lineSeparator() + "경고 대상자");
        }
    }

    private void println(String message) {
        System.out.println(message);
    }


    private String parseHour(WorkerHistory workerHistory) {
        Integer hour = workerHistory.getCustomTime().getHour();
        if (hour == null) {
            return "--";
        }
        if (hour < 10) {
            return "0" + hour;
        }
        return String.valueOf(hour);
    }

    private String parseMinute(WorkerHistory workerHistory) {
        Integer minute = workerHistory.getCustomTime().getMinute();
        if (minute == null) {
            return "--";
        }
        if (minute < 10) {
            return "0" + minute;
        }
        return String.valueOf(minute);
    }
}
