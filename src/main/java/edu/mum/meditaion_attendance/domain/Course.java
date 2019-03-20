package edu.mum.meditaion_attendance.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.time.Duration;

@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue
    private  Long id;
    @NotBlank
    private String CourseName;
    @NotBlank
    private String courseId;
    @NotBlank
    private Faculty faculty;
    @NotBlank
    private Duration duration;
    @NotBlank
    private Student student;

    public Course(){

    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getCourseName() {
        return CourseName;
    }

    public void setCourseName(String courseName) {
        CourseName = courseName;
    }
}
