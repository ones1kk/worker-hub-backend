package com.breakingbad.workerhub.domain.commoncode;

import com.breakingbad.workerhub.common.audting.IdAuditingEntity;
import com.breakingbad.workerhub.common.component.GroupCodeId;
import com.breakingbad.workerhub.common.constant.YesOrNo;
import com.breakingbad.workerhub.domain.groupcommon.CommonGroupCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.FetchType.LAZY;
import static lombok.AccessLevel.PROTECTED;

@Getter
@NoArgsConstructor(access = PROTECTED)
@Entity(name = "common_code")
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

    @Column(name = "code_char_value1")
    private String charValue1;

    @Column(name = "code_char_value2")
    private String charValue2;

    @Column(name = "code_char_value3")
    private String charValue3;

    @Column(name = "code_int_value1")
    private Integer intValue1;

    @Column(name = "code_int_value2")
    private Integer intValue2;

    @Column(name = "code_int_value3")
    private Integer intValue3;

    @Column(name = "sort_number")
    private Integer sortNumber;

    @Enumerated(value = STRING)
    @Column(name = "use_yn", length = 1)
    private YesOrNo useYn;

}
