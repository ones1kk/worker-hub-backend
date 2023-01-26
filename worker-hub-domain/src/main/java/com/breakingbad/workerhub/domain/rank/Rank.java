package com.breakingbad.workerhub.domain.rank;

import com.breakingbad.workerhub.domain.department.Department;
import lombok.*;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = PROTECTED)
@ToString
@Entity(name = "rank")
public class Rank {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "rank_id")
    private Long id;

    @Column(name = "rank_name", nullable = false)
    private String name;

    @Column(name = "rank_description")
    private String description;

    @Column(name = "sort_number", nullable = false)
    private Integer sortNumber;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "department_id")
    private Department department;

}
