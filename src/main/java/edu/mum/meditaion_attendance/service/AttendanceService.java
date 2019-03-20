package edu.mum.meditaion_attendance.service;

import edu.mum.meditaion_attendance.domain.Duration;
import edu.mum.meditaion_attendance.domain.Student;
import edu.mum.meditaion_attendance.models.BlockAttendance;

public interface AttendanceService {
    BlockAttendance getBlockAttendance(Student student, Duration duration);
}
