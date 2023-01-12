package com.breakingbad.workerhub.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static lombok.AccessLevel.*;

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
