package com.breakingbad.workerhub.core.api.kasi.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import static lombok.AccessLevel.PROTECTED;

@Getter
@NoArgsConstructor(access = PROTECTED)
@ToString
public class Body {

    private Items items;

    private Integer numOfRows;

    private Integer pageNo;

    private Integer totalCount;

}
