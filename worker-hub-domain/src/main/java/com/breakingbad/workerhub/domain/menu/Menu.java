package com.breakingbad.workerhub.domain.menu;

import com.breakingbad.workerhub.domain.audting.IdAuditingEntity;
import com.breakingbad.workerhub.domain.constant.MenuPermissionCode;
import com.breakingbad.workerhub.domain.constant.YesOrNo;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Getter
@NoArgsConstructor(access = PROTECTED)
@Table(name = "menu")
@Entity
public class Menu extends IdAuditingEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "menu_id")
    private Long id;

    @Column(name = "menu_name")
    private String name;

    @Column(name = "menu_description")
    private String description;

    @Column(name = "page_url")
    private String pageUrl;

    @Column(name = "menu_auth_code")
    @Enumerated(value = STRING)
    private MenuPermissionCode permissionCode;

    @Column(name = "menu_level")
    private Integer level;

    @Column(name = "sort_no")
    private Integer sortNumber;

    @Column(name = "leaf_node_yn")
    @Enumerated(value = STRING)
    private YesOrNo leafNodeYn;

    @Column(name = "exposure_yn")
    @Enumerated(value = STRING)
    private YesOrNo exposureYn;

    @Column(name = "use_yn")
    @Enumerated(value = STRING)
    private YesOrNo useYn;

    @Column(name = "delete_yn")
    @Enumerated(value = STRING)
    private YesOrNo deleteYn;

}
