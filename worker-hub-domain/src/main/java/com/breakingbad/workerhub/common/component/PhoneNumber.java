package com.breakingbad.workerhub.common.component;

import io.github.ones1kk.assertion.core.Asserts;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;
import java.util.regex.Pattern;

import static lombok.AccessLevel.PROTECTED;

@Getter
@NoArgsConstructor(access = PROTECTED)
@Embeddable
public class PhoneNumber {

    @Column(name = "phone_number", length = 11)
    private String phoneNumber;

    @Transient
    private static final Pattern PHONE_NUMBER_PATTERN = Pattern.compile("^(\\d{2,3})(\\d{3,4})(\\d{4})$");

    public PhoneNumber(String phoneNumber) {
        Asserts.that(phoneNumber).isNotNull().matches(PHONE_NUMBER_PATTERN);
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return phoneNumber;
    }
}
