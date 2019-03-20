package edu.mum.meditaion_attendance.service;

import edu.mum.meditaion_attendance.domain.Phone;

import java.util.List;

public interface PhoneService {
    Phone save(Phone phone);
    Phone findById(Long id);
    List<Phone> getAllPhones();
    List<Phone> findByArea(Integer area);
}
