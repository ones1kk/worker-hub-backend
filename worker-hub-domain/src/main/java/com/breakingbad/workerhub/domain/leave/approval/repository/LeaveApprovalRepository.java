package com.breakingbad.workerhub.domain.leave.approval.repository;

import com.breakingbad.workerhub.domain.leave.approval.LeaveApproval;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaveApprovalRepository extends JpaRepository<LeaveApproval, Long> {
}
