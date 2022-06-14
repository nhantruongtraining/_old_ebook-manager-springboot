package com.axonactive.training.ebookapp.service.converter;

import com.axonactive.training.ebookapp.entity.AuthorStatus;

import javax.persistence.AttributeConverter;
import java.util.Arrays;

public class AuthorStatusConverter implements AttributeConverter<AuthorStatus, Integer> {
    @Override
    public Integer convertToDatabaseColumn(AuthorStatus authorStatus) {
        return (authorStatus != null)? authorStatus.getValue() : null;
    }

    @Override
    public AuthorStatus convertToEntityAttribute(Integer integer) {
        return Arrays.stream(AuthorStatus.values())
                .filter(each -> each.getValue() == integer)
                .findFirst()
                .orElse(null);
    }
}
