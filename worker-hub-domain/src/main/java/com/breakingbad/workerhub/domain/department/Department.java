package com.breakingbad.workerhub.domain.department;

import com.breakingbad.workerhub.domain.audting.IdAuditingEntity;
import com.breakingbad.workerhub.domain.company.Company;
import com.breakingbad.workerhub.domain.constant.YesOrNo;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Getter
@NoArgsConstructor(access = PROTECTED)
@Table(name = "departments")
@Entity
public class Department extends IdAuditingEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "department_id")
    private Long id;

    @Column(name = "department_name", nullable = false)
    private String name;

    @Column(name = "department_description", columnDefinition = "text")
    private String description;

    @Column(name = "department_level", nullable = false)
    private Integer level;

    @Column(name = "leaf_node_yn", nullable = false)
    @Enumerated(value = STRING)
    private YesOrNo leafNodeYn;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "company_id")
    private Company company;

}
