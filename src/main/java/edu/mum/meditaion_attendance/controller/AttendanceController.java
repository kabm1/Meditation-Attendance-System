package edu.mum.meditaion_attendance.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/attendance")
public class AttendanceController {

    @GetMapping()
    public String studentAttendance(){
        return "attendance/studentAttendance";
    }

    @PostMapping("view")
    public String viewStudentAttendance(@RequestParam("student") Long id){
        return null;
    }
}
