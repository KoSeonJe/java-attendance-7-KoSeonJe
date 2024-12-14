package attendance.domain;

public enum AttendanceStatus {

    ATTENDANCE("출석"),
    PERCEPTION("지각"),
    ABSENCE("결석");

    private String status;

    AttendanceStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
