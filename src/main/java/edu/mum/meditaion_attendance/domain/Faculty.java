package edu.mum.meditaion_attendance.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
public class Faculty extends Person {
   /* @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;*/

    /*public Long getId() {
    return id;
}

    public void setId(Long id) {
        this.id = id;
    }*/
}
