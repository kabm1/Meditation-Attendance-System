package edu.mum.meditaion_attendance.serviceImpl;

import edu.mum.meditaion_attendance.domain.*;
import edu.mum.meditaion_attendance.repository.EventAttendanceRecordRepository;
import edu.mum.meditaion_attendance.service.*;
import edu.mum.meditaion_attendance.util.ManualDataValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class EventAttendanceRecordServiceImpl implements EventAttendanceRecordService {

    private StudentService studentService;
    private EventService eventService;
    private LocationService locationService;
    private EventTypeService eventTypeService;
    private DurationService durationService;
    private EventAttendanceRecordRepository eventAttendanceRecordRepository;

    @Autowired
    public EventAttendanceRecordServiceImpl(StudentService studentService,
                                            EventService eventService,
                                            LocationService locationService,
                                            EventTypeService eventTypeService,
                                            DurationService durationService,
                                            EventAttendanceRecordRepository eventAttendanceRecordRepository) {
        this.durationService=durationService;
        this.studentService = studentService;
        this.eventService = eventService;
        this.locationService = locationService;
        this.eventTypeService = eventTypeService;
        this.eventAttendanceRecordRepository =eventAttendanceRecordRepository;
    }

    @Override
    public List<EventAttendanceRecord> saveManualRecords(MultipartFile file) {
        List<EventAttendanceRecord> records= new ArrayList<>();
        try {
            String content[]= new String(file.getBytes()).split("\n");
            Duration duration=null;
            Event event= null;
            boolean newDuration;
            EventType eventType= eventTypeService.findByShortName(ManualDataValue.MM.name());
            Location location= locationService.findByShortName(ManualDataValue.DB.name());
            for (String line: content) {
                String[] values=line.split(",");
                int[] date = Arrays.stream(values[0].split("/")).mapToInt(Integer::parseInt).toArray();
                LocalDate localDate=LocalDate.of(date[2],date[0],date[1]);
                Student student= studentService.findStudentByStudentId(values[1]);
                if(duration ==null || !isBetweenThisDuration(duration,localDate)){
                    duration= durationService.findByDate(localDate);
                    newDuration=true;
                }else newDuration =false;

                if(event==null || newDuration){
                    event=eventService.findByDurationAndTypeAndLocation(duration,eventType,location);
                }
                records.add(new EventAttendanceRecord(event,student,localDate));
            }

            records= (List<EventAttendanceRecord>)eventAttendanceRecordRepository.saveAll(records);
        }catch (Exception e){
            e.printStackTrace();
        }

        return records;
    }

    @Override
    public List<EventAttendanceRecord> findByStudent(Student student) {
        return eventAttendanceRecordRepository.findAllByStudent(student);
    }

    @Override
    public List<EventAttendanceRecord> saveAutomaticRecords(MultipartFile file) {
          List<EventAttendanceRecord> records= new ArrayList<>();
        try {
            String content= new String(file.getBytes());
            String singleValues[]= content.split("\n");
            Duration duration=null;
            EventType eventType=null;
            Location location=null;
            boolean newDuration,newLocation,newEventType;
            Event event=null;
            for (String entity:singleValues) {
                String[] values=entity.split(",");
                Student student= studentService.findStudentByBarcode(values[0]);
                int[] date = Arrays.stream(values[1].split("/")).mapToInt(Integer::parseInt).toArray();
                LocalDate localDate=LocalDate.of(2000+date[2],date[0],date[1]);
                if(duration ==null || !isBetweenThisDuration(duration,localDate)){
                    duration= durationService.findByDate(localDate);
                    newDuration=true;
                }else newDuration =false;
                if(eventType== null || !eventType.getShortName().equals((values[2].equals("AM") || values[2].equals("EAM")) ? "MM": values[2])) {
                    String shortName = "";
                    if (values[2].equals("AM") || values[2].equals("EAM")) shortName = "MM";
                    else shortName = values[2];
                    eventType = eventTypeService.findByShortName(shortName);
                    newEventType=true;
                }else newEventType =false;
                String locationValue=values[3].substring(0,2);
                if(location == null || !location.getShortName().equals(locationValue)){
                    location = locationService.findByShortName(locationValue);
                    newLocation=true;
                }else newLocation =false;

                if(event==null || newDuration || newEventType || newLocation){
                    event=eventService.findByDurationAndTypeAndLocation(duration,eventType,location);
                }
                records.add(new EventAttendanceRecord(event,student,localDate));


            }
            records= (List<EventAttendanceRecord>)eventAttendanceRecordRepository.saveAll(records);
        }catch (Exception e){
            e.printStackTrace();
        }
        return records;
    }

    private boolean isBetweenThisDuration(Duration duration,LocalDate localDate){
        return ((localDate.isAfter(duration.getStartDate()) && localDate.isBefore(duration.getEndDate()))||
                localDate.isEqual(duration.getStartDate()) || localDate.isEqual(duration.getEndDate()));
    }
}
