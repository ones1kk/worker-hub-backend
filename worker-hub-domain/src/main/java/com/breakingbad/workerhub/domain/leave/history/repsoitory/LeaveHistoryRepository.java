package com.breakingbad.workerhub.domain.leave.history.repsoitory;

import com.breakingbad.workerhub.domain.leave.history.LeaveHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaveHistoryRepository extends JpaRepository<LeaveHistory, Long> {
}
