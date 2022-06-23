package com.axonactive.training.ebookapp.api.request;

import com.axonactive.training.ebookapp.entity.AuthorStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorRequest {
    @NotNull
    private String lastName;
    private String firstName;
    private LocalDate dateOfBirth;
    private AuthorStatus status;
}
