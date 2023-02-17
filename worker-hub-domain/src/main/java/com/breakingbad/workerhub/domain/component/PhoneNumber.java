package com.breakingbad.workerhub.domain.component;

import com.breakingbad.workerhub.constant.Patterns;
import com.breakingbad.workerhub.core.converter.CryptoConverter;
import io.github.ones1kk.assertion.core.Asserts;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Embeddable;

import static lombok.AccessLevel.PROTECTED;

@Getter
@NoArgsConstructor(access = PROTECTED)
@Embeddable
public class PhoneNumber {

    @Column(name = "phone_no", length = 11)
    @Convert(converter = CryptoConverter.class)
    private String phoneNumber;

    public PhoneNumber(String phoneNumber) {
        Asserts.that(phoneNumber).isNotNull().hasText().matches(Patterns.PHONE_NUMBER_PATTERN);
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return phoneNumber;
    }
}
