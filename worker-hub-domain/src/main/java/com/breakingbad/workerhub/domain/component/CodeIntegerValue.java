package com.breakingbad.workerhub.domain.component;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import static lombok.AccessLevel.PROTECTED;

@Getter
@NoArgsConstructor(access = PROTECTED)
@Embeddable
public class CodeIntegerValue {

    @Column(name = "code_int_value1")
    private Integer intValue1;

    @Column(name = "code_int_value2")
    private Integer intValue2;

    @Column(name = "code_int_value3")
    private Integer intValue3;

}
