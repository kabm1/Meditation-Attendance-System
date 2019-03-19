package edu.mum.meditaion_attendance.repository;

import edu.mum.meditaion_attendance.domain.EventAttendanceRecord;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventAttendanceRecordRepository extends CrudRepository<EventAttendanceRecord,Long> {

}
