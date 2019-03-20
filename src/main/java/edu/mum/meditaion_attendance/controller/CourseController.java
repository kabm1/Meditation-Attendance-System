package edu.mum.meditaion_attendance.controller;

import edu.mum.meditaion_attendance.domain.Course;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;


@Controller
public class CourseController {

        @GetMapping("/course/list")
        public String courseList(@ModelAttribute("course")Course course, Model model)
        {
            return "CourseForm";
        }

    @PostMapping("/course/add")
    public String saveLocation(@Valid @ModelAttribute("course") Course course, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "LocationForm";
        }
        return "redirect:/course/details";
         }
    }


