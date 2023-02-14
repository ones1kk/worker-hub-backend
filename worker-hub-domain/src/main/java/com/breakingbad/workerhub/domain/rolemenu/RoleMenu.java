package com.breakingbad.workerhub.domain.rolemenu;

import com.breakingbad.workerhub.core.constant.MenuAuthorizationCode;
import com.breakingbad.workerhub.domain.audting.IdAuditingEntity;
import com.breakingbad.workerhub.domain.component.RoleMenuId;
import com.breakingbad.workerhub.domain.employee.Employee;
import com.breakingbad.workerhub.domain.menu.Menu;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.FetchType.LAZY;
import static lombok.AccessLevel.PROTECTED;

@Getter
@NoArgsConstructor(access = PROTECTED)
@Table(name = "role_menu")
@Entity
public class RoleMenu extends IdAuditingEntity {

    @EmbeddedId
    private RoleMenuId roleMenuId;

    @Column(name = "menu_auth_code")
    @Enumerated(value = STRING)
    private MenuAuthorizationCode menuAuthorizationCode;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "emplyoee_id", insertable = false, updatable = false)
    private Employee employee;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "menu_id", insertable = false, updatable = false)
    private Menu menu;

}
