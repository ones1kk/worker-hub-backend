package com.breakingbad.workerhub.domain.component;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@EqualsAndHashCode
@Embeddable
public class EmployeeRoleId implements Serializable {

    @Column(name = "employee_id")
    private Long employeeId;

    @Column(name = "role_id")
    private Long roleId;

}
