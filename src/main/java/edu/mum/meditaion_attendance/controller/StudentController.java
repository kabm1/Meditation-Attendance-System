package edu.mum.meditaion_attendance.controller;

import edu.mum.meditaion_attendance.domain.Student;
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
import java.util.stream.Collectors;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/list")
    public String listStudents(Model model){
        List<Student> students=studentService.getAllStudents()
                .stream()
                .limit(10)
                .collect(Collectors.toList());
        model.addAttribute("students",students);
        return "StudentList";
    }
    @GetMapping("/add")
    public String addStudent(@ModelAttribute("student") Student student,Model model){
        return "StudentForm";
    }
    @PostMapping("/add")
    public String saveStudent(@Valid @ModelAttribute("student") Student student,
                              BindingResult result, RedirectAttributes redirectAttributes){
        if(result.hasErrors()){
            return "StudentForm";
        }
        return "redirect:/student/details";
    }

}
