package com.axonactive.training.ebookapp.api.request;

import com.axonactive.training.ebookapp.entity.UserEbookStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEbookRequest {
    private Integer ebookId;
    private Integer userId;
    private boolean favorite;
    private UserEbookStatus ebookStatus;

}
