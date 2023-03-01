package com.breakingbad.workerhub.domain.holidays;

import com.breakingbad.workerhub.core.converter.YearConverter;
import com.breakingbad.workerhub.domain.audting.IdAuditingEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Year;

import static lombok.AccessLevel.PROTECTED;

@Getter
@NoArgsConstructor(access = PROTECTED)
@Table(name = "holidays")
@Entity(name = "holidays")
public class Holidays extends IdAuditingEntity {

    @Id
    @Column(name = "hoidays_date")
    private LocalDate holidayDate;

    @Column(name = "hoildays_name")
    private String name;

    @Column(name = "year")
    @Convert(converter = YearConverter.class)
    private Year year;

    public Holidays(Year year, String name, LocalDate holidayDate) {
        this.year = year;
        this.name = name;
        this.holidayDate = holidayDate;
    }

}
