package com.breakingbad.workerhub.core.api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class KASiResponse {

    private List<Items> items;

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    public static class Items {
        private String name;
        private Integer holidaysDate;
    }



}
