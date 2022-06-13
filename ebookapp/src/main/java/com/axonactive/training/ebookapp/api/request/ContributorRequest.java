package com.axonactive.training.ebookapp.api.request;

import com.axonactive.training.ebookapp.entity.Author;
import com.axonactive.training.ebookapp.entity.Ebook;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContributorRequest {
    private String coAuthor;
    private String editor;
    private String illustrator;
    private String translator;
    private Integer authorId;
    private UUID ebookId;
}
