package com.axonactive.training.ebookapp.api;

import com.axonactive.training.ebookapp.api.request.AuthorRequest;
import com.axonactive.training.ebookapp.entity.Author;
import com.axonactive.training.ebookapp.service.AuthorService;
import com.axonactive.training.ebookapp.service.dto.AuthorDto;
import com.axonactive.training.ebookapp.service.mapper.AuthorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(AuthorResources.PATH)
public class AuthorResources {
    public static final String PATH = "/api/authors";

    @Autowired
    AuthorService authorService;

    @GetMapping
    public ResponseEntity<List<AuthorDto>> getAll() {
        List<Author> authorList = authorService.getAll();
        return ResponseEntity.ok(AuthorMapper.INSTANCE.toDtos(authorList));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorDto> getAuthorById(@PathVariable Integer id) throws ResourceNotFoundException {
        Author author = authorService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id + " not found."));
        return ResponseEntity.ok().body(AuthorMapper.INSTANCE.toDto(author));
    }

    @PostMapping
    public ResponseEntity<AuthorDto> create(@RequestBody AuthorRequest author) {
        Author createdAuthor = authorService.save(new Author(
                null, author.getFirstName(), author.getLastName(),
                author.getDateOfBirth(), author.getStatus()));

        return ResponseEntity.created(URI.create(PATH + "/" + createdAuthor.getId())).body(AuthorMapper.INSTANCE.toDto(createdAuthor));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AuthorDto> update(@PathVariable(value = "id") Integer id,
                                            @RequestBody AuthorRequest authorUpdate) throws ResourceNotFoundException {
        Author author = authorService.findById(id).orElseThrow(() -> new ResourceNotFoundException("ID not found: " + id));
        author.setFirstName(authorUpdate.getFirstName());
        author.setLastName(authorUpdate.getLastName());
        author.setDateOfBirth(authorUpdate.getDateOfBirth());
        author.setStatus(authorUpdate.getStatus());
        Author editedAuthor = authorService.save(author);
        return ResponseEntity.ok(AuthorMapper.INSTANCE.toDto(editedAuthor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable(value = "id") Integer id) throws ResourceNotFoundException {
        authorService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
