package com.breakingbad.workerhub.domain.company;

import com.breakingbad.workerhub.common.audting.IdAuditingEntity;
import com.breakingbad.workerhub.common.component.Address;
import com.breakingbad.workerhub.common.component.PhoneNumber;
import com.breakingbad.workerhub.common.constant.CompanyClassification;
import com.breakingbad.workerhub.common.constant.YesOrNo;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Getter
@NoArgsConstructor(access = PROTECTED)
@Entity(name = "company")
public class Company extends IdAuditingEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "cp_id")
    private Long id;

    @Column(name = "cp_name")
    private String name;

    @Embedded
    private Address address;

    @Embedded
    @AttributeOverrides(
            @AttributeOverride(name = "phoneNumber",
                    column = @Column(name = "cp_phone_number", length = 12))
    )
    private PhoneNumber phoneNumber;

    @Enumerated(value = STRING)
    @Column(name = "cp_clssification_code")
    private CompanyClassification companyClassification;

    @Enumerated(value = STRING)
    @Column(name = "delete_yn", length = 1)
    private YesOrNo deleteYn;
}
