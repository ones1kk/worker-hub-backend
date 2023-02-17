package com.breakingbad.workerhub.domain.holidays.repository;

import com.querydsl.core.types.dsl.BooleanExpression;

import java.time.Year;

import static com.breakingbad.workerhub.domain.holidays.QHolidays.holidays;

public class HolidaysExpression {

    public static BooleanExpression equalYear(Year year) {
        return holidays.year.eq(year);
    }

}
