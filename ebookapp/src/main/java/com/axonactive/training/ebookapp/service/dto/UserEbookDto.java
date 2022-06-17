package com.axonactive.training.ebookapp.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEbookDto {
    private String ebookTitle;
    private String ebookOwner;
    private boolean favorite;
    private String userEbookStatus;
}
