package com.breakingbad.workerhub.core.event.leave;

import com.breakingbad.workerhub.domain.constant.YesOrNo;
import com.breakingbad.workerhub.domain.leave.request.LeaveRequest;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class LeaveApprovalEvent extends ApplicationEvent {

    private final YesOrNo approvalYn;

    private LeaveApprovalEvent(LeaveRequest leaveRequest, YesOrNo approvalYn) {
        super(leaveRequest);
        this.approvalYn = approvalYn;
    }

    public static LeaveApprovalEvent createEvent(LeaveRequest leaveRequest, YesOrNo approvalYn) {
        return new LeaveApprovalEvent(leaveRequest, approvalYn);
    }

    public boolean isApproved() {
        return approvalYn == YesOrNo.Y;
    }

    public boolean isRejected() {
        return approvalYn == YesOrNo.N;
    }

}
