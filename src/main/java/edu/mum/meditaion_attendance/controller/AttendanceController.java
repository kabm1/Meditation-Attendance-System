package edu.mum.meditaion_attendance.controller;

import edu.mum.meditaion_attendance.domain.*;
import edu.mum.meditaion_attendance.models.CumulativeAttendance;
import edu.mum.meditaion_attendance.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
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
    public String studentAttendance( Model model, HttpSession session){
        Long id=(Long) session.getAttribute("id");
        Faculty faculty= facultyService.findById(id);
        model.addAttribute("durations",sectionService.blockTeachByProfessors(faculty));
        return "attendance/studentAttendanceForProfessor";
    }

    @PostMapping("getStudents")
    @ResponseBody
    public List<Student> getStudents(@RequestParam("block") String blockId,Model model, HttpSession session){
        Long blockIdL= Long.parseLong(blockId);
        Long id=(Long) session.getAttribute("id");
        Faculty faculty= facultyService.findById(id);
        Duration duration=durationService.findById(blockIdL);
        Section section=sectionService.findByFacultyAndDuration(faculty,duration);
        return section.getStudents();

    }
    @PostMapping("view")
    public String viewStudentAttendance(@RequestParam("student") Long student, @RequestParam("duration") Long duration, RedirectAttributes redirect,Model model, HttpSession session){
        Duration duration1=durationService.findById(duration);
        if(student == 0){
            Long id=(Long) session.getAttribute("id");
            Faculty faculty= facultyService.findById(id);
            Section section=sectionService.findByFacultyAndDuration(faculty,duration1);
            redirect.addFlashAttribute("attendances",attendanceService.getAllStudentAttendance(section.getStudents(),duration1));
        }else {
            Student student1 = studentService.findById(student);
            redirect.addFlashAttribute("attendance",  attendanceService.getBlockAttendance(student1, duration1));
        }
        return "redirect:/attendance/viewStudentAttendance";
    }

    @GetMapping("viewStudentAttendance")
    public String viewStudentAttendance(Model model, HttpSession session){
        Long id=(Long) session.getAttribute("id");
        Faculty faculty= facultyService.findById(id);
        model.addAttribute("durations",sectionService.blockTeachByProfessors(faculty));
        return "attendance/studentAttendanceForProfessor";
    }

    @GetMapping("cumulativeAttendance")
    public String viewCumulative(Model model, HttpSession session){
        Long id=(Long) session.getAttribute("id");
        Student student = studentService.findById(id);
        CumulativeAttendance cumulativeAttendance= attendanceService.getStudentCumulative(student);
        model.addAttribute("cumulative",cumulativeAttendance);
        model.addAttribute("durations", cumulativeAttendance.getDurations());
        return "attendance/studentAttendance";


    }

    @PostMapping("viewAttendance")
    public String viewStudent(@RequestParam("duration") Long duration, RedirectAttributes redirect,Model model, HttpSession session){
        Long id=(Long) session.getAttribute("id");
        Student student = studentService.findById(id);
        Duration duration1=durationService.findById(duration);
            redirect.addFlashAttribute("attendance",  attendanceService.getBlockAttendance(student, duration1));
        return "redirect:/attendance/cumulativeAttendance";
    }

}
