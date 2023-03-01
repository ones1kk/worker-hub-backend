package com.breakingbad.workerhub.domain.role;

import com.breakingbad.workerhub.domain.audting.IdAuditingEntity;
import com.breakingbad.workerhub.domain.constant.RoleCode;
import com.breakingbad.workerhub.domain.constant.YesOrNo;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Getter
@NoArgsConstructor(access = PROTECTED)
@Table(name = "role")
@Entity
public class Role extends IdAuditingEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "role_id")
    private Long id;

    @Column(name = "role_name")
    private String name;

    @Column(name = "role_cde")
    private RoleCode roleCode;

    @Column(name = "role_description", columnDefinition = "text")
    private String description;

    @Column(name = "approval_yn")
    @Enumerated(value = STRING)
    private YesOrNo approvalYn;

    @Column(name = "sort_no")
    private Integer sortNumber;

    @Column(name = "use_yn")
    @Enumerated(value = STRING)
    private YesOrNo useYn;

    @Column(name = "delete_yn")
    @Enumerated(value = STRING)
    private YesOrNo deleteYn;

}
