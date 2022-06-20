package com.axonactive.training.ebookapp.api.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEbookRequest {
    private UUID ebookId;
    private Integer userId;
    private boolean favorite;
    private String ebookStatus;

}
