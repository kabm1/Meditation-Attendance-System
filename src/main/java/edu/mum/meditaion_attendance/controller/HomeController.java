package edu.mum.meditaion_attendance.controller;

import edu.mum.meditaion_attendance.domain.User;
import edu.mum.meditaion_attendance.serviceImpl.LoginService;
import edu.mum.meditaion_attendance.serviceImpl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes(value = {"userId"})
public class HomeController {


    @Autowired
    LoginService loginService;
    @Autowired
    UserService userService;

    @GetMapping(value={"/","/home"})
    public String home(Model model, Authentication auth){
      String email = auth.getName();
      Long id = loginService.getCurrentUserID(auth);
      System.out.println(id);
      model.addAttribute("username", email);
        return "index";
    }
}
