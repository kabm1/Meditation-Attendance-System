package edu.mum.meditaion_attendance.serviceImpl;

import edu.mum.meditaion_attendance.domain.Phone;
import edu.mum.meditaion_attendance.repository.PhoneRepository;
import edu.mum.meditaion_attendance.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PhoneServiceImpl implements PhoneService {
   @Autowired
   private PhoneRepository phoneRepository;

    @Override
    public Phone save(Phone phone) {
        return phoneRepository.save(phone);
    }

    @Override
    public Phone findById(Long id) {
        return phoneRepository.findById(id).get();
    }

    @Override
    public List<Phone> getAllPhones() {
        return (List<Phone>) phoneRepository.findAll();
    }

    @Override
    public List<Phone> findByArea(Integer area) {
        return phoneRepository.findAllByArea(area);
    }
}
