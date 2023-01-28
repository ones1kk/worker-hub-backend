package com.breakingbad.workerhub.common.component;

import com.breakingbad.workerhub.core.converter.CryptoConverter;
import io.github.ones1kk.assertion.core.Asserts;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Embeddable;
import javax.persistence.Transient;
import java.util.regex.Pattern;

import static lombok.AccessLevel.PROTECTED;

@Getter
@NoArgsConstructor(access = PROTECTED)
@Embeddable
public class Email {

    @Column(name = "email")
    @Convert(converter = CryptoConverter.class)
    private String email;

    @Transient
    private static final Pattern EMAIL_PATTERN = Pattern.compile("[a-zA-Z\\d-_.]{2,}.+?@.{2,}?\\..{2,}$");

    public Email(String email) {
        Asserts.that(email).isNotNull().hasText().matches(EMAIL_PATTERN);
        this.email = email;
    }

    @Override
    public String toString() {
        return email;
    }
}
