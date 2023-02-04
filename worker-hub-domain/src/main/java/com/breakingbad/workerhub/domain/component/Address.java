package com.breakingbad.workerhub.domain.component;

import com.breakingbad.workerhub.core.converter.CryptoConverter;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Embeddable;

import static lombok.AccessLevel.PROTECTED;

@Getter
@NoArgsConstructor(access = PROTECTED)
@Embeddable
public class Address {

    @Column(name = "city")
    @Convert(converter = CryptoConverter.class)
    private String city;

    @Column(name = "street")
    @Convert(converter = CryptoConverter.class)
    private String street;

    @Column(name = "zipcode")
    @Convert(converter = CryptoConverter.class)
    private String zipcode;

    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }

}
