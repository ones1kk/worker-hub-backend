package com.breakingbad.workerhub.domain.department;

import com.breakingbad.workerhub.domain.audting.IdAuditingEntity;
import com.breakingbad.workerhub.domain.constant.YesOrNo;
import com.breakingbad.workerhub.domain.company.Company;
import com.breakingbad.workerhub.domain.rank.Rank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.BatchSize;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Getter
@NoArgsConstructor(access = PROTECTED)
@Entity(name = "department")
@ToString
public class Department extends IdAuditingEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "department_id")
    private Long id;

    @Column(name = "department_name", nullable = false)
    private String name;

    @Column(name = "department_description")
    private String description;

    @Column(name = "department_level", nullable = false)
    private Integer level;

    @Enumerated(value = STRING)
    @Column(name = "leaf_node_yn", nullable = false)
    private YesOrNo leafNodeYn;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "company_id")
    private Company company;

    @BatchSize(size = 50)
    @OneToMany(mappedBy = "department")
    private List<Rank> ranks = new ArrayList<>();

}
