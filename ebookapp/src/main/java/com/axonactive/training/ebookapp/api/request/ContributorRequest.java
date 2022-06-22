package com.axonactive.training.ebookapp.api.request;

import com.axonactive.training.ebookapp.entity.ContributorType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContributorRequest {
    private Integer ebookId;
    private Integer authorId;
    private ContributorType contributorType;
}
