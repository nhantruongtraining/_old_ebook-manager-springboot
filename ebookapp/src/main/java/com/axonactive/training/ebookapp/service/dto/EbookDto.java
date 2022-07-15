package com.axonactive.training.ebookapp.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EbookDto {
    private Integer id;
    private String title;
    private String description;
    private String publishYear;
    private String publisher;
    private String language;
    private String category;
}
