package edu.mum.meditaion_attendance.service;

import edu.mum.meditaion_attendance.domain.Course;
import edu.mum.meditaion_attendance.domain.Location;
import org.springframework.security.access.prepost.PreAuthorize;

import javax.annotation.security.RolesAllowed;
import java.util.List;

public interface CourseService {
    @RolesAllowed("ADMIN")
    List<Course> findAll();
    Course findById(Long courseId);
    Course save(Course course);
    void delete(Long id);

}
