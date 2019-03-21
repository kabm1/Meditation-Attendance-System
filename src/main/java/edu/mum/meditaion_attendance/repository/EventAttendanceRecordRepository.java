package edu.mum.meditaion_attendance.repository;

import edu.mum.meditaion_attendance.domain.EventAttendanceRecord;
import edu.mum.meditaion_attendance.domain.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventAttendanceRecordRepository extends CrudRepository<EventAttendanceRecord,Long> {
    List<EventAttendanceRecord> findAllByStudent(Student student);
}
