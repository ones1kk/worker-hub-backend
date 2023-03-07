package com.breakingbad.workerhub.domain.groupcommon;

import com.breakingbad.workerhub.domain.audting.IdAuditingEntity;
import com.breakingbad.workerhub.domain.constant.YesOrNo;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.EnumType.STRING;
import static lombok.AccessLevel.PROTECTED;

@Getter
@NoArgsConstructor(access = PROTECTED)
@Table(name = "common_group_code")
@Entity
public class CommonGroupCode extends IdAuditingEntity {

    @Id
    @Column(name = "group_code")
    private String groupCode;

    @Column(name = "group_code_name")
    private String name;

    @Column(name = "group_code_description", columnDefinition = "text")
    private String description;

    @Column(name = "sort_no")
    private Integer sortNumber;

    @Column(name = "use_yn")
    @Enumerated(value = STRING)
    private YesOrNo useYn;

}
