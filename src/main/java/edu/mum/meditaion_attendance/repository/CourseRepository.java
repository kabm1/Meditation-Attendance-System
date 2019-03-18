package edu.mum.meditaion_attendance.repository;

import edu.mum.meditaion_attendance.domain.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends  CrudRepository<Course, Long> {
}
