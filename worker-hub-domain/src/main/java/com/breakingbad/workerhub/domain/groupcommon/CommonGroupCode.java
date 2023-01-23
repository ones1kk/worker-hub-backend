package com.breakingbad.workerhub.domain.groupcommon;

import com.breakingbad.workerhub.common.audting.IdAuditingEntity;
import com.breakingbad.workerhub.common.constant.YesOrNo;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.EnumType.*;
import static lombok.AccessLevel.PROTECTED;

@Getter
@NoArgsConstructor(access = PROTECTED)
@Entity(name = "common_group_code")
public class CommonGroupCode extends IdAuditingEntity {

    @Id
    @Column(name = "group_code")
    private String groupCode;

    @Column(name = "group_code_name")
    private String name;

    @Column(name = "group_code_description")
    private String description;

    @Column(name = "sort_number")
    private Integer sortNumber;

    @Enumerated(value = STRING)
    @Column(name = "use_yn")
    private YesOrNo useYn;
}
