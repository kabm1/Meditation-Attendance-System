package edu.mum.meditaion_attendance.controller;

import edu.mum.meditaion_attendance.domain.Event;
import edu.mum.meditaion_attendance.service.DurationService;
import edu.mum.meditaion_attendance.service.EventService;
import edu.mum.meditaion_attendance.service.EventTypeService;
import edu.mum.meditaion_attendance.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.time.LocalDate;

@Controller
@RequestMapping("/event")
public class EventController {


    private EventService eventService;
    private DurationService durationService;
    private EventTypeService eventTypeService;
    private LocationService locationService;


    @Autowired
    public EventController(EventService eventService,
                           DurationService durationService,
                           LocationService locationService,
                           EventTypeService eventTypeService) {
        this.eventService = eventService;
        this.durationService=durationService;
        this.eventTypeService=eventTypeService;
        this.locationService=locationService;
    }


    @GetMapping("list")
    public String list(Model model){

        model.addAttribute("events",eventService.findAll());


        return "event/list";
    }

    @GetMapping("add")
    public String addForm(@ModelAttribute Event event,Model model){
        getDependecyValue(model);
        return "event/form";
    }

    @PostMapping("add")
    public String save(@Valid @ModelAttribute("event") Event event, BindingResult result, RedirectAttributes redirect,Model model){
        if(result.hasErrors()){
            getDependecyValue(model);
            return "event/form";

        }
        String message="";
        try {
           message= event.getId() == null ? "event.successfully.saved" : "event.successfully.updated";
            eventService.save(event);
            redirect.addFlashAttribute("successMessage",message);
        }catch (Exception e){
            message= event.getId() == null ? "event.error.saved" : "event.error.updated";
            e.printStackTrace();
            redirect.addFlashAttribute("errorMessage",message);
        }

        return "redirect:list";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") Long id,Model model,RedirectAttributes redirect){
        Event event=eventService.findById(id);
        if(event == null) {
            redirect.addFlashAttribute("errorMessage","event.notFound");
            return "redirect:list";
        }
       getDependecyValue(model);
        model.addAttribute("event",event);
        return "event/form";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Long id,RedirectAttributes redirect){
        try {
            eventService.delete(id);
            redirect.addFlashAttribute("successMessage","event.success.delete");
        }catch (Exception e ){
            e.printStackTrace();
            redirect.addFlashAttribute("errorMessage","event.error.delete");
        }

        return "redirect:/event/list";
    }
    private Model getDependecyValue(Model model){
        model.addAttribute("durations",durationService.findByYear( LocalDate.now().getYear()));
        model.addAttribute("eventTypes",eventTypeService.findAll());
        model.addAttribute("locations",locationService.findAll());

        return model;
    }
}
