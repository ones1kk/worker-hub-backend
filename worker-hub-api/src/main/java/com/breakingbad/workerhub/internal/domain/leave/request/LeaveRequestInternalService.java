package com.breakingbad.workerhub.internal.domain.leave.request;

import com.breakingbad.workerhub.core.event.leave.LeaveApprovalEvent;
import com.breakingbad.workerhub.domain.constant.YesOrNo;
import com.breakingbad.workerhub.domain.leave.request.LeaveRequest;
import com.breakingbad.workerhub.domain.leave.request.repository.LeaveRequestRepository;
import com.breakingbad.workerhub.exception.NotFoundEntityException;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class LeaveRequestInternalService {

    private final ApplicationEventPublisher eventPublisher;

    private final LeaveRequestRepository leaveRequestRepository;

    public List<LeaveRequest> findAll() {
        return leaveRequestRepository.findAll();
    }

    public LeaveRequest findById(Long id) {
        return leaveRequestRepository.findById(id)
                .orElseThrow(() -> new NotFoundEntityException("존재하지 않은 휴가 신청입니다."));
    }

    @Transactional
    public LeaveRequest save(LeaveRequest leaveRequest) {
        return leaveRequestRepository.save(leaveRequest);
    }

    @Transactional
    public List<LeaveRequest> saveAll(List<LeaveRequest> leaveRequests) {
        return leaveRequestRepository.saveAll(leaveRequests);
    }

    public void approve(Long id) {
        LeaveRequest leaveRequest = findById(id);
        LeaveApprovalEvent event = LeaveApprovalEvent.createEvent(leaveRequest, YesOrNo.Y);
        eventPublisher.publishEvent(event);
    }

    public void refuse(Long id) {
        LeaveRequest leaveRequest = findById(id);
        LeaveApprovalEvent event = LeaveApprovalEvent.createEvent(leaveRequest, YesOrNo.N);
        eventPublisher.publishEvent(event);
    }

}
