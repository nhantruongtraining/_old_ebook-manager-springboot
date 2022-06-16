package com.axonactive.training.ebookapp.security.service;

import com.axonactive.training.ebookapp.security.service.dto.UserDTO;

import java.util.List;

public interface UserService {
    List<UserDTO> getUsers();

}
