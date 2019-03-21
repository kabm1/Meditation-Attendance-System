package edu.mum.meditaion_attendance.controller;

import edu.mum.meditaion_attendance.domain.Duration;
import edu.mum.meditaion_attendance.domain.Faculty;
import edu.mum.meditaion_attendance.domain.Section;
import edu.mum.meditaion_attendance.domain.Student;
import edu.mum.meditaion_attendance.models.CumulativeAttendance;
import edu.mum.meditaion_attendance.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
        return "attendance/studentAttendanceForProfessor";
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
    public String viewStudentAttendance(@RequestParam("student") Long student, @RequestParam("duration") Long duration, RedirectAttributes redirect){
        Duration duration1=durationService.findById(duration);
        if(student == 0){
            Faculty faculty= facultyService.findById(101L);
            Section section=sectionService.findByFacultyAndDuration(faculty,duration1);
            redirect.addFlashAttribute("attendances",attendanceService.getAllStudentAttendance(section.getStudents(),duration1));
        }else {
            Student student1 = studentService.findById(student);
            redirect.addFlashAttribute("attendance",  attendanceService.getBlockAttendance(student1, duration1));
        }
        return "redirect:/attendance/viewStudentAttendance";
    }

    @GetMapping("viewStudentAttendance")
    public String viewStudentAttendance(Model model){
        Faculty faculty= facultyService.findById(101L);
        model.addAttribute("durations",sectionService.blockTeachByProfessors(faculty));
        return "attendance/studentAttendanceForProfessor";
    }

    @GetMapping("cumulativeAttendance")
    public String viewCumulative(Model model){
        Student student = studentService.findById(101L);
        CumulativeAttendance cumulativeAttendance= attendanceService.getStudentCumulative(student);
        model.addAttribute("cumulative",cumulativeAttendance);
        model.addAttribute("durations", cumulativeAttendance.getDurations());
        return "attendance/studentAttendance";


    }

    @PostMapping("viewAttendance")
    public String viewStudent(@RequestParam("duration") Long duration, RedirectAttributes redirect){
        Student student = studentService.findById(101L);
        Duration duration1=durationService.findById(duration);
            redirect.addFlashAttribute("attendance",  attendanceService.getBlockAttendance(student, duration1));
        return "redirect:/attendance/cumulativeAttendance";
    }

}
