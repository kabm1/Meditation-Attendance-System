package edu.mum.meditaion_attendance.repository;

import edu.mum.meditaion_attendance.domain.Section;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SectionRepository extends CrudRepository<Section,Long> {

}
