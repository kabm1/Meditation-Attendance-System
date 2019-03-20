package edu.mum.meditaion_attendance.controller;

import edu.mum.meditaion_attendance.domain.Student;
import edu.mum.meditaion_attendance.exception.UnableToUploadImageException;
import edu.mum.meditaion_attendance.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.*;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/list")
    public String listStudents(Model model){
        List<Student> students=studentService.getFirstTen();

        model.addAttribute("students",students);
        return "student/StudentList";
    }

    @GetMapping("/add")
    public String addStudent(@ModelAttribute("student") Student student,Model model){
        return "student/StudentForm";
    }

    @PostMapping("/add")
    public String saveStudent(@Valid @ModelAttribute("student") Student student,
                              BindingResult result,@RequestParam("profilePicture") MultipartFile studentImage ,RedirectAttributes redirectAttributes, HttpServletRequest request){
        if(result.hasErrors()){
            return "student/StudentForm";
        }

        String[] suppressedFields = result.getSuppressedFields();
        if (suppressedFields.length > 0) {
            throw new RuntimeException("Attempt to bind fields that haven't been allowed in initBinder(): "
                    + StringUtils.addStringToArray(suppressedFields, ", "));
        }
//        MultipartFile studentImage = student.getProfilePicture();
        System.out.println(studentImage);
        String rootDirectory= request.getSession().getServletContext().getRealPath("/");
        System.out.println(rootDirectory);

        if(studentImage ==null){
            System.out.println("the image from form data is null");
            throw new UnableToUploadImageException(student.getStudentId());
        }
        if(!studentImage.isEmpty()){

            InputStream inputStream = null;
            OutputStream outputStream = null;
            MultipartFile file = studentImage;

            String rootPath = System.getProperty("user.dir");
            System.out.println("from the try catch");
            System.out.println(rootPath);
            File dir = new File(rootPath + File.separator + "src"+
                    File.separator+"main"+File.separator+"resources"+File.separator+ "static"+File.separator+"images");
            if (!dir.exists())
                dir.mkdirs();
            String fileName = file.getOriginalFilename();
            File serverFile = new File(dir.getAbsolutePath() + File.separator + fileName);

            try {
                inputStream = file.getInputStream();

                outputStream = new FileOutputStream(serverFile);
                int read = 0;
                byte[] bytes = new byte[1024];

                while ((read = inputStream.read(bytes)) != -1) {
                    outputStream.write(bytes, 0, read);
                }
            } catch (Exception e) {
                throw  new UnableToUploadImageException(student.getStudentId());
            }

        }
        Student student1=studentService.save(student);
        redirectAttributes.addFlashAttribute("student",student1);
        return "redirect:/student/studentDetails";
    }
    @GetMapping("/studentDetails")
    public String getDetails(Model model){
        return "student/StudentDetails";
    }

    @GetMapping("/delete")
    public String removeStudent(@RequestParam("id") Long id,Model model){
        Student student= studentService.findById(id);
        studentService.delete(student);
        return "redirect:/student/list";
    }
    @GetMapping("/details")
    public String studentDetails(@RequestParam("id") Long id,Model model){
        Student student= studentService.findById(id);
        model.addAttribute("student",student);
        return "student/StudentDetails";

    }
    @GetMapping("/edit")
    public String editStudent(@RequestParam("id") Long id, Model model){
        Student student= studentService.findById(id);
        model.addAttribute("student",student);
        return "student/StudentEdit";
    }

}
