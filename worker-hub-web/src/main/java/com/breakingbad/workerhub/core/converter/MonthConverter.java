package com.breakingbad.workerhub.core.converter;

import org.springframework.core.convert.converter.Converter;

import java.time.Month;

public class MonthConverter implements Converter<String, Month> {

    @Override
    public Month convert(String source) {
        int intValue = Integer.parseInt(source);
        return Month.of(intValue);
    }

}
