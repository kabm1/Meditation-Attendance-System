package edu.mum.meditaion_attendance.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class Event implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn(name = "duration")
    private Duration duration;

    @ManyToOne
    @JoinColumn(name = "type")
    private EventType eventType;

    @ManyToOne
    @JoinColumn(name = "location")
    private Location location;

    @OneToMany(mappedBy = "event",fetch = FetchType.LAZY)
    private List<EventAttendanceRecord> attendanceRecords;
}
