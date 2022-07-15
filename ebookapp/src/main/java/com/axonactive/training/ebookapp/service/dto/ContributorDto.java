package com.axonactive.training.ebookapp.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContributorDto {
    private Integer id;
    private String ebookTitle;
    private String authorFirstName;
    private String authorLastName;
    private String contributorType;
}
