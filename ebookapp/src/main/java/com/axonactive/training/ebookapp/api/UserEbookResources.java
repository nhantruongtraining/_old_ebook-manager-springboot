package com.axonactive.training.ebookapp.api;

import com.axonactive.training.ebookapp.api.request.UserEbookRequest;
import com.axonactive.training.ebookapp.entity.UserEbook;
import com.axonactive.training.ebookapp.entity.UserEbookStatus;
import com.axonactive.training.ebookapp.exception.ResourceNotFoundException;
import com.axonactive.training.ebookapp.security.entity.User;
import com.axonactive.training.ebookapp.security.service.UserService;
import com.axonactive.training.ebookapp.service.EbookService;
import com.axonactive.training.ebookapp.service.UserEbookService;
import com.axonactive.training.ebookapp.service.dto.UserEbookDto;
import com.axonactive.training.ebookapp.service.mapper.UserEbookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(UserEbookResources.PATH)
public class UserEbookResources {
    public static final String PATH = "/api/userebooks";

    @Autowired
    UserEbookService userEbookService;
    @Autowired
    EbookService ebookService;
    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<List<UserEbookDto>> getAll() {
        List<UserEbook> userEbookList = userEbookService.getAll();
        return ResponseEntity.ok(UserEbookMapper.INSTANCE.toDtos(userEbookList));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserEbookDto> getUserEbookById(@PathVariable Integer id) throws ResourceNotFoundException {
        UserEbook userEbook = userEbookService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id + " not found."));
        return ResponseEntity.ok().body(UserEbookMapper.INSTANCE.toDto(userEbook));
    }

    @GetMapping("/favorites")
    public ResponseEntity<List<UserEbookDto>> getAllFavorites() throws ResourceNotFoundException{
        List<UserEbookDto> favoriteList = userEbookService.returnAllFavorite();
        return ResponseEntity.ok(favoriteList);
    }

    @PostMapping
    public ResponseEntity<UserEbookDto> create(@RequestBody UserEbookRequest userEbookRequest) throws ResourceNotFoundException {
        UserEbook  userEbook  = new UserEbook();
        userEbook.setStatus(userEbookRequest.getEbookStatus());
        userEbook.setFavorite(userEbookRequest.isFavorite());
        userEbook.setEbook( ebookService.findById(userEbookRequest.getEbookId()).orElseThrow(EntityNotFoundException::new));
        userEbook.setUser( userService.findById(userEbookRequest.getUserId()).get());

        userEbook = userEbookService.save(userEbook);

        return ResponseEntity.created(URI.create(PATH + "/" + userEbook.getId())).body(UserEbookMapper.INSTANCE.toDto(userEbook));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserEbookDto> update(@PathVariable(value = "id") Integer id,
                                               @RequestBody UserEbookRequest userEbookUpdate) throws ResourceNotFoundException {
        UserEbook userEbook = userEbookService.findById(id).orElseThrow(() -> new ResourceNotFoundException("ID not found: " + id));
        userEbook.setFavorite(userEbookUpdate.isFavorite());
        userEbook.setCoverImage("path");
        UserEbook editedUserEbook = userEbookService.save(userEbook);
        return ResponseEntity.ok(UserEbookMapper.INSTANCE.toDto(editedUserEbook));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable(value = "id") Integer id) throws ResourceNotFoundException {
        userEbookService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
