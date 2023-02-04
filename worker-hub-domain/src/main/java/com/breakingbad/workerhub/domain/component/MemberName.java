package com.breakingbad.workerhub.domain.component;

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
public class MemberName {

    @Column(name = "member_name")
    @Convert(converter = CryptoConverter.class)
    private String name;

    @Transient
    private static final Pattern NAME_PATTERN = Pattern.compile("^([a-zA-Z]).{2,16}|([가-힣]).{1,6}");

    public MemberName(String name) {
        Asserts.that(name).isNotNull().hasText().matches(NAME_PATTERN);
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
