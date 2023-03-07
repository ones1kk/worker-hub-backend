package com.breakingbad.workerhub.internal.domain.leave.approval;

import com.breakingbad.workerhub.domain.leave.approval.LeaveApproval;
import com.breakingbad.workerhub.domain.leave.approval.repository.LeaveApprovalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class LeaveApprovalInternalService {

    private final LeaveApprovalRepository approvalRepository;

    @Transactional
    public LeaveApproval save(LeaveApproval leaveApproval) {
        return approvalRepository.save(leaveApproval);
    }

    @Transactional
    public List<LeaveApproval> saveAll(List<LeaveApproval> leaveApprovals) {
        return approvalRepository.saveAll(leaveApprovals);
    }


}
