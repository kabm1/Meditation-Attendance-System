package edu.mum.meditaion_attendance.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LocationController {

    @GetMapping("/location/list")
    public String getLocation( Model model ){
          return "location";
    }

}
