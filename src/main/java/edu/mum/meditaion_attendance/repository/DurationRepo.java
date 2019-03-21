package edu.mum.meditaion_attendance.repository;

import edu.mum.meditaion_attendance.domain.Duration;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DurationRepo extends CrudRepository<Duration, Long> {
    List<Duration> findAllByStartDateAfter(LocalDate localDate);
}
