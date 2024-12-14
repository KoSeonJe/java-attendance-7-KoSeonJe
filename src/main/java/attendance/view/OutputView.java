package attendance.view;

import attendance.domain.WorkerHistory;

public class OutputView {

    private static final String CREATE_RESULT_MESSAGE = "%s월 %s일 %s %s:%s (%s)";
    private static final String LINE_BREAKER = System.lineSeparator();

    private void println(String message) {
        System.out.println(message);
    }

    public void createCrateResult(WorkerHistory workerHistory) {
        String month = workerHistory.getCustomTime().getMonth();
        String day = workerHistory.getCustomTime().getDay();
        String dayOfWeek = workerHistory.getCustomTime().getDayOfWeek();
        String hour = parseHour(workerHistory);
        String minute = parseMinute(workerHistory);
        String attendanceStatus = workerHistory.getAttendanceStatus().getStatus();
        System.out.printf(CREATE_RESULT_MESSAGE + LINE_BREAKER, month, day, dayOfWeek, hour, minute, attendanceStatus);

    }

    private String parseHour(WorkerHistory workerHistory) {
        int hour = workerHistory.getCustomTime().getHour();
        if (hour < 10) {
            return "0" + hour;
        }
        return String.valueOf(hour);
    }

    private String parseMinute(WorkerHistory workerHistory) {
        int minute = workerHistory.getCustomTime().getMinute();
        if (minute < 10) {
            return "0" + minute;
        }
        return String.valueOf(minute);
    }
}
