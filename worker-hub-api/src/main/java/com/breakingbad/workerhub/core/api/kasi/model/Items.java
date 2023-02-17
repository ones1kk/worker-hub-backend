package com.breakingbad.workerhub.core.api.kasi.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

import static lombok.AccessLevel.PROTECTED;

@Getter
@NoArgsConstructor(access = PROTECTED)
@ToString
public class Items {

    private List<Item> item;

}
