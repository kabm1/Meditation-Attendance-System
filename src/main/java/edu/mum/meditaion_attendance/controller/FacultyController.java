package edu.mum.meditaion_attendance.controller;

import edu.mum.meditaion_attendance.domain.Faculty;
import edu.mum.meditaion_attendance.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/faculty")
public class FacultyController {
    @Autowired
    private FacultyService facultyService;
    @GetMapping("/list")
    public String listFaculty(Model model){
        List<Faculty> faculties= facultyService.findFirstTen();
        model.addAttribute("faculties",faculties);
        return "FacultyList";

    }
    @GetMapping("/add")
    public String addFaculty(@ModelAttribute("faculty") Faculty faculty, Model model){
        return "FacultyForm";
    }
}
