package edu.mum.meditaion_attendance.serviceImpl;

import edu.mum.meditaion_attendance.domain.Duration;
import edu.mum.meditaion_attendance.domain.Event;
import edu.mum.meditaion_attendance.domain.EventType;
import edu.mum.meditaion_attendance.repository.EventRepository;
import edu.mum.meditaion_attendance.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    EventRepository eventRepository;

    @Override
    public Event save(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public Event findById(Long id) {
        return eventRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
    eventRepository.deleteById(id);
    }

    @Override
    public List<Event> findAll() {
        return (List<Event>) eventRepository.findAll();
    }

    @Override
    public Event findByDuration(Duration duration) {
        return eventRepository.findByDuration(duration);
    }

    @Override
    public List<Event> findByType(EventType type) {
        return eventRepository.findAllByEventType(type);
    }

    @Override
    public Event findByDurationAndType(Duration duration, EventType type) {
        return eventRepository.findByDurationAndEventType(duration,type);
    }
}
