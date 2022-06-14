package com.axonactive.training.ebookapp.api.request;

import com.axonactive.training.ebookapp.entity.AuthorStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorRequest {
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private AuthorStatus status;
}
