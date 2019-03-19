package edu.mum.meditaion_attendance.domain;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class Student extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String studentId;
    private String barCode;
    private LocalDate entry;
    @Transient
    private MultipartFile profilePicture;
}
