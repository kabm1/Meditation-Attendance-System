package edu.mum.meditaion_attendance.service;

import edu.mum.meditaion_attendance.domain.Course;
import edu.mum.meditaion_attendance.domain.Location;

import java.util.List;

public interface CourseService {
    List<Course> findAll();
    Course findById(Long courseId);
    Course save(Course course);
    void delete(Long id);

}
