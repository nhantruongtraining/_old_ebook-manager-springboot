package com.axonactive.training.ebookapp.security.service;

import com.axonactive.training.ebookapp.security.entity.User;
import com.axonactive.training.ebookapp.security.service.dto.UserDTO;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAll();
    User save(User user);
    Optional<User> findById(Integer id);
    void deleteById(Integer id);

    List<UserDTO> getUsers();


}
