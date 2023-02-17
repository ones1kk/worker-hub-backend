package com.breakingbad.workerhub.core.api.kasi.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import static lombok.AccessLevel.PROTECTED;

@Getter
@NoArgsConstructor(access = PROTECTED)
@ToString
public class Item {

    private String dateKind;

    private String dateName;

    private String isHoliday;

    private Integer locdate;

    private Integer seq;

}
