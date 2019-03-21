package edu.mum.meditaion_attendance.controller;
import edu.mum.meditaion_attendance.domain.Course;
import edu.mum.meditaion_attendance.domain.Location;
import edu.mum.meditaion_attendance.service.CourseService;
import edu.mum.meditaion_attendance.serviceImpl.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;


@Controller
public class CourseController {

    @Autowired
    private CourseService courseService;

        @GetMapping("/course/list")
        public String courseList( Model model) {
            List<Course> course = courseService.findAll();
            model.addAttribute("course", course);
            return "course/courseDetail";
        }

    @GetMapping("/course/add")
    public String getForm(@ModelAttribute("course") Course course, Model model){
        return "course/CourseForm";
    }

    @PostMapping("/course/add")
    public String saveCourse(@Valid @ModelAttribute("course") Course course, BindingResult bindingResult,
                                  RedirectAttributes redirectAttedributes){
        if(bindingResult.hasErrors()){
            return "course/CourseForm";
             }

         Course cor= courseService.save(course);
        redirectAttedributes.addFlashAttribute("course", cor);
        return "redirect:/course/details";
         }



    @GetMapping("/course/details")
    public String getCourseDetails( Model model){

        List<Course> course = courseService.findAll();
        model.addAttribute("course", course);

        return "course/courseDetail";
    }

    @GetMapping("/course/edit")
    public String edit(@RequestParam Long id, Model model){
        Course course=courseService.findById(id);
        model.addAttribute("course",course);
        return "course/courseEditForm";
    }

    @GetMapping("/course/delete")
    public String delete (@RequestParam Long id, RedirectAttributes redirect){
            try {
                courseService.delete(id);
                redirect.addFlashAttribute("successMessage","{course.delete.success}");
            }catch (Exception e){
                e.printStackTrace();
                redirect.addFlashAttribute("errorMessage","{course.delete.error}");
            }
        return "redirect:/course/list";
    }

}
