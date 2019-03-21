package edu.mum.meditaion_attendance.serviceImpl;

import edu.mum.meditaion_attendance.domain.Faculty;
import edu.mum.meditaion_attendance.domain.Role;
import edu.mum.meditaion_attendance.domain.Student;
import edu.mum.meditaion_attendance.domain.User;
import edu.mum.meditaion_attendance.service.FacultyService;
import edu.mum.meditaion_attendance.service.StudentService;
import edu.mum.meditaion_attendance.util.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class LoginService {

    @Autowired
    UserService userService;
    @Autowired
    FacultyService facultyService;
    @Autowired
    StudentService studentService;


    public Object getCurrentUserID(Authentication auth) {
        String email = auth.getName();
        System.out.println("login"+ email);
        User user = userService.findUserByEmail(email);
        Set<Role> roles = user.getRoles();
        List<String> rolesString = roles.stream().map((x) -> x.getRole()).collect(Collectors.toList());
        for(String s: rolesString){
            System.out.println(s);
        }
        if (rolesString.contains(Roles.FACULTY.name())) {
            Faculty faculty = facultyService.findByEmail(email);
            if (faculty != null) {
                return faculty;
            }
            if (rolesString.contains(Roles.STUDENT.name())) {
                Student student = studentService.findStudentByEmail(email);
                if (student != null) {
                    return student;
                }
            }

        }
            return null;
    }
}