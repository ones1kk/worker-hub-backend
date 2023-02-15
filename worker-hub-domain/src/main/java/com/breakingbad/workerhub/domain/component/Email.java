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
public class Email {

    @Column(name = "email")
    @Convert(converter = CryptoConverter.class)
    private String email;

    public Email(String email) {
        Asserts.that(email).isNotNull().hasText().matches(Patterns.EMAIL_PATTERN);
        this.email = email;
    }

    @Override
    public String toString() {
        return email;
    }
}
