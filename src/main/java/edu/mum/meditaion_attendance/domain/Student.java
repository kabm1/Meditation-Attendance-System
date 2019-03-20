package edu.mum.meditaion_attendance.domain;


import edu.mum.meditaion_attendance.validator.StudentPhone;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class Student extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    @Size(min = 6,max = 6)
    private String studentId;
    @NotBlank
    private String barCode;
    @DateTimeFormat(pattern = "MM-dd-yyyy")
    private Date entry;
    @Transient
    private MultipartFile profilePicture;

    @StudentPhone
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="phone_id",nullable = false)
    private Phone phone;
}
