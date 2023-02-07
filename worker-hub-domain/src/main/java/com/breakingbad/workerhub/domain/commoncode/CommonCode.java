package com.breakingbad.workerhub.domain.commoncode;

import com.breakingbad.workerhub.domain.audting.IdAuditingEntity;
import com.breakingbad.workerhub.domain.component.CodeIntegerValue;
import com.breakingbad.workerhub.domain.component.CodeStringValue;
import com.breakingbad.workerhub.domain.component.GroupCodeId;
import com.breakingbad.workerhub.domain.constant.YesOrNo;
import com.breakingbad.workerhub.domain.groupcommon.CommonGroupCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.FetchType.LAZY;
import static lombok.AccessLevel.PROTECTED;

@Getter
@NoArgsConstructor(access = PROTECTED)
@Table(name = "common_code")
@Entity
public class CommonCode extends IdAuditingEntity {

    @EmbeddedId
    private GroupCodeId id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "group_code")
    @MapsId(value = "groupCode")
    private CommonGroupCode commonGroupCode;

    @Column(name = "code_name")
    private String name;

    @Column(name = "code_description")
    private String description;

    @Embedded
    private CodeStringValue codeStringValue;

    @Embedded
    private CodeIntegerValue codeIntegerValue;

    @Column(name = "sort_no")
    private Integer sortNo;

    @Column(name = "use_yn", length = 1)
    @Enumerated(value = STRING)
    private YesOrNo useYn;

}
