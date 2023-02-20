package com.breakingbad.workerhub.constant;

import io.github.ones1kk.assertion.core.Asserts;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Collections;
import java.util.EnumSet;
import java.util.Map;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toMap;

@Getter
@RequiredArgsConstructor
public enum Profiles {

    PRODUCTION("prd"),

    DEVELOPMENT("dev"),

    LOCAL("local"),

    TEST("test");

    private final String name;

    private static final Map<String, Profiles> $CODE_LOOKUP = EnumSet.allOf(Profiles.class).stream()
            .collect(collectingAndThen(toMap(it -> it.name, it -> it), Collections::unmodifiableMap));

    public static boolean contains(String name) {
        return $CODE_LOOKUP.containsKey(name);
    }

    public static Profiles from(String name) {
        Asserts.that(contains(name)).as("'Profiles' doesn't contain value of '{}'", name).isTrue();
        return $CODE_LOOKUP.get(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
