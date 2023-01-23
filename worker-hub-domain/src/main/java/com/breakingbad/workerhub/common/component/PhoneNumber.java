package com.breakingbad.workerhub.common.component;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Getter
@Embeddable
public class PhoneNumber {

    @Column(name = "phone_number", length = 11)
    private String phoneNumber;
}
