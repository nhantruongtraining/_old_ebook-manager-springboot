package com.axonactive.training.ebookapp.api.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {
    private String username;
    private String firstName;
    private String lastName;
    private String email;
}
