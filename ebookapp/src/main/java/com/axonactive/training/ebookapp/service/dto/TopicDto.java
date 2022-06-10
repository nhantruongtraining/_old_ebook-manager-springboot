package com.axonactive.training.ebookapp.service.dto;

import com.axonactive.training.ebookapp.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TopicDto {
    private String topicValue;
    private String category;
}
