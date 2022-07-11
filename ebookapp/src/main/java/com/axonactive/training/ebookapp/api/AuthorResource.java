package com.axonactive.training.ebookapp.api;

import com.axonactive.training.ebookapp.api.request.AuthorRequest;
import com.axonactive.training.ebookapp.entity.Author;
import com.axonactive.training.ebookapp.exception.ApiException;
import com.axonactive.training.ebookapp.service.AuthorService;
import com.axonactive.training.ebookapp.service.dto.AuthorDto;
import com.axonactive.training.ebookapp.service.mapper.AuthorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping(AuthorResource.PATH)
public class AuthorResource {
    public static final String PATH = "/api/authors";

    @Autowired
    AuthorService authorService;

    //    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping
    public ResponseEntity<List<AuthorDto>> getAll() {
        List<Author> authorList = authorService.getAll();
        return ResponseEntity.ok(AuthorMapper.INSTANCE.toDtos(authorList));
    }

    //    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/{id}")
    public ResponseEntity<AuthorDto> getAuthorById(@PathVariable(value = "id") Integer id) {
        Author author = authorService.findById(id)
                .orElseThrow(ApiException::AuthorNotFound);
        return ResponseEntity.ok().body(AuthorMapper.INSTANCE.toDto(author));
    }

    //    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<AuthorDto> create(@RequestBody @Valid AuthorRequest authorRequest) {
        Author author = new Author();
        author.setFirstName(authorRequest.getFirstName());
        author.setLastName(authorRequest.getLastName());
        author.setDateOfBirth(authorRequest.getDateOfBirth());
        author.setStatus(authorRequest.getStatus());

        Author createdAuthor = authorService.save(author);

        return ResponseEntity.created(URI.create(PATH + "/" + createdAuthor.getId())).body(AuthorMapper.INSTANCE.toDto(createdAuthor));
    }

    //    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<AuthorDto> update(@PathVariable(value = "id") Integer id,
                                            @RequestBody AuthorRequest authorUpdate) {
        Author author = authorService.findById(id).orElseThrow(ApiException::AuthorNotFound);
        author.setFirstName(authorUpdate.getFirstName());
        author.setLastName(authorUpdate.getLastName());
        author.setDateOfBirth(authorUpdate.getDateOfBirth());
        author.setStatus(authorUpdate.getStatus());
        Author editedAuthor = authorService.save(author);
        return ResponseEntity.ok(AuthorMapper.INSTANCE.toDto(editedAuthor));
    }

    //    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable(value = "id") Integer id) {
        authorService.findById(id).orElseThrow(ApiException::AuthorNotFound);
        authorService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}