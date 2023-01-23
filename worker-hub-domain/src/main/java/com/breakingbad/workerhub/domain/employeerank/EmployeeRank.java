package com.breakingbad.workerhub.domain.employeerank;

import com.breakingbad.workerhub.common.audting.IdAuditingEntity;
import com.breakingbad.workerhub.domain.department.Department;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Getter
@NoArgsConstructor(access = PROTECTED)
@Entity(name = "employee_rank")
public class EmployeeRank extends IdAuditingEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "employee_rank_id")
    private Long id;

    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "department_id")
    private Department department;
}
