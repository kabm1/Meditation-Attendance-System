package edu.mum.meditaion_attendance.service;

import edu.mum.meditaion_attendance.domain.Location;
import edu.mum.meditaion_attendance.domain.Student;

import java.util.List;

public interface LocationService {

    List<Location> findAll();
    Location findById( Long locationId);
    Location save(Location location);
    void updateLocation(Location location);
    void delete(Location location);
    Location findByShortName(String shortName);

}
