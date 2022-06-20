package com.axonactive.training.ebookapp.api.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEbookRequest {
    private String ebookTitle;
    private boolean favorite;
    private String ebookStatus;

}
