package com.breakingbad.workerhub.domain.leave.request;

import com.breakingbad.workerhub.domain.audting.IdAuditingEntity;
import com.breakingbad.workerhub.domain.constant.LeaveClassification;
import com.breakingbad.workerhub.domain.employee.Employee;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Getter
@NoArgsConstructor(access = PROTECTED)
@Table(name = "leave_request")
@Entity
public class LeaveRequest extends IdAuditingEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "leave_request_id")
    private Long id;

    @Column(name = "leave_classification_code")
    @Enumerated(value = STRING)
    private LeaveClassification leaveClassification;

    @Column(name = "leave_reasons", columnDefinition = "text")
    private String reasons;

    @Column(name = "leave_start_date")
    private LocalDate leaveStartDate;

    @Column(name = "leave_end_date")
    private LocalDate leaveEndDate;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;

}
