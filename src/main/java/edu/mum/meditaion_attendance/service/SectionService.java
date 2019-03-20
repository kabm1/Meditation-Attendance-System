package edu.mum.meditaion_attendance.service;

import edu.mum.meditaion_attendance.domain.Duration;
import edu.mum.meditaion_attendance.domain.Faculty;
import edu.mum.meditaion_attendance.domain.Section;

import java.util.List;

public interface SectionService {
    Section findByFacultyAndDuration(Faculty faculty, Duration duration);
    List<Duration> blockTeachByProfessors(Faculty professor);
}
