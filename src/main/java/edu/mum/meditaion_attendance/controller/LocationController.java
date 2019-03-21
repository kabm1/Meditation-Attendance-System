package edu.mum.meditaion_attendance.controller;

import edu.mum.meditaion_attendance.domain.Location;
import edu.mum.meditaion_attendance.service.LocationService;
import edu.mum.meditaion_attendance.service.StudentService;
import edu.mum.meditaion_attendance.serviceImpl.LocationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
public class LocationController {

    @Autowired
    private LocationServiceImpl locationServiceImpl;


    @GetMapping("/location/list")
    public String getLocation(Model model) {
        List <Location> location = locationServiceImpl.findAll();
        model.addAttribute("location", location);
        return "locationdir/LocationDetails";
    }

     @GetMapping("/location/add")
      public String getForm(@ModelAttribute("location") Location location, Model model){
          return "locationdir/LocationForm";
      }
    @PostMapping("/location/add")
    public String saveLocation(@Valid @ModelAttribute("location") Location location,BindingResult bindingResult,
                               RedirectAttributes redirectAttedributes) {
        if (bindingResult.hasErrors()) {
            return "locationdir/LocationForm";
        }

        Location loc = locationServiceImpl.save(location);
        redirectAttedributes.addFlashAttribute("location", loc);

        return "redirect:/location/location/details";

    }

    @GetMapping("location/details")
    public String getDetailedLocation(/*@RequestParam("id") Long id */ Model model) {

           List <Location> location = locationServiceImpl.findAll();
           model.addAttribute("location", location);

        return "locationdir/LocationDetails";
    }

    @GetMapping("location/delete")
    public String removeStudent(@RequestParam("id") Long id,Model model,RedirectAttributes redirect){
        try {
            Location location= locationServiceImpl.findById(id);
            locationServiceImpl.delete(location);
            redirect.addFlashAttribute("successMessage","location.success.error");
        }catch (Exception e){
            e.printStackTrace();
            redirect.addFlashAttribute("errorMessage","location.delete.error");
        }

        return "redirect:/location/location/details";
    }


    @GetMapping("/location/edit")
    public String edit(@RequestParam Long id, Model model){
        Location location=locationServiceImpl.findById(id);
        model.addAttribute("location",location);
        return "locationdir/locationEditForm";
    }






}
