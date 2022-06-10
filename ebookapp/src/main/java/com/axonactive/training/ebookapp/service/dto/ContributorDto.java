package com.axonactive.training.ebookapp.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContributorDto {
    private String authorFirstName;
    private String authorLastName;
    private String coAuthor;
    private String editor;
    private String illustrator;
    private String translator;

}
