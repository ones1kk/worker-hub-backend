package com.breakingbad.workerhub.core.api.kasi.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import static lombok.AccessLevel.PRIVATE;

@Getter
@NoArgsConstructor(access = PRIVATE)
@ToString
public class Header {

    private String resultCode;

    private String resultMsg;

}
