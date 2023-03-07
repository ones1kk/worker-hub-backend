package com.breakingbad.workerhub.internal.domain.leave.history;

import com.breakingbad.workerhub.domain.leave.history.LeaveHistory;
import com.breakingbad.workerhub.domain.leave.history.repsoitory.LeaveHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class LeaveHistoryInternalService {

    private final LeaveHistoryRepository historyRepository;

    @Transactional
    public LeaveHistory save(LeaveHistory leaveHistory) {
        return historyRepository.save(leaveHistory);
    }

    @Transactional
    public List<LeaveHistory> saveAll(List<LeaveHistory> leaveHistories) {
        return historyRepository.saveAll(leaveHistories);
    }

}
