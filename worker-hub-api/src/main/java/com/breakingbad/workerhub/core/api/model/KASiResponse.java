package com.breakingbad.workerhub.core.api.model;

import com.breakingbad.workerhub.domain.holidays.Holidays;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class KASIResponse {

    private List<Items> items;

    public List<Holidays> toHolidays() {
        List<Holidays> holidays = new ArrayList<>();
        items.forEach(item -> {
            Integer localDate = item.getHolidaysDate();
            holidays.add(Holidays.makeHolidays(localDate, item.getName()));
        });
        return holidays;
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    public static class Items {
        private String name;
        private Integer holidaysDate;
    }

}
