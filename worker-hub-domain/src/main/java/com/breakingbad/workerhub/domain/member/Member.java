package com.breakingbad.workerhub.domain.member;

import com.breakingbad.workerhub.domain.audting.IdAuditingEntity;
import com.breakingbad.workerhub.domain.component.*;
import com.breakingbad.workerhub.domain.constant.YesOrNo;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Getter
@NoArgsConstructor(access = PROTECTED)
@Table(name = "member")
@Entity
public class Member extends IdAuditingEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Embedded
    private Email email;

    @Embedded
    private Password password;

    @Embedded
    private MemberName name;

    @Embedded
    private PhoneNumber phoneNumber;

    @Embedded
    private Address address;

    @Column(name = "email_receive_yn", length = 1)
    @Enumerated(value = STRING)
    private YesOrNo emailReceiveYn;

    @Column(name = "sms_receive_yn", length = 1)
    @Enumerated(value = STRING)
    private YesOrNo smsReceiveYn;

    @Column(name = "delete_yn", length = 1)
    @Enumerated(value = STRING)
    private YesOrNo deleteYn;

    @Column(name = "employee_yn")
    @Enumerated(value = STRING)
    private YesOrNo employeeYn;

}
