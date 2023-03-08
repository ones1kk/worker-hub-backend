package com.breakingbad.workerhub.core.event.leave;

import com.breakingbad.workerhub.constant.LoggerNames;
import com.breakingbad.workerhub.domain.constant.YesOrNo;
import com.breakingbad.workerhub.domain.leave.approval.LeaveApproval;
import com.breakingbad.workerhub.domain.leave.history.LeaveHistory;
import com.breakingbad.workerhub.domain.leave.request.LeaveRequest;
import com.breakingbad.workerhub.internal.domain.leave.approval.service.LeaveApprovalInternalService;
import com.breakingbad.workerhub.internal.domain.leave.history.service.LeaveHistoryInternalService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Slf4j(topic = LoggerNames.LEAVE_APPROVAL)
@RequiredArgsConstructor
@Component
public class LeaveApprovalEventLinter implements ApplicationListener<LeaveApprovalEvent> {

    private final LeaveApprovalInternalService approvalInternalService;

    private final LeaveHistoryInternalService historyService;

    /**
     * 휴가 신청을 처리한다.
     *
     * @param event the event to respond to
     */
    @Override
    public void onApplicationEvent(LeaveApprovalEvent event) {
        LeaveRequest leaveRequest = (LeaveRequest) event.getSource();
        YesOrNo approvalYn = event.getApprovalYn();
        LeaveApproval leaveApproval = LeaveApproval.createLeaveApproval(leaveRequest, approvalYn);
        saveLeaveApproval(leaveApproval);

        if (event.isApproved()) {
            saveLeaveHistory(leaveApproval);
        }
    }

    /**
     * 휴가 결재 여부를 저장한다.
     *
     * @param leaveApproval 휴가 결재 내역
     */
    public void saveLeaveApproval(LeaveApproval leaveApproval) {
        approvalInternalService.save(leaveApproval);
        log.info("save leave approval {}", leaveApproval);
    }

    /**
     * 휴가 결재 승인 시 휴가 사용 이력을 저장한다.
     *
     * @param leaveApproval 휴가 결재 내역
     */
    public void saveLeaveHistory(LeaveApproval leaveApproval) {
        LeaveHistory leaveHistory = LeaveHistory.createLeaveHistory(leaveApproval);
        historyService.save(leaveHistory);
        log.info("save leave history {}", leaveHistory);
    }

}
