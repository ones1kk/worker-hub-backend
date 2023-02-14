package com.breakingbad.workerhub.core.api.kasi.model;

import com.breakingbad.workerhub.domain.holidays.Holidays;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

import static lombok.AccessLevel.PROTECTED;

@Getter
@NoArgsConstructor(access = PROTECTED)
@ToString
public class KasiResponse  {

    private Response response;

    public List<Holidays> toHolidays() {
        List<Holidays> holidays = new ArrayList<>();

        List<Item> itemList = response.getBody().getItems()
                .getItem();
        itemList.forEach(item -> {
            String str = item.getLocdate().toString();
            int year = Integer.parseInt(str.substring(0, 4));
            int month = Integer.parseInt(str.substring(4, 6));
            int day = Integer.parseInt(str.substring(6, 8));

            holidays.add(new Holidays(Year.of(year), item.getDateName(),
                    LocalDate.of(year, month, day)));
        });

        return holidays;
    }

}
