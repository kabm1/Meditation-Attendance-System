package edu.mum.meditaion_attendance.serviceImpl;

import edu.mum.meditaion_attendance.domain.Duration;
import edu.mum.meditaion_attendance.domain.EventType;
import edu.mum.meditaion_attendance.repository.EventTypeRepository;
import edu.mum.meditaion_attendance.service.EventTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventTypeServiceImpl implements EventTypeService {
    @Autowired
    private EventTypeRepository eventTypeRepository;

    @Override
    public EventType findById(Long id) {
        return eventTypeRepository.findById(id).orElse(null);
    }

    @Override
    public EventType save(EventType eventType) {
        return eventTypeRepository.save(eventType);
    }

    @Override
    public void delete(Long id) {
        eventTypeRepository.deleteById(id);
    }

    @Override
    public List<EventType> findAll() {
        return (List<EventType>)eventTypeRepository.findAll();
    }

    @Override
    public EventType findByShortName(String shortName) {
        return eventTypeRepository.findByShortName(shortName);
    }
}
