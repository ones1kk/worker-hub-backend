package com.breakingbad.workerhub.common.component;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Getter
@Embeddable
public class Email {

    @Column(name = "email")
    private String email;
}
