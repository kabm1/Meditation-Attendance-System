package edu.mum.meditaion_attendance.models;

import edu.mum.meditaion_attendance.domain.Duration;
import edu.mum.meditaion_attendance.domain.Student;

import java.util.List;

public class CumulativeAttendance {

    private Student student;

    private List<Duration> durations;

    private Integer totalSession;

    private Integer totalAttended;

    private Double attendedPercent;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<Duration> getDurations() {
        return durations;
    }

    public void setDurations(List<Duration> durations) {
        this.durations = durations;
    }

    public Integer getTotalSession() {
        return totalSession;
    }

    public void setTotalSession(Integer totalSession) {
        this.totalSession = totalSession;
    }

    public Integer getTotalAttended() {
        return totalAttended;
    }

    public void setTotalAttended(Integer totalAttended) {
        this.totalAttended = totalAttended;
    }

    public Double getAttendedPercent() {
        return attendedPercent;
    }

    public void setAttendedPercent(Double attendedPercent) {
        this.attendedPercent = attendedPercent;
    }
}
