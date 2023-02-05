package com.breakingbad.workerhub.domain.employee;

import com.breakingbad.workerhub.domain.audting.IdAuditingEntity;
import com.breakingbad.workerhub.domain.constant.YesOrNo;
import com.breakingbad.workerhub.domain.employeerank.EmployeeRank;
import com.breakingbad.workerhub.domain.member.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Getter
@NoArgsConstructor(access = PROTECTED)
@Entity(name = "employee")
public class Employee extends IdAuditingEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "employee_id")
    private Long id;

    @Column(name = "delete_yn", length = 1)
    @Enumerated(value = STRING)
    private YesOrNo deleteYn;

    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "employee_rank_id")
    private EmployeeRank employeeRank;

}
