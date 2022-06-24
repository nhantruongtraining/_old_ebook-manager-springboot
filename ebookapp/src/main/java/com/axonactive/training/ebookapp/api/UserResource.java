package com.axonactive.training.ebookapp.api;

import com.axonactive.training.ebookapp.api.request.UserRequest;
import com.axonactive.training.ebookapp.exception.ApiException;
import com.axonactive.training.ebookapp.security.entity.User;
import com.axonactive.training.ebookapp.security.service.UserService;
import com.axonactive.training.ebookapp.security.service.dto.UserDTO;
import com.axonactive.training.ebookapp.security.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(UserResource.PATH)
public class UserResource {
    public static final String PATH = "/api/users";

    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAll() {
        List<User> userList = userService.getAll();
        return ResponseEntity.ok(UserMapper.INSTANCE.mapToDtos(userList));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getById(@PathVariable(value = "id") Integer id) {
        User foundUser = userService.findById(id).orElseThrow(ApiException::UserNotFound);
        return ResponseEntity.ok().body(UserMapper.INSTANCE.mapToDto(foundUser));
    }

    @PostMapping
    public ResponseEntity<UserDTO> create(@RequestBody @Valid UserRequest userRequest) {
        User user = new User();
        user.setUsername(userRequest.getUsername());
        user.setPassword(userRequest.getPassword());
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        user.setEmail(userRequest.getEmail());

        User createdUser = userService.save(user);
        return ResponseEntity.created(URI.create(PATH + "/" + createdUser.getId())).body(UserMapper.INSTANCE.mapToDto(createdUser));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> update(@PathVariable(value = "id") Integer id,
                                          @RequestBody UserRequest userRequest) {
        User user = userService.findById(id).orElseThrow(ApiException::UserNotFound);
        user.setUsername(userRequest.getUsername());
        user.setPassword(userRequest.getPassword());
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        user.setEmail(userRequest.getEmail());

        User updatedUser = userService.save(user);
        return ResponseEntity.ok().body(UserMapper.INSTANCE.mapToDto(updatedUser));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserDTO> delete(@PathVariable(value = "id") Integer id) {
        userService.findById(id).orElseThrow(ApiException::UserNotFound);
        userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
