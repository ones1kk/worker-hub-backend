package com.breakingbad.workerhub.common.component;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Getter
@Embeddable
public class Password {

    @Column(name = "password")
    private String password;
}
