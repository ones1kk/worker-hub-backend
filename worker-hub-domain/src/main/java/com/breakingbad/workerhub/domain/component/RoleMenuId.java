package com.breakingbad.workerhub.domain.component;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@EqualsAndHashCode
@Embeddable
public class RoleMenuId implements Serializable {

    @Column(name = "role_id")
    private Long employeeId;

    @Column(name = "menu_id")
    private Long menuId;
}
