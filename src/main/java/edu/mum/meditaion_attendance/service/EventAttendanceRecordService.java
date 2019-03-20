package edu.mum.meditaion_attendance.service;

import edu.mum.meditaion_attendance.domain.EventAttendanceRecord;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface EventAttendanceRecordService {
    List<EventAttendanceRecord> saveManualRecords(MultipartFile file);
    List<EventAttendanceRecord> saveAutomaticRecords(MultipartFile file);
}
