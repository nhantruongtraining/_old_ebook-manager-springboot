package com.axonactive.training.ebookapp.entity;

import com.axonactive.training.ebookapp.service.converter.AuthorStatusConverter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;

    @Convert(converter = AuthorStatusConverter.class)
    private AuthorStatus status;
}
