package com.breakingbad.workerhub.core.converter;

import org.springframework.stereotype.Component;

import javax.persistence.AttributeConverter;
import javax.persistence.Convert;
import java.time.Year;

@Convert
@Component
public class YearConverter implements AttributeConverter<Year, Integer> {

    @Override
    public Integer convertToDatabaseColumn(Year attribute) {
        return attribute.getValue();
    }

    @Override
    public Year convertToEntityAttribute(Integer dbData) {
        return Year.of(dbData);
    }

}
