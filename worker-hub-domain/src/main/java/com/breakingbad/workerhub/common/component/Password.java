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
public class Password {

    @Column(name = "password")
//    @Convert(converter = PasswordConverter.class)
    private String password;

    @Transient
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[@$!%*#?&])[a-zA-Z\\d@$!%*#?&]{8,}$");

    public Password(String password) {
        Asserts.that(password).isNotNull().hasText().matches(PASSWORD_PATTERN);
        this.password = password;
    }

    @Override
    public String toString() {
        return password;
    }
}
