package com.breakingbad.workerhub.domain.leave.approval;

import com.breakingbad.workerhub.domain.audting.IdAuditingEntity;
import com.breakingbad.workerhub.domain.constant.YesOrNo;
import com.breakingbad.workerhub.domain.leave.request.LeaveRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Getter
@NoArgsConstructor(access = PROTECTED)
@Table(name = "leave_approval")
@Entity
public class LeaveApproval extends IdAuditingEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "leave_approval_id")
    private Long id;

    @Column(name = "leave_approval")
    @Enumerated(value = STRING)
    private YesOrNo approvalYn;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "leave_requst_id")
    private LeaveRequest leaveRequest;

    public LeaveApproval(LeaveRequest leaveRequest, YesOrNo approvalYn) {
        this.leaveRequest = leaveRequest;
        this.approvalYn = approvalYn;
    }

    public static LeaveApproval createLeaveApproval(LeaveRequest leaveRequest, YesOrNo approvalYn) {
        return new LeaveApproval(leaveRequest, approvalYn);
    }
}
