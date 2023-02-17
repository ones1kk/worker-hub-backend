package com.breakingbad.workerhub.domain.holidays.repository;

import com.breakingbad.workerhub.domain.holidays.Holidays;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface HolidaysRepository extends JpaRepository<Holidays, LocalDate> {
}
