package com.axonactive.training.ebookapp.api.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {
    @NotNull
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
}
