package com.breakingbad.workerhub.domain.leave.approval;

import com.breakingbad.workerhub.common.audting.IdAuditingEntity;
import com.breakingbad.workerhub.common.constant.YesOrNo;
import com.breakingbad.workerhub.domain.leave.request.LeaveRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.EnumType.*;
import static javax.persistence.FetchType.*;
import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Getter
@NoArgsConstructor(access = PROTECTED)
@Entity(name = "leave_approval")
public class LeaveApproval extends IdAuditingEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "leave_approval_id")
    private Long id;

    @Enumerated(value = STRING)
    @Column(name = "leave_approval")
    private YesOrNo approvalYn;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "leave_requst_id")
    private LeaveRequest leaveRequest;

}
