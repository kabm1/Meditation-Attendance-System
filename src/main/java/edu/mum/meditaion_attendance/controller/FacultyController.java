package edu.mum.meditaion_attendance.controller;

import edu.mum.meditaion_attendance.domain.Faculty;
import edu.mum.meditaion_attendance.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
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
        return "faculty/FacultyList";

    }
    @GetMapping("/add")
    public String addFaculty(@ModelAttribute Faculty faculty, Model model){
        return "faculty/FacultyForm";
    }
    @PostMapping("/add")
    public String saveFaculty(@Valid @ModelAttribute("faculty") Faculty faculty, BindingResult result, RedirectAttributes redirectAttributes){
        if(result.hasErrors()){
            return "faculty/FacultyForm";
        }
        try{
            Faculty faculty1=facultyService.save(faculty);
            redirectAttributes.addFlashAttribute("faculty",faculty1);
            redirectAttributes.addFlashAttribute("successMessage","form.save.success");
        }catch (Exception e){
            redirectAttributes.addFlashAttribute("errorMessage","form.save.error");
        }

        return "redirect:/faculty/facultyDetails";
    }
    @GetMapping("/facultyDetails")
    public String getDetails(Model model){
        return "faculty/FacultyDetails";
    }
    @GetMapping("/delete")
    public String removeFaculty(@RequestParam("id") Long id, Model model){
        Faculty faculty= facultyService.findById(id);
        facultyService.delete(faculty);
        return "redirect:/faculty/list";
    }
    @GetMapping("/details")
    public String facultyDetails(@RequestParam("id") Long id,Model model){
        Faculty faculty= facultyService.findById(id);
        model.addAttribute("faculty",faculty);
        return "faculty/FacultyDetails";

    }
    @GetMapping("/edit")
    public String editStudent(@RequestParam("id") Long id, Model model){
        Faculty faculty= facultyService.findById(id);
        model.addAttribute("faculty",faculty);
        return "faculty/FacultyForm";
    }

}
