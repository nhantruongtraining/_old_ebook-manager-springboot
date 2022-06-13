package com.axonactive.training.ebookapp.api.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorRequest {
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private Integer status;
}
