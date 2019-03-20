package edu.mum.meditaion_attendance.serviceImpl;

import edu.mum.meditaion_attendance.domain.Duration;
import edu.mum.meditaion_attendance.domain.Event;
import edu.mum.meditaion_attendance.domain.EventAttendanceRecord;
import edu.mum.meditaion_attendance.domain.Student;
import edu.mum.meditaion_attendance.models.BlockAttendance;
import edu.mum.meditaion_attendance.service.AttendanceService;
import edu.mum.meditaion_attendance.service.EventAttendanceRecordService;
import edu.mum.meditaion_attendance.service.EventService;
import edu.mum.meditaion_attendance.service.EventTypeService;
import edu.mum.meditaion_attendance.util.ManualDataValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendanceServiceImpl implements AttendanceService {

    @Autowired
    EventService eventService;

    @Autowired
    EventAttendanceRecordService eventAttendanceRecordService;

    @Autowired
    EventTypeService eventTypeService;


    @Override
    public BlockAttendance getBlockAttendance(Student student, Duration duration) {
        Event event=eventService.findByDurationAndType(duration,eventTypeService.findByShortName(ManualDataValue.MM.name()));
        List<EventAttendanceRecord> records=event.getAttendanceRecords();
        return null;
    }
}
