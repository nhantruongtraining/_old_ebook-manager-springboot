package com.axonactive.training.ebookapp.api;

import com.axonactive.training.ebookapp.api.request.UserEbookRequest;
import com.axonactive.training.ebookapp.entity.UserEbook;
import com.axonactive.training.ebookapp.exception.ApiException;
import com.axonactive.training.ebookapp.exception.ResourceNotFoundException;
import com.axonactive.training.ebookapp.security.service.UserService;
import com.axonactive.training.ebookapp.service.EbookService;
import com.axonactive.training.ebookapp.service.UserEbookService;
import com.axonactive.training.ebookapp.service.dto.UserEbookDto;
import com.axonactive.training.ebookapp.service.mapper.UserEbookMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Slf4j
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
    public ResponseEntity<UserEbookDto> getUserEbookById(@PathVariable(value = "id") Integer id) {
        Optional<UserEbook> userEbook = userEbookService.findById(id);
        if (!userEbook.isPresent())
            throw ApiException.notFound("UserEbookNotExisted","UserEbook Not Found");
        return ResponseEntity.ok().body(UserEbookMapper.INSTANCE.toDto(userEbook.get()));
    }

    /**
     * This function returns a result list of UserEbooks when User does a search by title
     *
     * @param ebookTitle
     * @return a list of UserEbooks which title contain the string from param
     */
    @GetMapping("/find")
    public ResponseEntity<List<UserEbookDto>> getUserEbookByTitle(@RequestParam("title") String ebookTitle) {
        log.info("find UserEbook by title {} ", ebookTitle);
        if (ebookTitle == null || ebookTitle.isEmpty())
            throw ApiException.badRequest("TitleEmpty", "Title is null or empty");
        List<UserEbook> resultList = userEbookService.findByEbookTitleContaining(ebookTitle);
        return ResponseEntity.ok().body(UserEbookMapper.INSTANCE.toDtos(resultList));
    }

    @PostMapping
    public ResponseEntity<UserEbookDto> create(@RequestBody UserEbookRequest userEbookRequest) {
        UserEbook userEbook = new UserEbook();
        userEbook.setStatus(userEbookRequest.getEbookStatus());
        userEbook.setFavorite(userEbookRequest.isFavorite());
        userEbook.setEbook(ebookService.findById(userEbookRequest.getEbookId()).orElseThrow(ApiException::UserEbookNotFound));
        userEbook.setUser(userService.findById(userEbookRequest.getUserId()).get());

        userEbook = userEbookService.save(userEbook);

        return ResponseEntity.created(URI.create(PATH + "/" + userEbook.getId())).body(UserEbookMapper.INSTANCE.toDto(userEbook));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserEbookDto> update(@PathVariable(value = "id") Integer id,
                                               @RequestBody UserEbookRequest userEbookUpdate) {
        UserEbook userEbook = userEbookService.findById(id).orElseThrow(ApiException::UserEbookNotFound);
        userEbook.setFavorite(userEbookUpdate.isFavorite());
        UserEbook editedUserEbook = userEbookService.save(userEbook);
        return ResponseEntity.ok(UserEbookMapper.INSTANCE.toDto(editedUserEbook));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable(value = "id") Integer id) {
        userEbookService.findById(id).orElseThrow(ApiException::UserEbookNotFound);
        userEbookService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
