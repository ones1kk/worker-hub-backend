package com.breakingbad.workerhub.domain.component;

import com.breakingbad.workerhub.constant.Patterns;
import com.breakingbad.workerhub.core.converter.PasswordConverter;
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
public class Password {

    @Column(name = "password")
    @Convert(converter = PasswordConverter.class)
    private String password;

    public Password(String password) {
        Asserts.that(password).isNotNull().hasText().matches(Patterns.PASSWORD_PATTERN);
        this.password = password;
    }

    @Override
    public String toString() {
        return password;
    }
}
