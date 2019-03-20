package edu.mum.meditaion_attendance.repository;


import edu.mum.meditaion_attendance.domain.Location;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository  extends  CrudRepository<Location,Long> {
    List<Location> findAll();
    Location findById(String locationId);
    Location save(Location location);

}
