package com.breakingbad.workerhub.domain.component;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import static lombok.AccessLevel.PROTECTED;

@Getter
@NoArgsConstructor(access = PROTECTED)
@Embeddable
public class CodeStringValue {

    @Column(name = "code_char_value1")
    private String charValue1;

    @Column(name = "code_char_value2")
    private String charValue2;

    @Column(name = "code_char_value3")
    private String charValue3;

}
