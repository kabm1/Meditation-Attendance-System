package edu.mum.meditaion_attendance.service;

import edu.mum.meditaion_attendance.domain.EventType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EventTypeService {
    EventType findById(Long id);
    EventType save(EventType eventType);
    void delete(Long id);
    List<EventType> findAll();
}
