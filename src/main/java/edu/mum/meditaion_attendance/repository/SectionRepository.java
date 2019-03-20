package edu.mum.meditaion_attendance.repository;

import edu.mum.meditaion_attendance.domain.Duration;
import edu.mum.meditaion_attendance.domain.Faculty;
import edu.mum.meditaion_attendance.domain.Section;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SectionRepository extends CrudRepository<Section,Long> {

    Section findByProfessorAndDuration(Faculty faculty, Duration duration);
    List<Section> findAllByProfessor(Faculty faculty);
}
