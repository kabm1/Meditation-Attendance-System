package edu.mum.meditaion_attendance.repository;


import edu.mum.meditaion_attendance.domain.Location;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface LocationRepository  extends  CrudRepository<Location,Long> {
    Location findByShortName(String shortName);
}
