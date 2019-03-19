package edu.mum.meditaion_attendance.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class CourseController {

        @GetMapping("/course/list")
        public String courseList(Model model){
            return "CourseList";
        }

    }


