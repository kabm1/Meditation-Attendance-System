package edu.mum.meditaion_attendance.controller;

import edu.mum.meditaion_attendance.domain.Duration;
import edu.mum.meditaion_attendance.domain.Faculty;
import edu.mum.meditaion_attendance.domain.Section;
import edu.mum.meditaion_attendance.domain.Student;
import edu.mum.meditaion_attendance.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/attendance")
public class AttendanceController {


    private FacultyService facultyService;

    private SectionService sectionService;

    private DurationService durationService;

    private StudentService studentService;

    private AttendanceService attendanceService;

    @Autowired
    public AttendanceController(FacultyService facultyService, SectionService sectionService, DurationService durationService,StudentService studentService,AttendanceService attendanceService) {
        this.facultyService = facultyService;
        this.sectionService = sectionService;
        this.durationService = durationService;
        this.studentService = studentService;
        this.attendanceService = attendanceService;
    }

    @GetMapping()
    public String studentAttendance(Model model){
        Faculty faculty= facultyService.findById(101L);
        model.addAttribute("durations",sectionService.blockTeachByProfessors(faculty));
        return "attendance/studentAttendance";
    }

    @PostMapping("getStudents")
    @ResponseBody
    public List<Student> getStudents(@RequestParam("block") String blockId){
        Long blockIdL= Long.parseLong(blockId);
        Faculty faculty= facultyService.findById(101L);
        Duration duration=durationService.findById(blockIdL);
        Section section=sectionService.findByFacultyAndDuration(faculty,duration);
        return section.getStudents();

    }
    @PostMapping("view")
    public String viewStudentAttendance(@RequestParam("student") Long student, @RequestParam("duration") Long duration){
        Student student1= studentService.findById(student);
        Duration duration1=durationService.findById(duration);
        attendanceService.getBlockAttendance(student1,duration1);
        return null;
    }
}
