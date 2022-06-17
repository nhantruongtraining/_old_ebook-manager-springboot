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
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private LocalDate dateOfBirth;

    @Convert(converter = AuthorStatusConverter.class)
    private AuthorStatus status;
}
