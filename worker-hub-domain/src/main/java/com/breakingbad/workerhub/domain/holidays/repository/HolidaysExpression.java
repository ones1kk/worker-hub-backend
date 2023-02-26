package com.breakingbad.workerhub.domain.holidays.repository;

import com.querydsl.core.types.dsl.BooleanExpression;

import java.time.Year;
import java.util.List;

import static com.breakingbad.workerhub.domain.holidays.QHolidays.holidays;
import static org.springframework.util.CollectionUtils.isEmpty;

public class HolidaysExpression {

    public static BooleanExpression equalYear(Year year) {
        if (year == null) {
            return null;
        }
        return holidays.year.eq(year);
    }

    public static BooleanExpression inYears(List<Year> years) {
        if (isEmpty(years)) {
            return null;
        }
        return holidays.year.in(years);
    }

}
