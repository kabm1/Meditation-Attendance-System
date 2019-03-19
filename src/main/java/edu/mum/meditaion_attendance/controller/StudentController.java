package edu.mum.meditaion_attendance.controller;

import edu.mum.meditaion_attendance.domain.Student;
import edu.mum.meditaion_attendance.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

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

}
