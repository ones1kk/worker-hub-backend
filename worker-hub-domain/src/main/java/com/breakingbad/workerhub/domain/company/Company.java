package com.breakingbad.workerhub.domain.company;

import com.breakingbad.workerhub.domain.audting.IdAuditingEntity;
import com.breakingbad.workerhub.domain.component.Address;
import com.breakingbad.workerhub.domain.component.PhoneNumber;
import com.breakingbad.workerhub.domain.constant.CompanyClassification;
import com.breakingbad.workerhub.domain.constant.YesOrNo;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Getter
@NoArgsConstructor(access = PROTECTED)
@Table(name = "company")
@Entity
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
                    column = @Column(name = "cp_phone_no", length = 12))
    )
    private PhoneNumber phoneNumber;

    @Column(name = "cp_clssification_code")
    @Enumerated(value = STRING)
    private CompanyClassification companyClassification;

    @Column(name = "delete_yn", length = 1)
    @Enumerated(value = STRING)
    private YesOrNo deleteYn;
}
