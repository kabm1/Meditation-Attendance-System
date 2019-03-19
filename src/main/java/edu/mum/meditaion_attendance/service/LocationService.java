package edu.mum.meditaion_attendance.service;

import edu.mum.meditaion_attendance.domain.Location;

public interface LocationService {

    Iterable<Location> findAll();
    Location findById(Long locationId);
    Location save(Location location);
}
