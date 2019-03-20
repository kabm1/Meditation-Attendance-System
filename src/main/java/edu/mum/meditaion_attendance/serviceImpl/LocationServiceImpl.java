package edu.mum.meditaion_attendance.serviceImpl;

import edu.mum.meditaion_attendance.domain.Location;
import edu.mum.meditaion_attendance.repository.LocationRepository;
import edu.mum.meditaion_attendance.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationRepository locationRepository;


    @Override
    public List<Location> findAll(){
        return (List<Location>) locationRepository.findAll();
    }

    @Override
    public Location findById( Long locationId){
        return  locationRepository.findById(locationId).get();

    }
    @Override
    public Location save(Location location){

        return  locationRepository.save(location);
    }

    @Override
    public void updateLocation(Location location) {
        locationRepository.save(location);
    }

    @Override
    public void deleteLocation(Long locationId) {
        locationRepository.delete(findById(locationId));
    }

}
