package com.breakingbad.workerhub.domain.employeerole;

import com.breakingbad.workerhub.domain.audting.IdAuditingEntity;
import com.breakingbad.workerhub.domain.component.EmployeeRoleId;
import com.breakingbad.workerhub.domain.constant.RoleStatusCode;
import com.breakingbad.workerhub.domain.employee.Employee;
import com.breakingbad.workerhub.domain.role.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.FetchType.*;
import static lombok.AccessLevel.PROTECTED;

@Getter
@NoArgsConstructor(access = PROTECTED)
@Table(name = "employee_role")
@Entity
public class EmployeeRole extends IdAuditingEntity {

    @EmbeddedId
    private EmployeeRoleId employeeRoleId;

    @Column(name = "role_status_code")
    @Enumerated(value = STRING)
    private RoleStatusCode roleStatusCode;

    @Column(name = "role_status_reason", length = 1000)
    private String roleStatusReason;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "employee_id", insertable = false, updatable = false)
    private Employee employee;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "role_id", insertable = false, updatable = false)
    private Role role;

}
