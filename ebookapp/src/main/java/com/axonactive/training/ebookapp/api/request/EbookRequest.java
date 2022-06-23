package com.axonactive.training.ebookapp.api.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EbookRequest {
    private String title;
    private String description;
    private Integer publishYear;
    private Integer languageId;
    private Integer publisherId;
    private Integer categoryId;
}
