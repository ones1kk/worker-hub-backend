package com.breakingbad.workerhub.core.api.model;

import com.breakingbad.workerhub.domain.holidays.Holidays;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
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
            String str = item.getHolidaysDate().toString();
            int year = Integer.parseInt(str.substring(0, 4));
            int month = Integer.parseInt(str.substring(4, 6));
            int day = Integer.parseInt(str.substring(6, 8));

            holidays.add(new Holidays(Year.of(year), item.getName(),
                    LocalDate.of(year, month, day)));
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
