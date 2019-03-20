
package edu.mum.meditaion_attendance.controller;

import edu.mum.meditaion_attendance.domain.Role;
import edu.mum.meditaion_attendance.domain.User;
import edu.mum.meditaion_attendance.serviceImpl.RoleService;
import edu.mum.meditaion_attendance.serviceImpl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;

    @RequestMapping (value={"/login"}, method = RequestMethod.GET)
    public String login(@ModelAttribute("user") User user){

        User newU = new User();
        newU.setUserName("kabi");
        newU.setPassword("kabio");

        userService.saveUser(newU);
       // System.out.println("this "+ userService.findUserByUserName("kabi").getUserName());
        Iterable<User> users= userService.findAll();
        for(User u: users){
            System.out.println("users: "+ u.getUserName());
            System.out.println("password"+ u.getPassword());
        }

        return "login";
    }




}

