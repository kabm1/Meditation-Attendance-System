package edu.mum.meditaion_attendance.repository;

import edu.mum.meditaion_attendance.domain.Phone;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PhoneRepository extends CrudRepository<Phone,Long> {
    List<Phone> findAllByArea(Integer area);
}
