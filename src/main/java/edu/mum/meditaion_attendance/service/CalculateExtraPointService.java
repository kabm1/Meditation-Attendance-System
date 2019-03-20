package edu.mum.meditaion_attendance.service;

public interface CalculateExtraPointService {

    Double getExtraPoint(Double attendancePercentage);
    Double getPercentageAttendance(Integer sessionInBlock,Integer dayPresent);
}
