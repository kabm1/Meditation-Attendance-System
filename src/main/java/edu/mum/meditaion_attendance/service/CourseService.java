package edu.mum.meditaion_attendance.service;

import edu.mum.meditaion_attendance.domain.Course;
import edu.mum.meditaion_attendance.domain.Location;

public interface CourseService {
    Iterable<Course> findAll();
    Course findById(Long courseId);
    Course save(Course course);

}
