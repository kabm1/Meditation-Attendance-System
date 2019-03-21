package edu.mum.meditaion_attendance.serviceImpl;

import edu.mum.meditaion_attendance.domain.Duration;
import edu.mum.meditaion_attendance.repository.DurationRepo;
import edu.mum.meditaion_attendance.service.DurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DurationServiceImpl implements DurationService {

    @Autowired
    DurationRepo durationRepo;

    @Override
    public List<Duration> findAll() {
        return (List<Duration>) durationRepo.findAll();
    }

    @Override
    public Duration save(Duration duration) {
        return durationRepo.save(duration);
    }

    @Override
    public void delete(Long id) {
        durationRepo.deleteById(id);
    }

    @Override
    public Duration findById(Long id) {
        return durationRepo.findById(id).orElse(null);
    }

    @Override
    public List<Duration> findByYear(int year) {
        List<Duration> durations=findAll();
        return durations.stream().filter(duration -> duration.getEndDate().getYear() == year).collect(Collectors.toList());

    }

    @Override
    public Duration findByDate(LocalDate localDate) {
        List<Duration> durations=findAll();
        Duration duration= durations.stream().filter(date -> {
            return ((localDate.isAfter(date.getStartDate()) && localDate.isBefore(date.getEndDate())) || localDate.isEqual(date.getEndDate()) || localDate.isEqual(date.getStartDate()) );

        }).findFirst().orElse(null);
        return duration;
    }

    @Override
    public List<Duration> isAfter(LocalDate localDate) {
        return durationRepo.findAllByStartDateAfter(localDate);
    }
}
