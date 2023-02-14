package com.breakingbad.workerhub.domain.holidays.repository.query;

import com.breakingbad.workerhub.domain.holidays.Holidays;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.Year;
import java.util.List;

import static com.breakingbad.workerhub.domain.holidays.QHolidays.*;
import static com.breakingbad.workerhub.domain.holidays.repository.HolidaysExpression.equalYear;

@RequiredArgsConstructor
@Repository
public class HolidaysQueryRepository {

    private final JPAQueryFactory queryFactory;

    public List<Holidays> findAllByYear(Year year) {
        return queryFactory.selectFrom(holidays)
                .where(equalYear(year))
                .fetch();
    }

}
