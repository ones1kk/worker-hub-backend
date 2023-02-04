package com.breakingbad.workerhub.domain.leave.request;

import com.breakingbad.workerhub.domain.audting.IdAuditingEntity;
import com.breakingbad.workerhub.domain.constant.LeaveClassification;
import com.breakingbad.workerhub.domain.constant.YesOrNo;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Getter
@NoArgsConstructor(access = PROTECTED)
@Entity(name = "leave_request")
public class LeaveRequest extends IdAuditingEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "leave_request_id")
    private Long id;

    @Enumerated(value = STRING)
    @Column(name = "leave_classification_code")
    private LeaveClassification leaveClassification;

    @Column(name = "leave_reasons", columnDefinition = "text")
    private String reasons;

    @Column(name = "leave_start_date")
    private LocalDate leaveStartDate;

    @Column(name = "leave_end_date")
    private LocalDate leaveEndDate;

    @Enumerated(value = STRING)
    @Column(name = "approval_yn")
    private YesOrNo approvalYn;
}
