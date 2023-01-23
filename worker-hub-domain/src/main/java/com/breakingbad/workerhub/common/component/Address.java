package com.breakingbad.workerhub.common.component;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Getter
@Embeddable
public class Address {

    @Column(name = "address")
    private String address;

    @Column(name = "address_detail")
    private String addressDetail;
}
