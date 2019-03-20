package edu.mum.meditaion_attendance.service;

import edu.mum.meditaion_attendance.domain.Location;

import java.time.LocalDate;

public interface LocationService {

    Iterable<Location> findAll();
    Location findById(Long locationId);
    Location save(Location location);
    Location findByShortName(String shortName);
}
