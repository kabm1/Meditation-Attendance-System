package edu.mum.meditaion_attendance.serviceImpl;

import edu.mum.meditaion_attendance.domain.Duration;
import edu.mum.meditaion_attendance.domain.Faculty;
import edu.mum.meditaion_attendance.domain.Section;
import edu.mum.meditaion_attendance.repository.SectionRepository;
import edu.mum.meditaion_attendance.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SectionServiceImpl implements SectionService {

    @Autowired
    SectionRepository sectionRepository;

    @Override
    public Section findByFacultyAndDuration(Faculty faculty, Duration duration) {
        return sectionRepository.findByProfessorAndDuration(faculty,duration);
    }

    @Override
    public List<Duration> blockTeachByProfessors(Faculty professor) {
        List<Section> sections= sectionRepository.findAllByProfessor(professor);
        return sections.stream().map(Section::getDuration).collect(Collectors.toList());
    }
}
