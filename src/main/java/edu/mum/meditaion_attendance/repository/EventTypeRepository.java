package edu.mum.meditaion_attendance.repository;

import edu.mum.meditaion_attendance.domain.EventType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventTypeRepository extends CrudRepository<EventType, Long> {

    EventType findByName(String name);

}
