package com.breakingbad.workerhub.core.converter;

import org.springframework.stereotype.Component;

import javax.persistence.AttributeConverter;
import javax.persistence.Convert;
import java.time.Month;

@Convert
@Component
public class MonthColumnConverter implements AttributeConverter<Month, String> {

    @Override
    public String convertToDatabaseColumn(Month attribute) {
        int intValue = attribute.getValue();
        return String.format("%02d", intValue);
    }

    @Override
    public Month convertToEntityAttribute(String dbData) {
        int intValue = Integer.parseInt(dbData);
        return Month.of(intValue);
    }

}
