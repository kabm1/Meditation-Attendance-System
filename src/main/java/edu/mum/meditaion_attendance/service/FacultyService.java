package edu.mum.meditaion_attendance.service;

import edu.mum.meditaion_attendance.domain.Faculty;

import java.util.List;

public interface FacultyService {
    void save(Faculty faculty);
    Faculty findByEmail(String email);
    Faculty findById(Long id);
    void delete(Faculty faculty);
    void deleteById(Long id);
//    List<Faculty> findAll();
}
