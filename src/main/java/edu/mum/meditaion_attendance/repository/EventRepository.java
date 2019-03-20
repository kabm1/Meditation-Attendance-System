package edu.mum.meditaion_attendance.repository;

import edu.mum.meditaion_attendance.domain.Duration;
import edu.mum.meditaion_attendance.domain.Event;
import edu.mum.meditaion_attendance.domain.EventType;
import edu.mum.meditaion_attendance.domain.Location;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends CrudRepository<Event,Long> {
    Event findByDuration(Duration duration);
    List<Event> findAllByEventType(EventType type);
    Event findByDurationAndEventType(Duration duration, EventType eventType);
    Event findByDurationAndEventTypeAndLocation(Duration duration, EventType eventType, Location location);
}
