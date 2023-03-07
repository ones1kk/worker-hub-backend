package com.breakingbad.workerhub.domain.holidays.repository;

import com.breakingbad.workerhub.domain.holidays.Holidays;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.List;

@Repository
public interface HolidaysRepository extends JpaRepository<Holidays, LocalDate> {

    List<Holidays> findAllByYear(Year year);

    @Query(value = "select count(h) from holidays h where h.year in :years")
    Long findCountByYears(@Param(value = "years") List<Year> years);

    List<Holidays> findAllByYearAndMonth(@Param("year") Year year, @Param("month") Month month);

}
