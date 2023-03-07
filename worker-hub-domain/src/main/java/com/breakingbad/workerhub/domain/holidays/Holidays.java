package com.breakingbad.workerhub.domain.holidays;

import com.breakingbad.workerhub.core.converter.MonthColumnConverter;
import com.breakingbad.workerhub.core.converter.YearConverter;
import com.breakingbad.workerhub.domain.audting.IdAuditingEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.format.DateTimeFormatter;

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

    @Column(name = "month")
    @Convert(converter = MonthColumnConverter.class)
    private Month month;

    @Transient
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMdd");

    public Holidays(Year year, String name, LocalDate holidayDate) {
        this.year = year;
        this.name = name;
        this.holidayDate = holidayDate;
        String str = holidayDate.format(DATE_TIME_FORMATTER);
        int month = Integer.parseInt(str.substring(4, 6));
        this.month = Month.of(month);
    }

    public Holidays(Year year, String name, LocalDate holidayDate, Month month) {
        this.year = year;
        this.name = name;
        this.holidayDate = holidayDate;
        this.month = month;
    }

    public static Holidays makeHolidays(Integer localDate, String name) {
        String str = localDate.toString();
        int year = Integer.parseInt(str.substring(0, 4));
        int month = Integer.parseInt(str.substring(4, 6));
        int day = Integer.parseInt(str.substring(6, 8));

        return new Holidays(Year.of(year), name,
                LocalDate.of(year, month, day), Month.of(month));
    }

}
