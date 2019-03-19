package edu.mum.meditaion_attendance.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;


@Table(name = "event_attendance_record")
@Data
@NoArgsConstructor
@Entity
public class EventAttendanceRecord implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "event")
    private Event event;

    @ManyToOne
    @JoinColumn(name = "student")
    private Student student;

    private LocalTime time;

    private LocalDate date;



}
