package com.breakingbad.workerhub.domain.member;

import com.breakingbad.workerhub.common.audting.IdAuditingEntity;
import com.breakingbad.workerhub.common.component.*;
import com.breakingbad.workerhub.component.*;
import com.breakingbad.workerhub.common.constant.YesOrNo;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Getter
@NoArgsConstructor(access = PROTECTED)
@Entity(name = "member")
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

    @Enumerated(value = STRING)
    @Column(name = "email_receive_yn", length = 1)
    private YesOrNo emailReceiveYn;

    @Enumerated(value = STRING)
    @Column(name = "sms_receive_yn", length = 1)
    private YesOrNo smsReceiveYn;

    @Enumerated(value = STRING)
    @Column(name = "delete_yn", length = 1)
    private YesOrNo deleteYn;

}
