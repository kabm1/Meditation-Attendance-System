package edu.mum.meditaion_attendance.service;

import edu.mum.meditaion_attendance.domain.Duration;
import edu.mum.meditaion_attendance.domain.Event;
import edu.mum.meditaion_attendance.domain.EventType;

import java.util.List;

public interface EventService {
    Event save(Event event);
    Event findById(Long id);
    void delete(Long id);
    List<Event> findAll();
    Event findByDuration(Duration duration);
    List<Event> findByType(EventType type);
    Event findByDurationAndType(Duration duration, EventType type);

}
