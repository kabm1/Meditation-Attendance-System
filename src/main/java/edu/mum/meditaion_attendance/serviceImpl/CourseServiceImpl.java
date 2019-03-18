package edu.mum.meditaion_attendance.serviceImpl;


import edu.mum.meditaion_attendance.domain.Course;
import edu.mum.meditaion_attendance.domain.Location;
import edu.mum.meditaion_attendance.repository.CourseRepository;
import edu.mum.meditaion_attendance.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    public CourseRepository courseRepository ;



    @Override
    public Iterable<Course> findAll(){
        return courseRepository.findAll();
    }

    @Override
    public Course findById(Long courseId){
        return  courseRepository.findById(courseId).get();

    }
    @Override
    public Course save(Course course){

        return  courseRepository.save(course);
    }



}
