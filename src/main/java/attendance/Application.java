package attendance;

import attendance.common.AttendanceConfig;
import attendance.common.DataInitializer;

public class Application {
    public static void main(String[] args) {
        AttendanceConfig config = new AttendanceConfig();
        DataInitializer dataInitializer = config.dataInitializer();
        dataInitializer.initWorkHistory();
        AttendanceRecorder attendanceRecorder = config.attendanceRecorder();
        attendanceRecorder.execute();
    }
}
