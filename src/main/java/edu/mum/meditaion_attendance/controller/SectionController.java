package edu.mum.meditaion_attendance.controller;

import edu.mum.meditaion_attendance.domain.*;
import edu.mum.meditaion_attendance.service.CourseService;
import edu.mum.meditaion_attendance.service.DurationService;
import edu.mum.meditaion_attendance.service.FacultyService;
import edu.mum.meditaion_attendance.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/section")
public class SectionController {
    private CourseService courseService;
    private FacultyService facultyService;
    private StudentService studentService;
    private DurationService durationService;

    @Autowired
    public SectionController(FacultyService facultyService, CourseService courseService,
                             StudentService studentService, DurationService durationService) {
        this.courseService = courseService;
        this.durationService = durationService;
        this.facultyService = facultyService;
        this.studentService = studentService;
    }
    @GetMapping("/add")
    public String getSection(@ModelAttribute("section")Section section, Model model){
        List<Course> courses= courseService.findAll();
        List<Duration> durations= durationService.findAll();
        List<Student> students= studentService.getAllStudents();
        List<Faculty> faculties= facultyService.getAllFaculties();
        return "section/SectionForm";
    }
    @PostMapping("/add")
    public String saveSection(@Valid @ModelAttribute("section") Section section, BindingResult result,
                              RedirectAttributes redirectAttributes){
        return  "redirect:/section/sectionDetails";
    }
    @GetMapping("/sectionDetails")
    public String getDetails(Model model){
        return "section/sectionDetails";
    }


}
