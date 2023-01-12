package com.breakingbad.workerhub.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static lombok.AccessLevel.PROTECTED;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = PROTECTED)
@Entity
public class CustomMember {

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;
}
