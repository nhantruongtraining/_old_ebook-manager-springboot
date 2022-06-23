package com.axonactive.training.ebookapp.api;

import com.axonactive.training.ebookapp.api.request.PublisherRequest;
import com.axonactive.training.ebookapp.entity.Publisher;
import com.axonactive.training.ebookapp.exception.DemoException;
import com.axonactive.training.ebookapp.exception.ResourceNotFoundException;
import com.axonactive.training.ebookapp.service.PublisherService;
import com.axonactive.training.ebookapp.service.dto.PublisherDto;
import com.axonactive.training.ebookapp.service.mapper.PublisherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(PublisherResources.PATH)
public class PublisherResources {
    public static final String PATH = "/api/publishers";

    @Autowired
    PublisherService publisherService;

    @GetMapping
    public ResponseEntity<List<PublisherDto>> getAll() {
        List<Publisher> publisherList = publisherService.getAll();
        return ResponseEntity.ok(PublisherMapper.INSTANCE.toDtos(publisherList));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PublisherDto> getPublisherById(@PathVariable Integer id) {
        Publisher publisher = publisherService.findById(id)
                .orElseThrow(DemoException::PublisherNotFound);
        return ResponseEntity.ok().body(PublisherMapper.INSTANCE.toDto(publisher));
    }

    @PostMapping
    public ResponseEntity<PublisherDto> create(@RequestBody PublisherRequest publisher) {
        Publisher createdPublisher = publisherService.save(new Publisher(
                null, publisher.getName(), publisher.getLocation(),
                publisher.getUrl(), publisher.getStatus()));

        return ResponseEntity.created(URI.create(PATH + "/" + createdPublisher.getId()))
                .body(PublisherMapper.INSTANCE.toDto(createdPublisher));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PublisherDto> update(@PathVariable(value = "id") Integer id,
                                            @RequestBody PublisherRequest publisherUpdate) {
        Publisher publisher = publisherService.findById(id).orElseThrow(DemoException::PublisherNotFound);
        publisher.setName(publisherUpdate.getName());
        publisher.setLocation(publisherUpdate.getLocation());
        publisher.setUrl(publisherUpdate.getUrl());
        publisher.setStatus(publisherUpdate.getStatus());
        Publisher editedPublisher = publisherService.save(publisher);
        return ResponseEntity.ok(PublisherMapper.INSTANCE.toDto(editedPublisher));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable(value = "id") Integer id) {
        publisherService.findById(id).orElseThrow(DemoException::PublisherNotFound);
        publisherService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
