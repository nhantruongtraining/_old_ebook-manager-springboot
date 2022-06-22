package com.axonactive.training.ebookapp.api;

import com.axonactive.training.ebookapp.api.request.ContributorRequest;
import com.axonactive.training.ebookapp.entity.Contributor;
import com.axonactive.training.ebookapp.entity.ContributorType;
import com.axonactive.training.ebookapp.service.AuthorService;
import com.axonactive.training.ebookapp.service.ContributorService;
import com.axonactive.training.ebookapp.service.EbookService;
import com.axonactive.training.ebookapp.service.dto.ContributorDto;
import com.axonactive.training.ebookapp.service.mapper.ContributorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(ContributorResources.PATH)
public class ContributorResources {
    public static final String PATH = "/api/contributors";

    @Autowired
    ContributorService contributorService;
    @Autowired
    AuthorService authorService;
    @Autowired
    EbookService ebookService;

    @GetMapping
    public ResponseEntity<List<ContributorDto>> getAll() {
        List<Contributor> contributorList = contributorService.getAll();
        return ResponseEntity.ok(ContributorMapper.INSTANCE.toDtos(contributorList));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContributorDto> getContributorById(@PathVariable Integer id) throws ResourceNotFoundException {
        Contributor contributor = contributorService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id + " not found."));
        return ResponseEntity.ok().body(ContributorMapper.INSTANCE.toDto(contributor));
    }

    @PostMapping
    public ResponseEntity<ContributorDto> create(@RequestBody ContributorRequest contributor) {
        Contributor createdContributor = contributorService.save(new Contributor(null,
        ContributorType.valueOf(String.valueOf(contributor.getContributorType())),
        authorService.findById(contributor.getAuthorId()).get(),
        ebookService.findById(contributor.getEbookId()).get()));

        return ResponseEntity.created(URI.create(PATH + "/" + createdContributor.getId())).body(ContributorMapper.INSTANCE.toDto(createdContributor));
    }


    @PutMapping("/{id}")
    public ResponseEntity<ContributorDto> update(@PathVariable(value = "id") Integer id, @RequestBody ContributorRequest contributorUpdate) throws ResourceNotFoundException {
        Contributor contributor = contributorService.findById(id).orElseThrow(() -> new ResourceNotFoundException("ID not found: " + id));
        contributor.setAuthor(authorService.findById(contributorUpdate.getAuthorId()).get());
        contributor.setEbook(ebookService.findById(contributorUpdate.getEbookId()).get());
        Contributor editedContributor = contributorService.save(contributor);
        return ResponseEntity.ok(ContributorMapper.INSTANCE.toDto(editedContributor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable(value = "id") Integer id) throws ResourceNotFoundException {
        contributorService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
