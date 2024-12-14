package attendance.domain;

public class WorkerHistory {
    private String name;
    private CustomTime customTime;
    private AttendanceStatus attendanceStatus;

    public WorkerHistory(String name, CustomTime customTime, AttendanceStatus attendanceStatus) {
        this.name = name;
        this.customTime = customTime;
        this.attendanceStatus = attendanceStatus;
    }

    public String getName() {
        return name;
    }

    public CustomTime getCustomTime() {
        return customTime;
    }

    public AttendanceStatus getAttendanceStatus() {
        return attendanceStatus;
    }

    public static WorkerHistory create(String name, CustomTime customTime, AttendanceStatus attendanceStatus) {
        return new WorkerHistory(name, customTime, attendanceStatus);
    }
}
