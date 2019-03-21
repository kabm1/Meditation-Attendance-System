package edu.mum.meditaion_attendance.serviceImpl;

import edu.mum.meditaion_attendance.domain.Duration;
import edu.mum.meditaion_attendance.domain.Event;
import edu.mum.meditaion_attendance.domain.EventAttendanceRecord;
import edu.mum.meditaion_attendance.domain.Student;
import edu.mum.meditaion_attendance.models.BlockAttendance;
import edu.mum.meditaion_attendance.models.CumulativeAttendance;
import edu.mum.meditaion_attendance.service.*;
import edu.mum.meditaion_attendance.util.ManualDataValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class AttendanceServiceImpl implements AttendanceService {


   private EventService eventService;

   private EventAttendanceRecordService eventAttendanceRecordService;

   private EventTypeService eventTypeService;

   private CalculateExtraPointService calculateExtraPointService;

    @Autowired
    public AttendanceServiceImpl(EventService eventService, EventAttendanceRecordService eventAttendanceRecordService, EventTypeService eventTypeService, CalculateExtraPointService calculateExtraPointService) {
        this.eventService = eventService;
        this.eventAttendanceRecordService = eventAttendanceRecordService;
        this.eventTypeService = eventTypeService;
        this.calculateExtraPointService = calculateExtraPointService;
    }


    @Override
    public BlockAttendance getBlockAttendance(Student student, Duration duration) {

        Event event=eventService.findByDurationAndType(duration,eventTypeService.findByShortName(ManualDataValue.MM.name()));

        return getSingleStudentAttendance(event,student);
    }

    @Override
    public List<BlockAttendance> getAllStudentAttendance(List<Student> students, Duration duration) {
       final List<BlockAttendance> blockAttendances;
        Event event=eventService.findByDurationAndType(duration,eventTypeService.findByShortName(ManualDataValue.MM.name()));
        blockAttendances = students.stream().map(student -> getSingleStudentAttendance(event, student)).collect(Collectors.toList());
        return blockAttendances;
    }

    @Override
    public CumulativeAttendance getStudentCumulative(Student student) {
        CumulativeAttendance attendance= new CumulativeAttendance();
        List<EventAttendanceRecord> records= eventAttendanceRecordService.findByStudent(student);
        Stream<Event> eventStream=records.stream().map(EventAttendanceRecord::getEvent).distinct();
        Stream<Duration> durationStream= eventStream.map(Event::getDuration);
        Integer totalSession=durationStream.mapToInt(Duration::getNumberOfDays).sum();
        List<Duration> durations=records.stream().map(EventAttendanceRecord::getEvent).distinct().map(Event::getDuration).collect(Collectors.toList());
        Double percentage= totalSession==0 ? 0: calculateExtraPointService.getPercentageAttendance(totalSession,records.size());
        attendance.setTotalAttended(records.size());
        attendance.setStudent(student);
        attendance.setTotalSession(totalSession);
        attendance.setDurations(durations);
        attendance.setAttendedPercent(percentage);
        return attendance;
    }

    private BlockAttendance getSingleStudentAttendance(Event event, Student student){
        BlockAttendance blockAttendance= new BlockAttendance();
        Stream<EventAttendanceRecord> studentRecord=event.getAttendanceRecords().stream().filter(record -> record.getStudent().getId().equals(student.getId()));
        Integer sessionInBlock=event.getDuration().getNumberOfDays();
        Integer dayPresent=(int)studentRecord.count();
        Double percentageAttend= calculateExtraPointService.getPercentageAttendance(sessionInBlock,dayPresent);
        blockAttendance.setStudent(student);
        blockAttendance.setDuration(event.getDuration());
        blockAttendance.setSessionsInBlock(sessionInBlock);
        blockAttendance.setDaysPresent(dayPresent);
        blockAttendance.setPercentageAttended(percentageAttend);
        blockAttendance.setExtraCreditPoints(calculateExtraPointService.getExtraPoint(percentageAttend));
        return blockAttendance;
    }
}
