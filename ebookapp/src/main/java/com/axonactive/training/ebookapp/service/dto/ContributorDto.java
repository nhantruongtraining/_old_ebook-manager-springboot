package com.axonactive.training.ebookapp.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContributorDto {
    private String ebookTitle;
    private String authorFirstName;
    private String authorLastName;
    private String authorType;
}
