package edu.mum.meditaion_attendance.controller;

import edu.mum.meditaion_attendance.domain.*;
import edu.mum.meditaion_attendance.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/section")
public class SectionController {
    private CourseService courseService;
    private FacultyService facultyService;
    private StudentService studentService;
    private DurationService durationService;
    private SectionService sectionService;

    @Autowired
    public SectionController(FacultyService facultyService, CourseService courseService,
                             StudentService studentService, DurationService durationService, SectionService sectionService) {
        this.courseService = courseService;
        this.durationService = durationService;
        this.facultyService = facultyService;
        this.studentService = studentService;
        this.sectionService = sectionService;
    }

    @GetMapping("/list")
    public String listSections(Model model) {
        List<Section> sections= sectionService.findAll();
        model.addAttribute("sections",sections);
        return "section/SectionList";
    }

    @GetMapping("/add")
    public String getSection(@ModelAttribute("section") Section section, Model model) {
        List<Course> courses = courseService.findAll();
        List<Duration> durations = durationService.isAfter(LocalDate.now());
        List<Student> students = studentService.getAllStudents();
        List<Faculty> faculties = facultyService.getAllFaculties();

        model.addAttribute("students", students);
        model.addAttribute("courses", courses);
        model.addAttribute("durations", durations);
        model.addAttribute("faculties", faculties);

        return "section/SectionForm";
    }

    @PostMapping("/add")
    public String saveSection(@Valid @ModelAttribute("section") Section section, BindingResult result,
                              RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "section/SectionForm";
        }
        System.out.println(section.toString());
        Section section1 = sectionService.save(section);
        redirectAttributes.addFlashAttribute("section", section);
        return "redirect:/section/sectionDetails";
    }

    @GetMapping("/sectionDetails")
    public String getDetails(Model model) {
        return "section/SectionDetails";
    }

    @GetMapping("/listDetails")
    public String listDetails(@RequestParam("id") Long sectionId,Model model){
        Section section= sectionService.findById(sectionId);
        model.addAttribute("section",section);
        return "section/SectionDetails";

    }

    @PostMapping("/getStudent")
    @ResponseBody
    public Student getStudent(@RequestParam("id") String studentId, Model model) {
        Student student = studentService.findStudentByStudentId(studentId);
        System.out.println(student);
        return student;
    }


}
