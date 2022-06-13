package com.axonactive.training.ebookapp.api.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PublisherRequest {
    private String name;
    private String location;
    private String url;
    private Integer status;
}
