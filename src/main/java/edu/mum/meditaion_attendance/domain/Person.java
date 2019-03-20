package edu.mum.meditaion_attendance.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class Person implements Serializable {

    @NotEmpty
    @NotBlank
    @NotNull
    private String firstName;
    @NotEmpty
    @NotBlank
    @NotNull
    private String lastName;
    @NotEmpty
    @NotBlank
    @NotNull
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
