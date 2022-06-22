package com.axonactive.training.ebookapp.security.service.impl;

import com.axonactive.training.ebookapp.security.entity.User;
import com.axonactive.training.ebookapp.security.repository.UserRepository;
import com.axonactive.training.ebookapp.security.service.UserService;
import com.axonactive.training.ebookapp.security.service.dto.UserDTO;
import com.axonactive.training.ebookapp.security.service.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> findById(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<UserDTO> getUsers() {
                return UserMapper.INSTANCE.mapToDtos(userRepository.findAll());
    }


}
