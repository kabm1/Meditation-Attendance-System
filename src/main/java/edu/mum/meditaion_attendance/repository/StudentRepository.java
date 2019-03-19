package edu.mum.meditaion_attendance.repository;

import edu.mum.meditaion_attendance.domain.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student,Long> {

    Student findByEmail(String email);
    Student findByStudentId(String studentId);
    Student findByBarCode(String barcode);
    List<Student> findByEntry(LocalDate entry);
    Student findTopByEntry(LocalDate entry);
    Student findAllByEntry(LocalDate entry);
    void deleteByStudentId(String studentId);
    Student findByFirstName(String firstName);


}
