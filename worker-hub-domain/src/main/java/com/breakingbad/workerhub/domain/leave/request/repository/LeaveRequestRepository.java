package com.breakingbad.workerhub.domain.leave.request.repository;

import com.breakingbad.workerhub.domain.leave.request.LeaveRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaveRequestRepository extends JpaRepository<LeaveRequest, Long> {
}
