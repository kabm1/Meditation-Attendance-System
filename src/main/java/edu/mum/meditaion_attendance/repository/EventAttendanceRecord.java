package edu.mum.meditaion_attendance.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventAttendanceRecord extends CrudRepository<EventAttendanceRecord,Long> {

}
