package com.axonactive.training.ebookapp.service.converter;

import com.axonactive.training.ebookapp.entity.AuthorStatus;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Arrays;

@Converter(autoApply = true)
public class AuthorStatusConverter implements AttributeConverter<AuthorStatus, Integer> {
    @Override
    public Integer convertToDatabaseColumn(AuthorStatus authorStatus) {
        return (authorStatus != null)? authorStatus.getValue() : 2;
    }

    @Override
    public AuthorStatus convertToEntityAttribute(Integer integer) {
        return Arrays.stream(AuthorStatus.values())
                .filter(each -> each.getValue() == integer)
                .findFirst()
                .orElse(AuthorStatus.UNKNOWN);
    }
}
