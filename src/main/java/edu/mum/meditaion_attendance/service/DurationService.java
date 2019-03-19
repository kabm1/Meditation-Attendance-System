package edu.mum.meditaion_attendance.service;

import edu.mum.meditaion_attendance.domain.Duration;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DurationService {
    List<Duration> findAll();
    Duration save(Duration duration);
    void delete(Long id);
    Duration findById(Long id);
    List<Duration> findByYear(int year);
}
