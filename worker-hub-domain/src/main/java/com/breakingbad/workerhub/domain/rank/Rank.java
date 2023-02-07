package com.breakingbad.workerhub.domain.rank;

import com.breakingbad.workerhub.domain.department.Department;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Getter
@NoArgsConstructor(access = PROTECTED)
@Table(name = "rank")
@Entity
public class Rank {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "rank_id")
    private Long id;

    @Column(name = "rank_name", nullable = false)
    private String name;

    @Column(name = "rank_description")
    private String description;

    @Column(name = "sort_no", nullable = false)
    private Integer sortNumber;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "department_id")
    private Department department;

}
