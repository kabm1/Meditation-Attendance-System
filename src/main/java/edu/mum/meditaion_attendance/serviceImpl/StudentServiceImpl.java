package edu.mum.meditaion_attendance.serviceImpl;

import edu.mum.meditaion_attendance.domain.Phone;
import edu.mum.meditaion_attendance.domain.Student;
import edu.mum.meditaion_attendance.repository.PhoneRepository;
import edu.mum.meditaion_attendance.repository.StudentRepository;
import edu.mum.meditaion_attendance.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private PhoneRepository phoneRepository;

    @Override
    public Student findById(Long id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public Student findByFirstName(String firstName) {
        return studentRepository.findByFirstName(firstName);
    }

    @Override
    public Student findStudentByStudentId(String studentId) {
        return studentRepository.findByStudentId(studentId);
    }

    @Override
    public List<Student> getAllStudents() {
        return (List<Student>) studentRepository.findAll();
    }

    @Override
    public Student findStudentByEmail(String email) {
        return studentRepository.findByEmail(email);
    }

    @Override
    public Student findStudentByBarcode(String barCode) {
        return studentRepository.findByBarCode(barCode);
    }

    @Override
    public Student findStudentByEntry(LocalDate entry) {
        return studentRepository.findTopByEntry(entry);
    }

    @Override
    public List<Student> findStudentsByEntry(LocalDate entry) {
        return (List<Student>) studentRepository.findAllByEntry(entry);
    }

    @Override
    public Student save(Student student) {
        Phone phone=phoneRepository.save(student.getPhone());
        student.setPhone(phone);
        return studentRepository.save(student);
    }

    @Override
    public void delete(Student student) {
        studentRepository.delete(student);
    }

    @Override
    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public void deleteByStudentId(String studentId) {
        studentRepository.deleteByStudentId(studentId);
    }


}
